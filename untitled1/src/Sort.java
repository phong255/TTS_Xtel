public class Sort {
    private void merge(byte[] arr,int l,int m,int r){
//        int n1 = m - l + 1, n2 = r - m;
//        int i=0,j=0,k=l;
//        while(i<n1 && j < n2){
//            if(a[l+i] >= a[m+1+j]){
//                byte tm = a[k];
//                a[k] = a[m+1+j];
//                a[m+1+j] = tm;
//                j++;
//            }
//            else{
//                byte tm = a[k];
//                a[k] = a[l+i];
//                a[l+i] = tm;
//                i++;
//            }
//            k++;
//        }
//        while(i<n1){
//            byte tm = a[k];
//            a[k] = a[l+i];
//            a[l+i] = tm;
//            i++;
//            k++;
//        }
//        while(j<n2){
//            byte tm = a[k];
//            a[k] = a[m+1+j];
//            a[m+1+j] = tm;
//            j++;
//            k++;
//        }

            // Find sizes of two subarrays to be merged
            int n1 = m - l + 1;
            int n2 = r - m;

            // Create temp arrays
            byte L[] = new byte[n1];
            byte R[] = new byte[n2];

            // Copy data to temp arrays
            for (int i = 0; i < n1; ++i)
                L[i] = arr[l + i];
            for (int j = 0; j < n2; ++j)
                R[j] = arr[m + 1 + j];

            // Merge the temp arrays

            // Initial indices of first and second subarrays
            int i = 0, j = 0;

            // Initial index of merged subarray array
            int k = l;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                }
                else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

            // Copy remaining elements of L[] if any
            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }

            // Copy remaining elements of R[] if any
            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }

    }
    public void merge_sort(byte[] a,int l,int r){
        if(l<r){
            int m = l + (r-l)/2;
            merge_sort(a,l,m);
            merge_sort(a,m+1,r);
            merge(a,l,m,r);
        }
    }
    public void quick_sort(byte[] a,int l,int r){
        int m = (l+r)/2;
        int i = l, j = r;
        while(l<r){
            while(i<=r && a[i] < a[m]) i++;
            while(j>=0 && a[j] > a[m]) j--;
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
    public void heapSort(byte arr[]){
        byte temp;
        for (int i = arr.length / 2 - 1; i >= 0; i--){
            heapify(arr, arr.length, i);
        }

        for (int i = arr.length - 1; i > 0; i--){
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private void heapify(byte arr[], int n, int i){
        int MAX = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        byte temp;

        if (left < n && arr[left] > arr[MAX]) {
            MAX = left;
        }
        if (right < n && arr[right] > arr[MAX]) {
            MAX = right;
        }
        if (MAX != i) {
            temp = arr[i];
            arr[i] = arr[MAX];
            arr[MAX] = temp;
            heapify(arr, n, MAX);
        }
    }

    public void shell_sort(byte arr[])
    {
        int n = arr.length;

        for (int gap = n/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {
                byte temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
    }
}
