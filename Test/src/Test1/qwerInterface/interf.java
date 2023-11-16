package Test1.qwerInterface;

import Test1.qwerObj.*;

import java.util.ArrayList;
//定义接口
public interface interf {
    //查询所有的人员信息
    public abstract ArrayList<obj> show();
    //登录
    public abstract obj Login(String id ,String password);
    //注册
    public abstract int signUp(String id,String name,String password,String email,String birthday);
    //删除
    public abstract int delUser(String id);
    //修改
    public abstract int updateUser(String comlue, String value,String id);
    //根据学号查找用户
    public abstract obj searchUserById(String id);
}
