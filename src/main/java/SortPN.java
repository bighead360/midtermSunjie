/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 5/18/16.
 * Time complexity: O(nlogn)
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

    public void sortArray(int[] arrayContainsPostiveAndNegativeIntegers){
        this.length = arrayContainsPostiveAndNegativeIntegers.length;
        this.array = arrayContainsPostiveAndNegativeIntegers;
        this.tempMergArr = new int[length];

        doMergeSort(0,length-1);
        int negpoint = 0;

        for(int i =0; i< length; i++){
            if (array[i]<0){
                negpoint = i - 1;
                break;
            }
        }


        int startpoint =0;
        while( startpoint < negpoint){
            int temp = array[negpoint];
            array[negpoint] = array[startpoint];
            array[startpoint] = temp;

            negpoint--;
            startpoint++;

        }

    }

    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
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


        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] >= tempMergArr[j]) {
                array[k++] = tempMergArr[i++];

            } else {
                array[k++] = tempMergArr[j++];

            }
        }


        while (i <= middle) {
            array[k++] = tempMergArr[i++];

        }

        while (j <= higherIndex) {
            array[k++] = tempMergArr[j++];
        }


    }





}
