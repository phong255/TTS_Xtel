import java.io.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void writeFile() throws IOException {
        OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream("billion_num.txt"));
        Random rd = new Random();
        long i=0;
        while(i<1000000000){
            ow.write(rd.nextInt(10,99));
            i++;
        }
    }
    public static byte[] readFile() throws IOException{
        FileInputStream ir = new FileInputStream("billion_num.txt");
        byte[] b = ir.readAllBytes();
        ir.close();
        return b;
    }

    public static void main(String[] args) {
        try{
//            writeFile();
            byte[] b = readFile();
            long start = System.nanoTime();
            Sort s = new Sort();
            //Sap xep tron
            s.merge_sort(b,0,b.length-1);
            //Sap xep nhanh
//            s.quicksort(b,0,b.length-1);
            long end = System.nanoTime();
//            for(byte x : b){
//                System.out.println(x);
//            }
            long timeInMillis = TimeUnit.SECONDS.convert(end - start, TimeUnit.NANOSECONDS);
            System.out.println("Time spend in ms: " + timeInMillis);
        }catch (IOException e){
            e.printStackTrace();
        }
        //Ket qua do :
        // - merge_sort : sap xep trong 35s
        // - quick_sort : sap xep trong 68s
    }
}