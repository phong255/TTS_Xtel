public class Main {
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

    private static void del(int a[], int index){
        int n = a.length;
        for(int i=index-1;i<n-1;i++) {
            a[i] = a[i + 1];
        }
    }

    public static void main(String[] args) {
        int a[] = {10, 20, 40, 30};
        int r = a.length;
        quick_sort(a,0,r-1);
        for(int i=0;i<4;i++){
            System.out.println(a[i]);
        }
        del(a,2);
        for(int i=0;i<r-1;i++){
            System.out.println(a[i]);
        }
    }
}