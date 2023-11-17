import java.util.Scanner;

public class Main {
    private static float electricBill(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so dien: ");
        int electric = sc.nextInt();
        if(electric < 100 && electric > 0)
            return (float) electric*1000;
        else if(electric >= 100 && electric < 150)
            return  (float) electric*1500;
        else
            return (float) electric*2000;
    }
    public static void main(String[] args) {
        System.out.println("Electric bill:" + electricBill());
    }
}