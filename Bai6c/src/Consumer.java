import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable{
    Logger logger = Logger.getLogger("Consumer");

    MessageProcess messageProcess;

    public Consumer(MessageProcess messageProcess){
        this.messageProcess =  messageProcess;
    }

    @Override
    public void run(){
        Random rd = new Random();
        TimerTask task = new TimerTask() {
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
        timer.schedule(task,0,1L);
    }
}
