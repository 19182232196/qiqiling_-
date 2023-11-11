const express = require('express');
const mysql = require('mysql2');
const querystring = require('querystring');
const ejs = require('ejs');
const cors = require('cors'); // 引入 cors 模块
const bodyParser = require('body-parser');


const app = express();
app.set('view engine', 'ejs');
app.use(cors()); // 使用 cors 中间件
app.use(express.static('public'));
app.use(bodyParser.urlencoded({ extended: true }));

const server = app.listen(8080, () => {
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
    let postVal = '';
    req.on('data', (chunk) => {
        postVal += chunk;
    });
    req.on('end', () => {
        let formVal = querystring.parse(postVal);
        let userName = formVal.userName;
        let userPwd = formVal.userPwd;

        pool.getConnection((err, connection) => {
            if (err) {
                res.status(500).send(err);
                return;
            }

            // 检查用户名是否已存在
            connection.query('SELECT * FROM user WHERE userName = ?', [userName], (err, results, fields) => {
                if (err) {
                    res.status(500).send(err);
                    connection.release();
                    return;
                }

                if (results.length > 0) {
                    res.status(409).send('<a href="/index-q.html">返回</a>');
                    connection.release();
                    return;
                }

                // 注册用户
                connection.query('INSERT INTO user (userName, userPwd) VALUES (?, ?)', [userName, userPwd], (err, results, fields) => {
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
});


app.post('/login', (req, res) => {
    let postVal = '';
    req.on('data', (chunk) => {
        postVal += chunk;
    });
    req.on('end', () => {
        let formVal = querystring.parse(postVal);
        let userName = formVal.userName;
        let userPwd = formVal.userPwd;

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
                        res.status(401).send('用户名或密码不正确<a href="/index.html">登录</a>');
                    }
                }
            });
        });
    });
});

app.post('/performDatabaseAction', (req, res) => {
    const { userName, userPwd, operationType } = req.body;

    pool.getConnection((err, connection) => {
        if (err) {
            res.status(500).send(err);
            return;
        }

        if (operationType === 'add') {
            connection.query('INSERT INTO user (userName, userPwd) VALUES (?, ?)', [userName, userPwd], (err, results) => {
            connection.release();

                if (err) {
                    res.status(500).send('添加用户失败<a href="/main.html">返回</a>');
                } else {
                    res.status(200).send('用户已添加<a href="/main.html">返回</a>');
                }
            });
        } else if (operationType === 'delete') {
        connection.query('DELETE FROM user WHERE userName = ?', [userName], (err, results) => {
            connection.release();

            if (err) {
                res.status(500).send('删除用户失败<a href="/main.html">返回</a>');
            } else {
                res.status(200).send('用户已删除<a href="/main.html">返回</a>');
            }
        });
        } else if (operationType === 'update') {
            connection.query('UPDATE user SET userPwd = ? WHERE userName = ?', [userPwd, userName], (err, results) => {
                connection.release();

                if (err) {
                    res.status(500).send('更新用户密码失败<a href="/main.html">返回</a>');
                } else {
                    res.status(200).send('用户密码已更新<a href="/main.html">返回</a>');
                }
            });
        } else {
            res.status(400).send('未知操作类型<a href="/main.html">返回</a>');
        }
    });
});

