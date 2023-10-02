package Test2;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//增删改查
class Manager {
    //自定义一个方法，用于添加学生信息
    public static void add(ArrayList<Student> list) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入学号");
        // 接受键盘录入的数据
        String id = in.nextLine();
        System.out.println("请输入姓名");
        String name = in.nextLine();
        System.out.println("请输入性别");
        String sex = in.nextLine();
        System.out.println("请输入年龄");
        String age = in.nextLine();
        System.out.println("请输入班级");
        String classname = in.nextLine();

        // 创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
        Student s = new Student(id, name, sex, age, classname);

        // 添加学生对象到集合中
        list.add(s);

        System.out.println("添加成功");
    }

    public static void remove(ArrayList<Student> list) {
        Scanner in=new Scanner(System.in);
        System.out.println("请输入学号");
        String id=in.nextLine();

        for(int i=0;i<list.size();i++){
            Student s=list.get(i);
            if(s.getId().equals(id)){
                list.remove(i);
                //循环会一个一个数据匹配直到与我们输入的学号相同然后删除，相当于扫描
                System.out.println("删除成功");
                break;
            }
        }
    }
    public static void introduce(ArrayList<Student> list){
        Scanner in=new Scanner(System.in);
        System.out.println("请输入学号");
        String id=in.nextLine();

        //键盘录入要修改的学生信息
        System.out.println("请输入姓名");
        String name=in.nextLine();
        System.out.println("请输入性别");
        String sex=in.nextLine();
        System.out.println("请输入年龄");
        String age=in.nextLine();
        System.out.println("请输入班级");
        String classname=in.nextLine();

        //创建学生对象,赋值给学生对象，匹配后与对应数据进行替换
        Student s = new Student(id,name,sex,age,classname);
        s.setId(id);
        s.setName(name);
        s.setSex(sex);
        s.setAge(age);
        s.setClassname(classname);

        //遍历集合循环匹配学生学号将对应学生从集合里修改
        for(int i=0;i<list.size();i++){
            Student s1=list.get(i);
            if(s1.getId().equals(id))
            {
                list.set(i,s);//删除指定位置插入指定元素
                break;
            }
        }
        System.out.println("修改成功");
    }
    public static void find(ArrayList<Student> list){
    Scanner in=new Scanner(System.in);
    System.out.println("请输入学号");
    String Fid=in.nextLine();//接收学号作为字符串输入
    boolean found=false;// 用于标记是否找到匹配的学生信息
    for(Student student:list){
        if(student.getId().equals(Fid)){
            System.out.println("找到匹配的学生信息:");
            System.out.println("学号: " + student.getId());
            System.out.println("姓名: " + student.getName());
            System.out.println("性别: " + student.getSex());
            System.out.println("年龄: " + student.getAge());
            System.out.println("班级: " + student.getClassname());
            found = true; // 标记为已找到
            break; // 找到匹配的学生信息后，退出循环
            }
        }
        if (!found) {
            System.out.println("未找到匹配的学生信息");
        }
    }
    public static void save(ArrayList<Student> list) {
        System.out.println("请输入要保存的文件路径：");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine(); // 接收文件路径

        try {
            FileWriter fw = new FileWriter(path);
            for (Student s : list) {
                fw.write("学号: " + s.getId() + "\t姓名: " + s.getName()
                        + "\t性别: " + s.getSex() + "\t年龄: " + s.getAge()
                        + "\t班级: " + s.getClassname() + "\n");
            }
            fw.close(); // 关闭文件写入流
            System.out.println("数据已成功保存到文件：" + path);
        } catch (IOException e) {
            System.err.println("保存文件时发生错误：" + e.getMessage());
        }
    }
}