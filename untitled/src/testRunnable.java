import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class testRunnable implements Runnable {
    public static void writeFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("Bai6a.txt",false));
            Random rd = new Random();
            bw.write(String.valueOf(rd.nextInt(1,100000)));
            bw.newLine();
        bw.close();
    }
    @Override
    public void run() {
        try{
            boolean bool = true;
            do {
                Scanner sc = new Scanner(System.in);
                String s = sc.nextLine();
                if(s.equals("stop")){
                    bool = false;
                }
                writeFile();
            }while(bool);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
