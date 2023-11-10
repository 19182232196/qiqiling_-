const express = require('express');
const mysql = require('mysql2');
const querystring = require('querystring');

const app = express();
const server = app.listen(8080, () => {
    console.log('Server running on port 8080');
});

app.use(express.static('public'));

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
                res.status(500).send('数据库连接失败');
                return;
            }

            connection.query('INSERT INTO user (userName, userPwd) VALUES (?, ?)', [userName, userPwd], (err, results, fields) => {
                connection.release();

                if (err) {
                    res.status(500).send('注册失败');
                } else {
                    res.status(200).send('<a href="/index.html">登录</a>');
                }
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
                res.status(500).send('数据库连接失败');
                return;
            }

            connection.query('SELECT * FROM user WHERE userName=? AND userPwd=?', [userName, userPwd], (err, results, fields) => {
                connection.release();

                if (err) {
                    res.status(500).send('登录失败');
                } else {
                    if (results.length > 0) {
                        res.status(200).send('<a href="/index.html">登录</a>');
                    } else {
                        res.status(401).send('用户名或密码不正确');
                    }
                }
            });
        });
    });
});
