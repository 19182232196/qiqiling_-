package Test20.modle;

public class User {
    private String id;
    private String name;
    private String password;
    private String email;
    private String birthday;

    public String getId(String id) {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName(String name) {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword(String password) {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail(String email) {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday(String birthday) {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    public User() {
        super();
    }
}
