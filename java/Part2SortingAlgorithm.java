public class Part2SortingAlgorithm{

    private static int INSERTION_SORT_THRESHOLD = 10;
    
    public int[] kHighestValues(int list[], int k){
        sort(list, 0, list.length -1);
        int result[] = new int[k];
        System.arraycopy(list, list.length - k, result, 0, k);
        return result;
    }

    private void sort(int list[], int left, int right){
        if (right - left + 1 <= INSERTION_SORT_THRESHOLD){
            insertionSort(list, left, right);
        }
        else{
            int mid = (left + right)/2;
            sort(list, left, mid);
            sort(list, mid+1, right);
            merge(list, left, mid, right);
        }
    }

    private void merge(int a[], int p, int q, int r){
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

    private void insertionSort(int a[], int p, int r){
        for (int i = p + 1; i <= r; i++){
            for (int j = i; j > p && a[j] < a[j-1]; j--){
            swap(a, j, j-1);
            }
        }       
    }

    private void swap(int a[], int i, int j){
        int temporary = a[i];
        a[i] = a[j];
        a[j] = temporary;
    }


    public void main(String[] args){

        int list[] = {3,2,1,45, 666665656, 778657, 57, 45453, 3344, 45, 45 ,54355, 45, 6676, 24, 2467, 9876};
        int[] newList = kHighestValues(list, 3);
        for (int item: newList){
            System.out.println(item);
        }
        

    }
}
