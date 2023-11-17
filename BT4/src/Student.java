public class Student {
    private int sid;
    private String sname;
    private int age;
    private String address;

    public Student() {
    }

    public Student(int sid, String sname, int age, String address) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.address = address;
    }

    public Student(String sname, int age, String address) {
        this.sname = sname;
        this.age = age;
        this.address = address;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return     sid +
                "-" + sname +
                "-" + age +
                "-" + address + "\n";
    }
}
