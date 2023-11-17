import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    private static void writeFile() throws IOException{
        FileWriter fw = new FileWriter("input.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        int a[] = {1,3,2,6,4,9,5};
        String line = "";
        for (int i : a){
            line += i + "-";
        }
        bw.write(line);
        bw.close();
        fw.close();
    }
    private static void readFile() throws IOException {
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        String num[] = line.trim().split("-");
        int a[];
        a = new int[num.length];
        for(int i=0;i<num.length;i++){
            a[i] = Integer.parseInt(num[i].trim());
            System.out.print(a[i] + "   ");
        }
        System.out.println("\n-   -   -   -   -   -   -");
        quicksort(a,0,a.length-1);

        for (int i : a) {
            System.out.print(i + "   ");
        }
        br.close();
        fr.close();
    }

    private static void quicksort(int a[],int l,int r){
        int mid = (l+r)/2;
        int i = l;
        int j = r;
        while(i<j){
            while(a[i] < a[mid]) i++;
            while(a[j] > a[mid]) j--;
            if(i>j)
                break;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        if(l<j) quicksort(a,l,j);
        if(i<r) quicksort(a,i,r);
    }
    public static void main(String[] args) {
        System.out.println("---------------------------");
        try{
            writeFile();
            readFile();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}