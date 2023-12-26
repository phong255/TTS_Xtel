import Database.Database;
import Exceptions.IOFileException;
import org.apache.log4j.Logger;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class Main {
    final static Logger logger = Logger.getLogger(Main.class);
    static Database database = new Database();
    //----Insert student vào database-----
    public static void insert(ArrayList<Student> students) throws SQLException, ClassNotFoundException{
        Connection connection = database.getConnect();
        for(Student student : students){
            String query = "insert into  student(sname,sage,saddress) values ('" + student.getSname() + "'," + student.getAge() + ",'" + student.getAddress() + "')";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        }
        connection.close();
    }

    //Lưu dữ liệu student vào file
    public static void writeFile(ArrayList<Student> students) throws IOException{
        FileWriter fileWriter = new FileWriter("students.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for(Student s : students){
            String line = s.toString();
            bufferedWriter.write(line);
        }
        bufferedWriter.close();
        fileWriter.close();
    }

    //Đọc dữ liệu student từ file
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

    public static void main(String[] args){
//        writeFile();
//        System.out.println(readFile().size());
//        if(insert(readFile())){
//            System.out.println("insert success");
//        }
//        else
//            System.err.println("insert fail!");
//        long start = System.nanoTime();
        int i=0;
        CountDownLatch latch = new CountDownLatch(1);
        //------1000 threads insert vào database .
        /* Kết quả : Lỗi do quá nhiều kết nối => insert không đủ số bản ghi */
//        while(i<1000){
//            Student student = new Student("stu"+i,i++,"addr"+i);
//            InsertThread insertThread = new InsertThread(latch,database,student);
//            Thread thread = new Thread(insertThread);
//            thread.start();
//        }
//        latch.countDown();
//        long end = System.nanoTime();
//        long timeInMillis = TimeUnit.SECONDS.convert(end - start, TimeUnit.NANOSECONDS);
//        System.out.println("Time spend in ms: " + timeInMillis);
        //----------------------------------------------------------------------------------------------

        //----insert 1000 bản ghi trên 1 thread
        // Kết quả : mất 3s
//        ArrayList<Student> students = new ArrayList<>();
//        long start = System.nanoTime();
//        while(i<1000){
//            Student student = new Student("stu"+i,i++,"addr"+i);
//            students.add(student);
//        }
//        insert(students);
//        long end = System.nanoTime();
//        long timeInMillis = TimeUnit.SECONDS.convert(end - start, TimeUnit.NANOSECONDS);
//        System.out.println("Time spend in second: " + timeInMillis);
        //-------------------------------------------------------------------------------------------

        //-------insert nhiều bản ghi trên 3 thread---------------
        //Kết quả : mỗi thread mất 1 s
        ArrayList<Student> students;
        try {
            students = readFile();
        } catch (IOException e) {
            throw new IOFileException(e);
        }
        ArrayList<Student> students1 = new ArrayList<>();
        ArrayList<Student> students2 = new ArrayList<>();
        ArrayList<Student> students3 = new ArrayList<>();
        for (Student stu : students){
            if(i<330)
                students1.add(stu);
            else if(i>330 && i<660)
                students2.add(stu);
            else
                students3.add(stu);
            i++;
        }
        Thread thread1 = new Thread(new InsertThread(latch,database,students1));
        Thread thread2 = new Thread(new InsertThread(latch,database,students2));
        Thread thread3 = new Thread(new InsertThread(latch,database,students3));
        thread1.start();
        thread2.start();
        thread3.start();
        latch.countDown();
        //------------------------------------------------------------------------------------
    }
}