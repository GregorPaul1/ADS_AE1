public class ShellSort extends SortingAlgorithm{

    public void sort(int a[]){
        int n = a.length;
        int h = 1;
       
        while (h < n/3) h = 3*h + 1;

        while (h >= 1) {
            for (int i = h; i < n; i++){
                for (int j = i; j >= h && a[j] < a[j-h]; j -= h){
                    swap(a, j, j-h);
                }
            }
            h /= 3;
        }
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
