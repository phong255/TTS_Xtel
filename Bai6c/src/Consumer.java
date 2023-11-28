import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable{
    Logger logger = Logger.getLogger("Consumer");
    MessageProcess messageProcess;

    public Consumer(MessageProcess messageProcess) {
        this.messageProcess = messageProcess;
    }

    @Override
    public void run(){
        try{
            messageProcess.takeMess();
        }
        catch (InterruptedException e){
            logger.log(Level.WARNING,e.getMessage());
        }
    }
}
