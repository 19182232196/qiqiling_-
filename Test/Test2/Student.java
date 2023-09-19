package Test2;
class Student {
    private String name;
    private String age;
    private String id;
    private  String sex;
    private String classname;

    public Student(String name, String age, String id, String sex, String classname){
        this.name = name;
        this.age = age;
        this.id = id;
        this.sex = sex;
        this.classname = classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getClassname() {
        return classname;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}