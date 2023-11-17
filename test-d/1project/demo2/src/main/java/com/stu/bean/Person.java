package com.stu.bean;

public class Person {
    // 用户账号
    private String userAccount;
    // 用户名
    private String userName;
    // 用户性别
    private String userSex;
    // 用户生日
    private String userBirthday;
    // 用户身份证
    private String userIdCard;
    // 用户密码
    private String userPassword;
    // 用户认证
    private int userIdentify;
    // 用户其他名称
    private String userOtherName;
    public Person() {
        // 默认构造函数
    }
    public Person(String userAccount, String userName, String userSex, String userBirthday, String userIdCard, String userPassword, int userIdentify, String userOtherName) {
        // 构造函数，用于初始化Person对象
        this.userAccount = userAccount;
        this.userName = userName;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
        this.userIdCard = userIdCard;
        this.userPassword = userPassword;
        this.userIdentify = userIdentify;
        this.userOtherName = userOtherName;
    }
    public Person(String userAccount, String userPassword) {
        // 构造函数，用于初始化Person对象
        this.userAccount = userAccount;
        this.userPassword = userPassword;
    }
    public String getUserAccount() {
        return userAccount;
    }
    //设置用户账号
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
    //获取用户名
    public String getUserName() {
        return userName;
    }
    //设置用户名
    public void setUserName(String userName) {
        this.userName = userName;
    }
    //获取用户性别
    public String getUserSex() {
        return userSex;
    }
    //设置用户性别
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
    //获取用户生日
    public String getUserBirthday() {
        return userBirthday;
    }
    //设置用户生日
    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }
    //获取用户身份证号
    public String getUserIdCard() {
        return userIdCard;
    }
    //设置用户身份证号
    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }
    //获取用户密码
    public String getUserPassword() {
        return userPassword;
    }
    //设置用户密码
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    //获取用户认证
    public int getUserIdentify() {
        return userIdentify;
    }
    //设置用户认证
    public void setUserIdentify(int userIdentify) {
        this.userIdentify = userIdentify;
    }
    //获取用户其他认证
    public String getUserOtherName() {
        return userOtherName;
    }
    //设置用户其他认证
    public void setUserOtherName(String userOtherName) {
        // 设置用户其他名字
        this.userOtherName = userOtherName;
    }
    @Override
    public String toString() {
        // 返回用户信息
        return "Person{" +
                "userAccount='" + userAccount + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userIdCard='" + userIdCard + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userIdentify=" + userIdentify +
                ", userOtherName='" + userOtherName + '\'' +
                '}';
    }
}