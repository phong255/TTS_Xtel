import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

public class InsertThread implements Runnable{
    final Logger logger = Logger.getLogger("thread new");
    private CountDownLatch latch ;
    Database database;
    Student student;

    @Override
    public void run() {
        Connection connection = null;
        try {
            logger.info("--------------starting----------------");
            latch.await();
            connection = database.getConnect();
            String query = "insert into  student(sname,sage,saddress) values ('" + student.getSname() + "'," + student.getAge() + ",'" + student.getAddress() + "')";
            PreparedStatement statement = connection.prepareStatement(query);
            try{
                statement.execute();

            }catch (Exception e){
                e.printStackTrace();
            }
            connection.close();
            logger.info("------------inserted------------");
        } catch (ClassNotFoundException e) {
            logger.warning(e.getMessage());
        } catch (SQLException e) {
            logger.warning(e.getMessage());
        } catch (InterruptedException e) {
            logger.warning(e.getMessage());
        }
    }

    public InsertThread(CountDownLatch latch, Database database, Student student) {
        this.latch = latch;
        this.database = database;
        this.student = student;
    }
}
