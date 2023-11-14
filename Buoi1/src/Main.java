import java.io.*;

public class Main {
    //Sắp xếp nhanh quick sort
    public static void quick_sort(int a[],int l, int r){
        int mid = (l+r)/2;
        int i = l;
        int j = r;
        while(l<r){
            while(i < j && a[i] < a[mid]) i++;
            while(j > i && a[j] > a[mid]) j--;
            if(i>j)
                break;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        if(l>j) quick_sort(a,l,j);
        if(i<r) quick_sort(a,i,r);
    }

    //Xóa 1 phần tử trong mảng
    private static void del(int a[], int index){
        int n = a.length;
        for(int i=index-1;i<n-1;i++) {
            a[i] = a[i + 1];
        }
    }

    // Stream
    private static void printFile(File fileIn,File fileOut) throws IOException {
        InputStream fileInputStream = new FileInputStream(fileIn);
        OutputStream fileOutputStream = new FileOutputStream(fileOut);
        int c;
        //Doc, ghi file text
        while((c = fileInputStream.read()) != -1){
            System.out.println((char) c);
            fileOutputStream.write(c);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    // Character stream
    private static void printFile(String fileIn,String fileOut) throws IOException{
        FileReader fileReader = new FileReader(fileIn);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(fileOut);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        //Doc, ghi file text
        String content = bufferedReader.readLine();
        System.out.println(content);
        bufferedWriter.write(content);
        bufferedWriter.close();
        bufferedReader.close();
        fileReader.close();
        fileWriter.close();
    }

    public static void main(String[] args) {
//        int a[] = {10, 20, 40, 30};
//        int r = a.length;
//        quick_sort(a,0,r-1);
//        for(int i=0;i<4;i++){
//            System.out.println(a[i]);
//        }
//        del(a,2);
//        for(int i=0;i<r-1;i++){
//            System.out.println(a[i]);
//        }
//        File f = new File("test.txt");
//        File f2 = new File("testOut.txt");
        try{
            printFile("test.txt","testOut.txt");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}