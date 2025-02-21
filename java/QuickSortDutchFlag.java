public class QuickSortDutchFlag extends SortingAlgorithm{

    public static void sort (int a[], int l, int r){
        if (r <= l) return;
            int v = a[r];
            int i = l-1, j = r, p = l-1, q = r, k;
            for (;;){
                while (a[++i]<v);
                while (v < a[--j]) if (j == l) break;
                if (i >= j) break;
                swap(a, i, j);
                if (a[i] == v) {p++; swap(a, p, i);}
                if (v == a[j]) {q--; swap(a,q,j);}
        }
        swap(a, i, r);
        j = i - 1;
        i = i + 1;
        for (k = l; k <= p; k++,j--) swap(a, k, j);
        for (k = r-1; k >=q; k--,i++) swap(a, k, i);
        sort(a, l, j);
        sort(a, i, r);
       }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void findAverage(String[] fileList){

        for (String file: fileList){
            long average = 0;
            for (int count = 0; count <10; count ++){
                int list[] = fileReader(file);
                int length = list.length;
                long start = System.nanoTime();
                sort(list,  0, length - 1);
                long finish = System.nanoTime();
                if (isSorted(list)){
                    average = average + (finish - start);
                }
                else{
                    count = count - 1;
                }
            }
            average = average/10;
            System.out.println(file + " has average time of " + average);
        }
    }
}
