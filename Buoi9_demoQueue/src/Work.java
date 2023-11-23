import java.util.Random;

public class Work implements Runnable{
    @Override
    public void run() {
        int i=0;
        Random rd = new Random();
        while (i<10){
            System.out.print((char)rd.nextInt(97,122));
            i++;
        }
        System.out.println("\n");
    }
}
