package org.csu.cpsc;
public class IntegerSortingLibrary{
    public static int[] bubbleSort(int[] array) {
        for (int stopIndex = array.length - 1; stopIndex > 0; stopIndex--) {
            for (int index = 0; index < stopIndex; index++) {
                if (array[index] > array[index + 1]) {
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }

        return array;
    }

    public static int[] insertionSort(int[] array){
        for(int nextPosition=1; nextPosition < array.length;nextPosition++){
            int nextValue= array[nextPosition];
            int i= nextPosition- 1;

            while(i>=0 && array[i] > nextValue){
                array[i+1]= array[i];
                i--;
            }
            array[i+1] = nextValue;
        }
        return array;
    }

    public static int[] mergeSort(int[] array) {
        int tableSize = array.length;

        if (tableSize > 1) {
            int halfSize = tableSize / 2;

            int[] leftTable = new int[halfSize];
            int[] rightTable = new int[tableSize - halfSize];

            for (int i = 0; i < halfSize; i++) {
                leftTable[i] = array[i];
            }

            for (int i = halfSize; i < tableSize; i++) {
                rightTable[i - halfSize] = array[i];
            }

            leftTable = mergeSort(leftTable);
            rightTable = mergeSort(rightTable);

            /* Adding Merge Method for Merge Sort here */
            int leftTableIndex = 0;
            int rightTableIndex = 0;
            int arrayIndex = 0;

            while (leftTableIndex < leftTable.length &&
                    rightTableIndex < rightTable.length) {

                if (leftTable[leftTableIndex] <= rightTable[rightTableIndex]) {
                    array[arrayIndex] = leftTable[leftTableIndex];
                    leftTableIndex++;
                } else {
                    array[arrayIndex] = rightTable[rightTableIndex];
                    rightTableIndex++;
                }

                arrayIndex++;
            }

            while (leftTableIndex < leftTable.length) {
                array[arrayIndex] = leftTable[leftTableIndex];
                leftTableIndex++;
                arrayIndex++;
            }

            while (rightTableIndex < rightTable.length) {
                array[arrayIndex] = rightTable[rightTableIndex];
                rightTableIndex++;
                arrayIndex++;
            }
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        for(int fill=0; fill< array.length-1; fill++){
            int positionMin= fill;
            for(int next= fill + 1; next < array.length; next++){
                if(array[next] < array[positionMin]){
                    positionMin= next;
                }
            }

            int temp = array[fill];
            array[fill] = array[positionMin];
            array[positionMin] = temp;
        }
        return array;
    }
}
