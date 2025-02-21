public class InsertionSort extends SortingAlgorithm{

    public void sort(int a[]){
        int n = a.length;
        for (int j = 1; j < n; j++){
            int key = a[j];
            int i = j-1;
            while ((i >= 0) && (a[i] > key)){
                a[i+1] = a[i];
                i--;
            }
            a[i+1] = key;
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
   