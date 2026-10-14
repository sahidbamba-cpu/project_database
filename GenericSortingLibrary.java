package org.csu.cpsc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GenericSortingLibrary<E> {
    private Comparator<? super E> c;

    public GenericSortingLibrary(Comparator<? super E> c){
        this.c = c;
    }

    public List<E> bubbleSort(List<E> array){
        for(int stopIndex = array.size() -1; stopIndex > 0; stopIndex--) {
            for (int index = 0; index < stopIndex; index++) {
                if (c.compare(array.get(index), array.get(index+1)) > 0) {
                    E temp = array.get(index);
                    array.set(index, array.get(index+1));
                    array.set(index + 1, temp);
                }
            }
        }
        return array;
    }

    public List<E> insertionSort(List<E> array){
        for(int nextPosition= 1; nextPosition < array.size();nextPosition++){
            E nextValue= array.get(nextPosition);
            int i= nextPosition- 1;

            while(i >= 0 &&c.compare(array.get(i), nextValue) > 0){
                array.set(i + 1, array.get(i));
                i--;
            }
            array.set(i + 1, nextValue);
        }
        return array;

    }

    public List<E> mergeSort(List<E> array){
        int tableSize = array.size();

        if (tableSize > 1) {
            int halfSize = tableSize / 2;

            List<E> leftTable = new ArrayList<>();
            List<E> rightTable = new ArrayList<>();

            for (int i = 0; i < halfSize; i++) {
                leftTable.add(array.get(i));
            }

            for (int i = halfSize; i < tableSize; i++) {
                rightTable.add(array.get(i));;
            }

            leftTable = mergeSort(leftTable);
            rightTable = mergeSort(rightTable);

            /* Adding Merge Method for Merge Sort here */
            int leftTableIndex = 0;
            int rightTableIndex = 0;
            int arrayIndex = 0;

            while (leftTableIndex < leftTable.size() && rightTableIndex < rightTable.size()) {

                if (c.compare(leftTable.get(leftTableIndex), rightTable.get(rightTableIndex)) <= 0) {
                    array.set(arrayIndex, leftTable.get(leftTableIndex));
                    leftTableIndex++;
                } else {
                    array.set(arrayIndex, rightTable.get(rightTableIndex));
                    rightTableIndex++;

                }

                arrayIndex++;
            }
            while (leftTableIndex < leftTable.size()) {
                array.set(arrayIndex, leftTable.get(leftTableIndex));
                leftTableIndex++;
                arrayIndex++;
            }

            // Copy remaining right-side values
            while (rightTableIndex < rightTable.size()) {
                array.set(arrayIndex, rightTable.get(rightTableIndex));
                rightTableIndex++;
                arrayIndex++;
            }
        }
        return array;
    }

    public List<E> selectionSort(List<E> array){
        for(int fill=0; fill< array.size() -1; fill++){
            int positionMin= fill;
            for(int next= fill + 1; next < array.size(); next++){
                if(c.compare(array.get(next), array.get(positionMin))  < 0){
                    positionMin= next;
                }
            }

            E temp = array.get(fill);
            array.set(fill, array.get(positionMin));
            array.set(positionMin, temp);
        }
        return array;
    }
}