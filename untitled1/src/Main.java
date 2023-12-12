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
        ow.close();
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
//            byte[] b = {3,4,2,10,9,7};
            long start = System.nanoTime();
            Sort s = new Sort();
            //Sap xep tron
//            s.merge_sort(b,0,b.length-1);
            //Sap xep nhanh
//            s.quick_sort(b,0,b.length-1);
            //Sap xep heap sort
//            s.heapSort(b);
            //Sap xep shell sort
            s.shell_sort(b);
            long end = System.nanoTime();
//            for(byte x : b){
//                System.out.println(x);
//            }
            long timeInMillis = TimeUnit.SECONDS.convert(end - start, TimeUnit.NANOSECONDS);
            System.out.println("Time spend in ms: " + timeInMillis);
        }catch (Exception e){
            e.printStackTrace();
        }
        //Ket qua do :
        // - merge_sort : out of memory
        // - quick_sort : sap xep trong 68s
        // - heap_sort : sap xep trong 135s
        // - shell_sort : sap xep trong 187s
    }
}