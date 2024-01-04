package Models;

public class Student {
    private int id;
    private String sname;
    private String sage;
    private String saddress;
    public Student(){}

    public Student(String sname, String sage, String saddress) {
        this.sname = sname;
        this.sage = sage;
        this.saddress = saddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSage() {
        return sage;
    }

    public void setSage(String sage) {
        this.sage = sage;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }
}
