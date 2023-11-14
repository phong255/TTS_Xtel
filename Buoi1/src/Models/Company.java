package Models;

import java.util.List;

public class Company {
    private int id;
    private String cname;
    private int countEmp;
    private List<Employee> employees;

    public Company() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCountEmp() {
        return countEmp;
    }

    public void setCountEmp(int countEmp) {
        this.countEmp = countEmp;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Company(int id, String cname, int countEmp, List<Employee> employees) {
        this.id = id;
        this.cname = cname;
        this.countEmp = countEmp;
        this.employees = employees;
    }

}
