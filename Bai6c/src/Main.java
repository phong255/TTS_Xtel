import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static final Logger logger = Logger.getLogger("main");
    static BlockingQueue<String> messages = new ArrayBlockingQueue<>(5);
    static MessageProcess messageProcess = new MessageProcess(messages);
    public static void main(String[] args) {
        Random rd = new Random();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try{
                    messageProcess.addMess("message " + rd.nextInt(100,10000));
                }
                catch (InterruptedException e){
                    logger.log(Level.WARNING,e.getMessage());
                }
            }
        };
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                try{
                    messageProcess.takeMess();
                }
                catch (InterruptedException e){
                    logger.log(Level.WARNING,e.getMessage());
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(task2,0,1L);
        timer.schedule(task,0,1L);
    }
}