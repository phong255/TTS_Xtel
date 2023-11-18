import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    static Database database = new Database();
    public static boolean insert(ArrayList<Student> students) throws SQLException, ClassNotFoundException{
        Connection connection = database.getConnect();
        boolean bool = true;
        for(Student student : students){
            String query = "insert into  student(sname,sage,saddress) values ('" + student.getSname() + "'," + student.getAge() + ",'" + student.getAddress() + "')";
            PreparedStatement statement = connection.prepareStatement(query);
            try{
                statement.execute();
            }catch (Exception e){
                e.printStackTrace();
                bool = false;
            }
        }
        connection.close();
        return bool;
    }

    public static void writeFile() throws IOException{
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1,"phong",18,"phuc yen, vinh phuc"));
        students.add(new Student(2,"hue",18,"phuc yen, vinh phuc"));
        students.add(new Student(3,"hoa",18,"phuc yen, vinh phuc"));
        FileWriter fileWriter = new FileWriter("students.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for(Student s : students){
            String line = s.toString();
            bufferedWriter.write(line);
        }
        bufferedWriter.close();
        fileWriter.close();
    }
    public static ArrayList<Student> readFile() throws IOException{
        FileReader fileReader = new FileReader("students.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Student> students = new ArrayList<>();
        String line = bufferedReader.readLine();
        String info[] = line.trim().split("-");
        students.add(new Student(Integer.parseInt(info[0]),info[1],Integer.parseInt(info[2].trim()),info[3]));
        while(line != null){
            line = bufferedReader.readLine();
            if(line == null)
                break;
            info = line.trim().split("-");
            students.add(new Student(Integer.parseInt(info[0]),info[1],Integer.parseInt(info[2].trim()),info[3]));
        }
        bufferedReader.close();
        fileReader.close();
        return students;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        writeFile();
        System.out.println(readFile().size());
        if(insert(readFile())){
            System.out.println("insert success");
        }
        else
            System.out.println("insert fail!");
    }
}