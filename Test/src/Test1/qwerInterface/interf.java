package Test1.qwerInterface;

import Test1.qwerObj.*;

import java.util.ArrayList;
//定义接口
public interface interf {
    //显示所有用户
    public abstract ArrayList<obj> show();
    //登录
    public abstract obj Login();
    //注册
    public abstract int signUp();
    //删除
    public abstract int delUser();
    //修改
    public abstract int updateUser();
    //根据学号查找用户
    public abstract obj searchUserById(String id);
}
