public class HybridInsertionSortForQuick extends SortingAlgorithm{

    private static final int INSERTION_SORT_THRESHOLD = 10;

    // Hybrid Sort function that uses QuickSort and InsertionSort
    public void sort(int[] a, int p, int r) {
        if (r - p + 1 <= INSERTION_SORT_THRESHOLD) {
            insertionSort(a, p, r);  // Use InsertionSort for small subarrays
        } else {
            int q = partition(a, p, r); // Partition the array using QuickSort's method
            sort(a, p, q -1);        // Recursively sort the left part
            sort(a, q + 1, r);    // Recursively sort the right part
        }
    }

    // Insertion Sort implementation
    public void insertionSort(int[] a, int p, int r) {
        for (int i = p + 1; i <= r; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= p && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    // Partition function for QuickSort
    private int partition(int[] a, int p, int r) {
        int pivot = a[r];  // Choosing the last element as the pivot
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (a[j] <= pivot) {
                i++;
                // Swap elements at i and j
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        // Swap the pivot element with the element at i + 1
        int temp = a[i + 1];
        a[i + 1] = a[r];
        a[r] = temp;
        return i + 1; // Return the pivot index
    }

    public void findAverage(String[] fileList){

        for (String file: fileList){
            long average = 0;
            for (int count = 0; count <10; count ++){
                int list[] = fileReader(file);
                int length = list.length;
                long start = System.nanoTime();
                sort(list,  0, length -1);
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
