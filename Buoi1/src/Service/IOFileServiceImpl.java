package Service;

import Models.Employee;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class IOFileServiceImpl implements IOFileService{
    public ArrayList<Employee> readFile(String filename) throws IOException, ParseException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        ArrayList<Employee> employees = new ArrayList<>();
        while(line != null){
            line = bufferedReader.readLine();
            if(line == null)
                break;
            String[] info = line.split("-");
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(info[0].trim()));
            employee.setName(info[1]);
            employee.setAge(Integer.parseInt(info[2].trim()));
            if (info[3].equals("Nam"))
                employee.setGender(true);
            else
                employee.setGender(false);
            employee.setPosition(info[4]);
            employee.setDepartment(info[5]);
            Date startTime = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy").parse(info[6].trim());
            employee.setStartTime(startTime);
            employees.add(employee);
        }
        bufferedReader.close();
        fileReader.close();
        return employees;
    }

    @Override
    public void writeFile(String filename,ArrayList<Employee> employees) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Employee employee:employees){
            StringBuilder info = new StringBuilder();
            info.append(employee.getId()+" - ");
            info.append(employee.getName()+" - ");
            info.append(employee.getAge()+" - ");
            if(employee.isGender())
                info.append("Nam - ");
            else
                info.append("Nữ - ");
            info.append(employee.getPosition()+" - ");
            info.append(employee.getDepartment()+" - ");
            info.append(employee.getStartTime());
            bufferedWriter.write(info.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        fileWriter.close();
    }

}
