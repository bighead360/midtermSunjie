import java.util.ArrayList;
import java.util.List;

/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 5/18/16.
 */
public class SortPN {

    private int[] array;
    private int[] tempMergArr;
    private int length;

    public static void main(String[] args) {
        int[] inputArr = {-10, 10, 3, 1, 11, 2, -8, -3, 3, -1};
        SortPN mms = new SortPN();
        mms.sortArray(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }

    }

    int[] sortArray(int[] arrayContainsPostiveAndNegativeIntegers){
        this.length = arrayContainsPostiveAndNegativeIntegers.length;
        this.array = arrayContainsPostiveAndNegativeIntegers;
        this.tempMergArr = new int[length];
        List<Integer> PostiveArr = new ArrayList<Integer>();
        for(int i =0; i<length; i++){
            if (array[i]>0){
                PostiveArr.add(array[i]);
            }
        }
        doMergeSort(0,length-1);


    };

    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            System.out.print("the midindex is" + middle  + "\n");
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;

        System.out.print("the j is" + j + "\n");
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k++] = tempMergArr[i++];

            } else {
                array[k++] = tempMergArr[j++];

            }
        }
        System.out.print("the  s i is" + i + "\n");

        while (i <= middle) {
            System.out.print("the tempMergArr[i] is" + tempMergArr[i] + "\n");
            System.out.print("the k is" + k + "\n");
            array[k++] = tempMergArr[i++];

        }

        while (j <= higherIndex) {
            array[k++] = tempMergArr[j++];
        }


    }





}
