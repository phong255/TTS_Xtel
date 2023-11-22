import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("n = ");
        long n = sc.nextLong();
        System.out.println("----------------------");
        Thread thread = new Thread(new inSoNguyenRunnable(n));
        System.out.println(thread.getState());
        thread.start();
    }
}