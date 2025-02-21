public class HybridInsertionSort extends SortingAlgorithm{

    public void sortCutOff(int a[], int p, int r, int n){

        if (r <= p + n - 1){
            insertionSort(a, p, r);
            return;
        }
       int q = p + (r - p) / 2;
       sort (a, p, q);
       sort (a, q+1, r);
       merge(a, p, q, r);
    }

    public void merge(int a[], int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
       
        for (int i=0; i<n1; i++)
        L[i] = a[p + i];
        for (int j=0; j<n2; j++)
        R[j] = a[q + 1+ j];
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
       
        int i = 0;
        int j = 0;
        for (int k=p; k<= r; k++){
            if(L[i] <= R[j]){
                a[k] = L[i];
                i++;
            }
            else{
                a[k] = R[j];
                j++;
            }
        }
 }

    public void sort(int a[], int p, int r){
        if (p < r){
            int q = (p+r)/2;
            sort(a, p, q);
            sort(a , q+1, r);
            merge(a, p, q, r);
        }
    }

    public void insertionSort(int a[], int p, int r){
        for (int i = p + 1; i < r; i++){
            for (int j = i; j > p && a[j] < a[j-1]; j--){
            swap(a, j, j-1);
            }
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

    
       
