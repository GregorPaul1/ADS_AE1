import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class SortingAlgorithm{


    public int[] fileReader(String fileName){

        //Creating list to read from the file
        List<Integer> numberList = new ArrayList<Integer>();

        //Reading from the file into the list
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null){
                numberList.add(Integer.parseInt(line));
            }
            reader.close();
        } catch(IOException e){
            e.printStackTrace();
        }

        //Changing list into array
        int numbersArray[] = new int[numberList.size()];
        for (int i = 0; i < numberList.size(); i++) {
            numbersArray[i] = numberList.get(i);
        }
        return numbersArray;
    }



    public boolean isSorted(int a[]){
        int n = a.length;
        for (int i = 0; i < n-1; i++){
            if (a[i] > a[i+1]){
                return false;
            }
        }
        return true;
    }

    }


