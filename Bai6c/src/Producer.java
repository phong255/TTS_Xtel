import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable{
    private final Logger logger = Logger.getLogger("Producer");
    MessageProcess messageProcess ;
    public Producer(MessageProcess messageProcess){
        this.messageProcess = messageProcess;
    }
    @Override
    public void run() {
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
        Timer timer = new Timer();
        timer.schedule(task,0,1L);
    }
}
