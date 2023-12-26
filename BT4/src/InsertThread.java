import Database.Database;
import Exceptions.DatabaseException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class InsertThread implements Runnable{
    final Logger logger = Logger.getLogger(this.getClass());
    private CountDownLatch latch ;
    Database database;
    Student student;
    ArrayList<Student> students;
    public InsertThread(CountDownLatch latch, Database database, Student student) {
        this.latch = latch;
        this.database = database;
        this.student = student;
    }
    public InsertThread(CountDownLatch latch, Database database, ArrayList<Student> students) {
        this.latch = latch;
        this.database = database;
        this.students = students;
    }
    //-------insert 1 bản ghi---------------
    public synchronized void insert() throws InterruptedException, SQLException, ClassNotFoundException {
        Connection connection;
        logger.info("Start thread");
        latch.await();
        connection = database.getConnect();
        StringBuilder query = null;
        query.append("insert into  student(sname,sage,saddress) values ('");
        query.append(student.getSname()+ "',");
        query.append(student.getAge() + ",'");
        query.append(student.getAddress() + "')");
        PreparedStatement statement = connection.prepareStatement(query.toString());
        statement.execute();
        connection.close();
        logger.info("Insert success");
    }
    //-----insert nhiều bản ghi -------------------
    public synchronized void insertStudents() throws InterruptedException, SQLException, ClassNotFoundException {
        Connection connection;
        logger.info("Start thread");
        latch.await();
        connection = database.getConnect();
        long start = System.nanoTime();
        for(Student student : students){
            StringBuilder query = new StringBuilder();
                query.append("insert into  student(sname,sage,saddress) values ('").
                        append(student.getSname()+ "',").
                        append(student.getAge() + ",'").
                        append(student.getAddress() + "')");
            PreparedStatement statement = connection.prepareStatement(query.toString());
            statement.execute();
        }
        long end = System.nanoTime();
        long timeInMillis = TimeUnit.SECONDS.convert(end - start, TimeUnit.NANOSECONDS);
        System.out.println(this.getClass() + "Time spend in second: " + timeInMillis);
        connection.close();
        logger.info("Insert success");
    }
    @Override
    public void run() {
        try {
            insertStudents();
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            throw new DatabaseException(e);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new DatabaseException(e);
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
            throw new DatabaseException(e);
        }
    }
}
