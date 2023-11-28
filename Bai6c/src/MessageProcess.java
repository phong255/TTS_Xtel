import java.io.*;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;

public class MessageProcess {
    private final static Logger logger = Logger.getLogger("MessageProcess");
    BlockingQueue<String> messages = new ArrayBlockingQueue<>(5);

    String fname = "message.txt";
    public MessageProcess(BlockingQueue<String> messages) {
        this.messages = messages;
    }

    public synchronized void addMess(String message)throws InterruptedException {
        this.messages.put(message);
        logger.info("Add message success.");
    }

    public synchronized void takeMess()throws InterruptedException{
        String mess = this.messages.take();
        logger.info(mess);
    }
}
