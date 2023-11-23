import java.util.concurrent.*;

public class testThreadPoolExecutor {

    public static void main(String[] arg){
        BlockingQueue<Runnable> worksQueue = new ArrayBlockingQueue<>(1);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,6,10,TimeUnit.SECONDS,worksQueue,handler);
        for (int i=0;i<2;i++)
            threadPoolExecutor.execute(new Work());
        //Mỗi lần thực hiện ThreadPoolExecutor sẽ lần lượt sử dụng hết Thread rảnh để làm cùng
        //nên chương trình in ra với số lượng ky tự khác nhau ở mỗi vòng lặp
        threadPoolExecutor.shutdown();
    }
}
