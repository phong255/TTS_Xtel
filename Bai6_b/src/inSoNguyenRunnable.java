import java.time.LocalDateTime;
import java.util.*;

public class inSoNguyenRunnable implements Runnable{
    long n;
    public inSoNguyenRunnable(long n){
        this.n = n;
    }
    @Override
    public void run(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime later = now.plusMinutes(n);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Random rd = new Random();
                System.out.println(rd.nextInt(1,1000));
                LocalDateTime nowLater = LocalDateTime.now();
                if(nowLater.isAfter(later) || nowLater.equals(later))
                    cancel();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task,n,n);
    }
}
