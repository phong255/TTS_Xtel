package Service;

import Models.Company;
import Models.Employee;

import java.util.List;

public class IntroduceImpl implements  Introduce{
    @Override
    public void sayHi(String name) {
        System.out.println("Hello world! My name is " + name + "\n");
    }

    @Override
    public void listEmp(List<Employee> employees) {
        System.out.println("\n------------------LIST---EMPLOYEES-----------------\n");
        for(Employee e : employees){
            System.out.println(e.toString());
            e.introduceYourself(e.getName());
        }
        System.out.println("\n---------    Welcome to Xtel ! -----------");
    }

    @Override
    public void introCompany(Company company) {
        System.out.println("---------     Welcome to " + company.getCname());
        System.out.println("---------     We have total " + company.getCountEmp() + " employees.");
        this.listEmp(company.getEmployees());
    }
}
