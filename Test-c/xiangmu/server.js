const http = require('http');
const mysql = require('mysql2');
const querystring = require('querystring');

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

const server = http.createServer((req, res) => {
    if (req.method === 'POST') {
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
                    res.writeHead(500, { 'Content-Type': 'text/html;charset=utf-8' });
                    res.write('数据库连接失败');
                    res.end();
                    return;
                }

                if (req.url === '/register') {
                    connection.query('INSERT INTO user (userName, userPwd) VALUES (?, ?)', [userName, userPwd], (err, results, fields) => {
                        connection.release();

                        if (err) {
                            res.writeHead(500, { 'Content-Type': 'text/html;charset=utf-8' });
                            res.write('注册失败');
                            res.end();
                        } else {
                            res.writeHead(200, { 'Content-Type': 'text/html;charset=utf-8' });
                            res.write('注册成功');
                            res.end();
                        }
                    });
                } else if (req.url === '/login') {
                    connection.query('SELECT * FROM user WHERE userName=? AND userPwd=?', [userName, userPwd], (err, results, fields) => {
                        connection.release();

                        if (err) {
                            res.writeHead(500, { 'Content-Type': 'text/html;charset=utf-8' });
                            res.write('登录失败');
                            res.end();
                        } else {
                            if (results.length > 0) {
                                res.writeHead(200, { 'Content-Type': 'text/html;charset=utf-8' });
                                res.write('登录成功');
                                res.end();
                            } else {
                                res.writeHead(401, { 'Content-Type': 'text/html;charset=utf-8' });
                                res.write('用户名或密码不正确');
                                res.end();
                            }
                        }
                    });
                }
            });
        });
    } else {
        res.writeHead(404, { 'Content-Type': 'text/html;charset=utf-8' });
        res.write('Page Not Found');
        res.end();
    }
});

server.listen(8080, () => {
    console.log('Server running on port 8080');
});
