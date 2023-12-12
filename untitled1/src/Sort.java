public class Sort {
    private void merge(byte[] a,int l,int m,int r){
        int n1 = m - l + 1, n2 = r - m;
        int i=0,j=0,k=l;
        while(i<n1 && j< n2){
            if(a[i] <= a[m+1+j]){
                a[k] = a[i];
                i++;
            }
            else{
                a[k] = a[m+1+j];
                j++;
            }
            k++;
        }
        while(i<n1){
            a[k] = a[i];
            i++;
            k++;
        }
        while(j<n2){
            a[k] = a[m+1+j];
            j++;
            k++;
        }
    }
    public void merge_sort(byte[] a,int l,int r){
        if(l<r){
            int m = (l+r)/2;
            merge_sort(a,l,m);
            merge_sort(a,m+1,r);
            merge(a,l,m,r);
        }
    }
    public void quick_sort(byte[] a,int l,int r){
        int m = (l+r)/2;
        int i = l, j = r;
        while(l<r){
            while(a[i] < a[m]) i++;
            while(a[j] > a[m]) j--;
            if(i > j)
                break;
            byte temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        if(i<r) quick_sort(a,i,r);
        if(l<j) quick_sort(a,l,j);
    }
}
