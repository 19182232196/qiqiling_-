package test8;


import java.util.Arrays;

/**
 *   抽奖管理类
 *   包括   定义数组大小的 构造方法 ，注册方法，登陆方法，删除账号的方法，抽奖的方法,打印主菜单的方法
 */
class Operation{
    private User[] users =null;  //声明一个 用户对象数组
    private int count=0;   		//记录元素个数

    /**
     *  创建一个 构造方法 ，初始化 系统存贮 用户信息的 数组大小
     *  默认为 10，输入小于0的数 也会为10
     */
    public Operation() {
        users = new User[10];
    }
    public Operation(int size) {
        if (size>0) {
            users = new User[size];   //创建 数组的大小
        }else {
            users = new User[10];
        }
    }

    /**
     *  注册方法
     *  添加方法,如果添加的数超出数组的范围，就扩建数组,实现动态数组
     *  向user的数组中添加数据（判断账号是否已经存在）
     *  记录元素个数，
     *  判断添加的 账号是否已经存在，只有账号不存在才会添加成功
     *  会员号 重复概率极低，暂放弃 考虑
     *  注册成功 后打印 一下 注册后的信息
     */
    public void add(User user) {
        if(count>=users.length) {       //判断数组有没有被 填满
            users = Arrays.copyOf(users, users.length*3/2+1);   //扩建原来的2/3
        }
        for (int i=0;i<count;i++) {         //遍历，循环查找，是否存在重复账号
            if (users[i].getName().equals(user.getName())) {    //判断用户名是否存在
                System.out.println("你输入的账号重复，请重新输入！！");
                return;   		 //结束方法
            }
        }
        users[count] = user;          	//添加数组
        count++; 						//更新count
        // 打印注册后的信息
        System.out.println("注册成功！！");
        System.out.println("用户名\t密码\t会员号");
        System.out.println(user.getName()+"\t"+user.getPassword()+"\t"+user.getNums());
    }

    /**
     * 登陆方法
     * 传入 一个 用户对象
     * 遍历用户数组 (users)，查找账号
     * 如果账号密码 对应 ，返回这个用户对象
     * 没找到，返回null
     */
    public User landing(User user) {
        //int state=0;        //记录登陆状态
        for (int i=0;i<count;i++) {    //   遍历
            if (users[i].getName().equals(user.getName())) {   //找到对应的账号
                if(users[i].getPassword().equals(user.getPassword())) {  //匹配密码是否正确
                    //state=1;
                    System.out.println("登陆成功，欢迎用户"+users[i].getName());
                    return users[i];   //返回这个 用户对象
                }
            }
        }
        System.out.println("账号密码不正确，请重新输入");
        return null;
    }

    /**
     *  抽奖方法
     *  传入用户对象 和 幸运号码(num)
     *  查看 对象的会员号  和幸运数字 是否 匹配
     */
    public void extract(User user,int num) {
        if (user.getNums()==num) {
            System.out.println("今天的幸运数字为:"+num+" ,你的会员号为:"+user.getNums()+",恭喜你中奖了");
        }else {
            System.out.println("今天的幸运数字为:"+num+" ,你的会员号为:"+user.getNums()+",今天不是你的幸运日!!!");
        }
    }

    /**
     *  删除 账号功能
     *  循环遍历 数组 ，先匹配到账号
     *  如果密码也匹配到，把删除位置以后的元素 往前挪一位，users[count] == null;把最后的元素释放
     *  count -1
     *
     */
    public void delete(String name,String password) {
        for (int i=0;i<count;i++) {    //   遍历
            if (users[i].getName().equals(name)) {   //找到对应的账号
                if(users[i].getPassword().equals(password)) {  //匹配密码是否正确
                    for(int j=i;j<count;j++) {      //把删除位置以后的元素 往前挪一位
                        users[i] = users[i+1];
                    }
                    users[count]=null;          //把原来数组最后一位 释放
                    count--;              //  count-1
                    System.out.println("删除用户成功");
                    return;
                }
            }
        }
        System.out.println("你输入的账号密码不匹配,请重新输入！！！");  //没有匹配到
    }

    /**
     *  修改密码的方法
     *  用第一个方法匹配账号密码，成功返回下标，失败返回-1
     *  再用第二个方法，传入下标和新密码
     *  把 新传入的密码 赋值给对应用户对象的密码属性
     */
    public int Modify1(String name,String password) {
        for (int i=0;i<count;i++) {    //   遍历
            if (users[i].getName().equals(name)) {   //找到对应的账号
                if(users[i].getPassword().equals(password)) {  //匹配密码是否正确
                    return i;
                }
            }
        }
        System.out.println("你输入的 账号密码不匹配，请重新输入！！");
        return -1;
    }
    public void Modify2(int i,String password1) {
        users[i].setPassword(password1);
        System.out.println("修改密码成功！！");
    }


    /**
     *  打印所有的账号 密码信息
     */
    public void print() {
        for (int i=0;i<count;i++) {   //遍历
            users[i].print();            //调用 用户类中的打印方法
        }
    }

    /**
     *  打印 主菜单的 方法
     */
    public void printMenu() {
        System.out.println("********欢迎进入富翁抽奖系统**********");
        System.out.println("             1.注册");
        System.out.println("             2.登陆");
        System.out.println("             3.抽奖");
        System.out.println("             4.查询");
        System.out.println("             5.修改密码");
        System.out.println("             6.删除账号");
        System.out.println("      \t      其他数字退出系统");
        System.out.println("*********************************");
    }
}
