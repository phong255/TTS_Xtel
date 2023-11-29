import java.io.*;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;

public class MessageProcess {
    private final static Logger logger = Logger.getLogger("MessageProcess");
    static BlockingQueue<String> messages = new ArrayBlockingQueue<>(5);
    public synchronized void takeMess()throws InterruptedException{
        String mess = messages.take();
        logger.info(mess);
    }
    public static synchronized void addMess(String message)throws InterruptedException {
        messages.put(message);
        logger.info("Add message success.");
    }
}
