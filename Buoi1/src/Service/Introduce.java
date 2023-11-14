package Service;

import Models.Company;
import Models.Employee;

import java.util.List;

public interface Introduce {
    public void sayHi(String name);
    public void listEmp(List<Employee> employees);
    public void  introCompany(Company company);
}
