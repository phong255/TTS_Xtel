import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static final Logger logger = Logger.getLogger("main");

    public static void main(String[] args) throws InterruptedException {
        MessageProcess messageProcess = new MessageProcess();
        BlockingQueue<Runnable> works = new ArrayBlockingQueue<>(2);
        Consumer consumer = new Consumer(messageProcess);
        Producer producer = new Producer(messageProcess);
        works.put(consumer);
        works.put(producer);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardOldestPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,5,1L, TimeUnit.SECONDS,works);
        threadPoolExecutor.execute(producer);
        threadPoolExecutor.execute(consumer);
    }
}