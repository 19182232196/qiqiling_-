package Test20;

// 定义一个User类
public class User {
    // 定义一个id变量
    private int id;
    // 定义一个username变量
    private String username;
    // 定义一个email变量
    private String email;

    // 定义一个构造函数，传入id，username，email
    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    // Getters and setters
    // 定义一个getter和setter方法
    // 获取id
    public int getId() {
        return id;
    }

    // 设置id
    public void setId(int id) {
        this.id = id;
    }

    // 获取username
    public String getUsername() {
        return username;
    }

    // 设置username
    public void setUsername(String username) {
        this.username = username;
    }

    // 获取email
    public String getEmail() {
        return email;
    }

    // 设置email
    public void setEmail(String email) {
        this.email = email;
    }
}
