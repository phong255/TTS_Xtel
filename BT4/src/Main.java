import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.ServerSocket;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

public class Main {
    final static Logger logger = Logger.getLogger("main");
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
        students.add(new Student(1,"phong1",18,"phuc yen, vinh phuc"));
        students.add(new Student(2,"hue1",18,"phuc yen, vinh phuc"));
        students.add(new Student(3,"hoa1",18,"phuc yen, vinh phuc"));
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
//        writeFile();
//        System.out.println(readFile().size());
//        if(insert(readFile())){
//            System.out.println("insert success");
//        }
//        else
//            System.err.println("insert fail!");
        CountDownLatch latch = new CountDownLatch(1);
        //1000 insert vào database . Kết quả : Lỗi do quá nhiều kết nối => insert không đủ số bản ghi
//        while(i<1000){
//            Student student = new Student("stu"+i,i++,"addr"+i);
//            InsertThread insertThread = new InsertThread(latch,database,student);
//            Thread thread = new Thread(insertThread);
//            thread.start();
//        }
        ServerSocket server = new ServerSocket(2505);
        JFrame frame = new JFrame();
        frame.setTitle("Dashboard");
        frame.setSize(300,400);
        JButton btn = new JButton("Chat: Client-Server");
        btn.setBounds(100,250, 100,30);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Server serverThread1 = new Server(server,"Server 1");   // Tạo thread mới để nhận tin từ client khác
                    Client client = new Client(); //Tạo client mới
                }
                catch(Exception ex){
                    logger.warning(ex.getMessage());
                }
                latch.countDown();
            }
        });
        frame.add(btn);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}