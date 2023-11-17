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
const io = require('socket.io')(server);

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
                    res.redirect('/main.html');
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
    res.sendFile(__dirname + '/views/main-q.html'); // 渲染聊天室页面
});

io.on('connection', (socket) => {
    console.log('New user connected');

    socket.on('chat message', (msg) => {
        io.emit('chat message', msg); // 广播消息给所有客户端
    });

    socket.on('disconnect', () => {
        console.log('User disconnected');
    });
});
