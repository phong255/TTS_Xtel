import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

public class ThreadSort implements Runnable{
    final Logger logger = Logger.getLogger("ThreadSort" + this.getClass());
    CountDownLatch latch;
    byte[] array;
    int left;
    int right;

    public ThreadSort(CountDownLatch latch,byte[] array, int left, int right) {
        this.latch = latch;
        this.array = array;
        this.left = left;
        this.right = right;
    }

    private void merge(){
        int l = left;
        int r = right;
        int m = (left + right)/2;
        int n1 = m - l + 1;
        int n2 = r - m;

        byte L[] = new byte[n1];
        byte R[] = new byte[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            }
            else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }

    }

    @Override
    public void run() {
        try {
            logger.info("Run.......");
            latch.await();
            merge();
            logger.info("done.......");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
