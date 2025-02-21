public class QuickSort extends SortingAlgorithm{

    private int partition(int a[], int p, int r){
        int x = a[r];
        int i = p - 1;
        for (int j = p; j < r; j++){
            if (a[j] <= x){
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i+1, r);
        return i + 1;
       }


       public void sort(int a[], int p, int r){
        if (r <= p) return;
        int q = partition(a, p, r);
        sort(a, p, q-1);
        sort(a, q+1, r);
       }

       public void swap(int a[], int i, int j){
        int temporary = a[i];
        a[i] = a[j];
        a[j] = temporary;
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
