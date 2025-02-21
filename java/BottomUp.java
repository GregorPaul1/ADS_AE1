public class BottomUp extends SortingAlgorithm {

    public static void sort(int[] a) {
        int n = a.length;
        
        // Start with subarrays of size 1, then 2, 4, 8, etc.
        for (int size = 1; size < n; size = size * 2) {
            // Merge subarrays in pairs of size 'size'
            for (int left = 0; left < n - size; left += 2 * size) {
                int mid = Math.min(left + size - 1, n - 1);
                int right = Math.min(left + 2 * size - 1, n - 1);
                merge(a, left, mid, right);
            }
        }
    }

    // Merge two sorted subarrays into one sorted array
    private static void merge(int[] a, int left, int mid, int right) {
        int n1 = mid - left + 1;   // Size of the left subarray
        int n2 = right - mid;      // Size of the right subarray
        
        // Temporary arrays for the two subarrays
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        // Copy data to temporary arrays
        System.arraycopy(a, left, L, 0, n1);
        System.arraycopy(a, mid + 1, R, 0, n2);
        
        // Merge the temporary arrays back into the original array
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k++] = L[i++];
            } else {
                a[k++] = R[j++];
            }
        }
        
        // Copy any remaining elements from L[]
        while (i < n1) {
            a[k++] = L[i++];
        }
        
        // Copy any remaining elements from R[]
        while (j < n2) {
            a[k++] = R[j++];
        }
    }


    public void findAverage(String[] fileList){

    for (String file: fileList){
        long average = 0;
        for (int count = 0; count <10; count ++){
            int list[] = fileReader(file);
            long start = System.nanoTime();
            sort(list);
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
