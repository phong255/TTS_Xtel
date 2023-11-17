import java.util.Scanner;

public class Main {
    private static void input(){
        Scanner sc = new Scanner(System.in);
        int i=0,num=0;
        do {
            System.out.println("Nhap so nguyen lon nhat co 1 chu so: ");
            num = sc.nextInt();
            if(num == 9){
                System.out.println("Ban da nhap chinh xac.");
            }
            i++;
        }while(num != 9 && i <= 4);
        if(i==5)
            System.out.println("Nhap khong dung!");
    }
    public static void main(String[] args) {
        input();
    }
}