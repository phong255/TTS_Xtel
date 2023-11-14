package Models;

import Models.AbstractClass.Person;

import java.util.Date;

public class Employee extends Person {
    private String position;
    private String department;
    private Date startTime;
    public Employee(){
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Employee(int eid, String ename, int age, boolean gender, String position, String department, Date startTime){
        super(eid,ename,age,gender);
        this.position = position;
        this.department = department;
        this.startTime = startTime;
    }
    @Override
    public void introduceYourself(String name) {
        System.out.println("Hi everyone! My name is " + name + " . I am an employee .");
    }

    @Override
    public String toString(){
        if(this.gender)
            return this.id + " - " + this.name + " - " + this.age + " - Nam - " + this.position + " - " + this.department + " - " + this.startTime.toString() + "\n";
        else
            return this.id + " - " + this.name + " - " + this.age + " - Nữ - " + this.position + " - " + this.department + " - " + this.startTime.toString() + "\n";
    }
}
