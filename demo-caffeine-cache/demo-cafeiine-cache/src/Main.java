
import Services.StudentService;
import org.apache.log4j.Logger;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args){
        StudentService studentService = new StudentService();
        int i=0;
        while(i<3){
            long begin = System.nanoTime();
            System.out.println(studentService.getAllStudent());
            long end = System.nanoTime();
            // log do dai thoi gian de lay du lieu
            log.info("Lay du lieu trong " + TimeUnit.MILLISECONDS.convert (end-begin,TimeUnit.NANOSECONDS) + " ms");
            i++;
        }
    }
    //Out put: co the xem trong file .log
    /*
        - Lay du lieu 3 lan:
            Lan 1 trong cache chua co du lieu -> lay trong database mat 247 ms va luu vao cache
            Lan 2 lay trong cache mat 1 ms
            Lan 3 lay trong cache mat 1 ms
     */
}