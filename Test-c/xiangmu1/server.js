const express = require('express');
const mysql = require('mysql2');
const querystring = require('querystring');
const ejs = require('ejs');
const cors = require('cors'); // 引入 cors 模块
const path = require('path');
const bodyParser = require('body-parser');
const http = require('http');
const socketIO = require('socket.io');

const app = express();
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));
app.use(cors()); // 使用 cors 中间件
app.use(express.static('public'));
app.use(bodyParser.urlencoded({ extended: true }));

const server = http.createServer(app);
const io = socketIO(server, {
    cors: {
        origin: "http://localhost:8080", // 允许访问的源
        methods: ["GET", "POST"] // 允许的 HTTP 方法
    }
});

app.use(express.static(__dirname + '/public'));

server.listen(8080, () => {
    console.log('ok');
});

const pool = mysql.createPool({
    host: 'localhost',
    user: 'root',
    password: '484110',
    database: 'demo1',
    port: 3306,
    waitForConnections: true,
    connectionLimit: 10,
    queueLimit: 0
});

app.post('/register', (req, res) => {
    const { userName, userPwd } = req.body;

    pool.getConnection((err, connection) => {
        if (err) {
            res.status(500).send(err);
            return;
        }

        connection.query('SELECT * FROM user WHERE userName = ?', [userName], (err, results) => {
            if (err) {
                connection.release();
                res.status(500).send(err);
                return;
            }

            if (results.length > 0) {
                connection.release();
                res.status(409).send('<a href="/index-q.html">返回</a>');
                return;
            }

            connection.query('INSERT INTO user (userName, userPwd) VALUES (?, ?)', [userName, userPwd], (err) => {
                connection.release();

                if (err) {
                    res.status(500).send('<a href="/index-q.html">返回</a>');
                } else {
                    res.status(200).send('<a href="/index.html">登录</a>');
                }
            });
        });
    });
});


app.post('/login', (req, res) => {
    const { userName, userPwd } = req.body;

    pool.getConnection((err, connection) => {
        if (err) {
            res.status(500).send(err);
            return;
        }

        connection.query('SELECT * FROM user WHERE userName=? AND userPwd=?', [userName, userPwd], (err, results, fields) => {
            connection.release();

            if (err) {
                res.status(500).send(err);
            } else {
                if (results.length > 0) {
                    res.redirect('/new+daohang.html');
                } else {
                    res.redirect('/index.html');
                }
            }
        });
    });
});

app.get('/students', (req, res) => {
    pool.getConnection((err, connection) => {
        if (err) {
            res.status(500).send(err);
            return;
        }

        connection.query('SELECT * FROM user', (err, results) => {
            connection.release();

            if (err) {
                res.status(500).send(err);
                return;
            }

            // 渲染学生列表页面，将学生数据传递给模板
            res.render('students', { students: results });
        });
    });
});

// 编辑学生信息
app.post('/editStudent', (req, res) => {
    const { id, userName, userPwd } = req.body;

    pool.getConnection((err, connection) => {
        if (err) {
            res.status(500).send(err);
            return;
        }

        connection.query('UPDATE user SET userName = ?, userPwd = ? WHERE id = ?', [userName, userPwd, id], (err, results) => {
            connection.release();

            if (err) {
                res.status(500).send(err);
            } else {
                // 成功后重定向回学生列表页面
                res.redirect('/students');
            }
        });
    });
});

// 删除学生
app.post('/deleteStudent', (req, res) => {
    const { id } = req.body;

    pool.getConnection((err, connection) => {
        if (err) {
            res.status(500).send(err);
            return;
        }

        connection.query('DELETE FROM user WHERE id = ?', [id], (err, results) => {
            connection.release();

            if (err) {
                res.status(500).send('删除学生失败');
            } else {
                // 成功后重定向回学生列表页面
                res.redirect('/students');
            }
        });
    });
});

app.get('/chatroom', (req, res) => {
    res.sendFile(__dirname + '/main-q.html');
});

io.on('connection', (socket) => {
    console.log('New user connected');

    socket.on('message', (msg) => {  // 修复这里的事件名
        io.emit('message', msg);
    });

    socket.on('disconnect', () => {
        console.log('User disconnected');
    });
});

app.post('/performDatabaseAction', (req, res) => {
    const userName = req.body.userName;
    const userPwd = req.body.userPwd;
    const operationType = req.body.operationType;

    pool.getConnection((err, connection) => {
        if (err) {
            res.status(500).send(err);
            return;
        }

        switch (operationType) {
            case 'add':
                // 执行添加操作，根据需要修改 SQL 语句
                connection.query('INSERT INTO user (userName, userPwd) VALUES (?, ?)', [userName, userPwd], (err) => {
                    connection.release();
                    if (err) {
                        res.status(500).send(err);
                    } else {
                        res.status(200).send('添加用户成功');
                    }
                });
                break;
            case 'delete':
                // 执行删除操作，根据需要修改 SQL 语句
                connection.query('DELETE FROM user WHERE userName = ?', [userName], (err) => {
                    connection.release();
                    if (err) {
                        res.status(500).send(err);
                    } else {
                        res.status(200).send('删除用户成功');
                    }
                });
                break;
            case 'update':
                // 执行更新操作，根据需要修改 SQL 语句
                connection.query('UPDATE user SET userPwd = ? WHERE userName = ?', [userPwd, userName], (err) => {
                    connection.release();
                    if (err) {
                        res.status(500).send(err);
                    } else {
                        res.status(200).send('更新用户成功');
                    }
                });
                break;
            default:
                res.status(400).send('无效的操作类型');
        }
    });
});

app.post('/user', (req, res) => {
    const userName = req.body.userName;
    const sql = `SELECT * FROM user WHERE userName = '${userName}'`;
    pool.query(sql, (err, result) => {
        if (err) {
            throw err;
        }
        if (result.length > 0) {
            const userData = result[0];
            const message = `ID: ${userData.id}\nUserName: ${userData.userName}\nUserPwd: ${userData.userPwd}`;
            res.send(message);
        } else {
            res.send('未找到匹配用户');
        }
    });
});