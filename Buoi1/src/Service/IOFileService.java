package Service;

import Models.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public interface IOFileService {
    public ArrayList<Employee> readFile(String filename) throws IOException, ParseException;
    public void writeFile(String filename,ArrayList<Employee> employee) throws IOException;
}
