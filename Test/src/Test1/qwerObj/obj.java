package Test1.qwerObj;

public class obj {
    // 定义id属性
    private String id;
    // 定义name属性
    private String name;
    // 定义password属性
    private String password;
    // 定义email属性
    private String email;
    // 定义birthday属性
    private String birthday;

    // 获取id属性
    public String getId() {
        return id;
    }
    // 设置id属性
    public void setId(String id) {
        this.id = id;
    }
    // 获取name属性
    public String getName() {
        return name;
    }
    // 设置name属性
    public void setName(String name) {
        this.name = name;
    }
    // 获取password属性
    public String getPassword() {
        return password;
    }
    // 设置password属性
    public void setPassword(String password) {
        this.password = password;
    }
    // 获取email属性
    public String getEmail() {
        return email;
    }
    // 设置email属性
    public void setEmail(String email) {
        this.email = email;
    }
    // 获取birthday属性
    public String getBirthday() {
        return birthday;
    }
    // 设置birthday属性
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    // 重写toString方法
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", birthday="
                + birthday + "]";
    }
    // 构造函数
    public obj() {
        super();
    }
}
