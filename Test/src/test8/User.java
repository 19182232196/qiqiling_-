package test8;

/**
 *  用户信息类 （vo）
 */
class User{
    /*
     * 封装用户属性
     * 如果 同时 只能一个人在线 这不用定义 state 属性
     */
    private String name;  //账号
    private String password;  //密码
    private int nums;		//会员号

    // private int state;   //状态

    public User() {}  //默认构造方法
    public User(String name,String password,int nums) {
        this.name = name;
        this.password = password;
        this.nums = nums;
    }
    // getter and setter 方法
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setNums(int nums) {
        this.nums = nums;
    }
    public int getNums() {
        return nums;
    }

    // 输出方法
    public void print() {
        System.out.println("name:"+name+" , pasword:"+password+" , membersNum:"+nums);
    }
}
