public class SelectionSort extends SortingAlgorithm{
    
    public void sort(int a[]){
        int n = a.length;
        for (int i = 0; i < n - 1; i++){
            int index = i;
            //find minimum
            for (int j = i + 1; j < n; j++){
                if (a[j] < a[index]){
                    index = j;
                }
            }
            //swap
            int min = a[index];
            a[index] = a[i];

            a[i] = min;
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
