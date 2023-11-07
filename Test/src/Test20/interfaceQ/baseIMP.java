package Test20.interfaceQ;

import Test20.modle.User;

import java.util.ArrayList;

public interface baseIMP {
    public abstract ArrayList<User> show();
    public abstract User Login();

    public abstract int signUp();

    public abstract int delUser();

    public abstract int updateUser();

    public abstract User searchUserById(String id);
}
