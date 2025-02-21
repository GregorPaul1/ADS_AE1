public class MedianOfThree extends SortingAlgorithm{

    public void sort(int[] a, int low, int high) {
        if (low < high) {
            // Get the pivot index using the median of three method
            int pivotIndex = medianOfThree(a, low, high);
            
            // Partition the array around the pivot and get the pivot position
            int pivotPosition = partition(a, low, high, pivotIndex);
            
            // Recursively sort the left and right subarrays
            sort(a, low, pivotPosition - 1);
            sort(a, pivotPosition + 1, high);
        }
    }

    // Median of Three to select the pivot
    private int medianOfThree(int[] a, int low, int high) {
        int mid = low + (high - low) / 2;

        // Sort the first, middle, and last element to find the median
        if (a[low] > a[mid]) {
            swap(a, low, mid);
        }
        if (a[low] > a[high]) {
            swap(a, low, high);
        }
        if (a[mid] > a[high]) {
            swap(a, mid, high);
        }

        // Return the middle element as the pivot
        return mid;
    }

    // Partition the array around the pivot
    private static int partition(int[] a, int low, int high, int pivotIndex) {
        int pivot = a[pivotIndex];
        swap(a, pivotIndex, high); // Move pivot to the end
        int i = low - 1;

        // Move elements smaller than pivot to the left of the pivot
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }

        // Move the pivot into its correct position
        swap(a, i + 1, high);

        return i + 1; // Return the index of the pivot
    }

    // Swap two elements in the array
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
                sort(list,  0, length-1);
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
