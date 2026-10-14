import org.csu.cpsc.GenericSortingLibrary;
import org.csu.cpsc.IntegerSortingLibrary;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInsertionSort {
    @Test
    public void testInsertionSortGenericOne(){
        List<Double> list = new ArrayList<Double>();
        list.add(1.5);
        list.add(2.5);

        GenericSortingLibrary<Double> genericSortingLibrary = new GenericSortingLibrary<Double>(new DoubleComparator());
        list = genericSortingLibrary.insertionSort(list);


        List<Double> sortedList = new ArrayList<Double>();
        sortedList.add(1.5);
        sortedList.add(2.5);

        for(int i = 0; i < list.size(); i++){
            assertEquals(list.get(i).toString(), sortedList.get(i).toString());
        }
    }

    @Test
    public void testInsertionSortGenericTwo(){
        List<Double> list = new ArrayList<Double>();
        list.add(2.5);
        list.add(1.5);

        GenericSortingLibrary<Double> genericSortingLibrary = new GenericSortingLibrary<Double>(new DoubleComparator());
        list = genericSortingLibrary.insertionSort(list);

        List<Double> sortedList = new ArrayList<Double>();
        sortedList.add(1.5);
        sortedList.add(2.5);

        for(int i = 0; i < list.size(); i++){
            assertEquals(list.get(i).toString(), sortedList.get(i).toString());
        }
    }

    @Test
    public void testInsertionSortGenericThree(){
        List<Double> sortedList = new ArrayList<Double>();
        List<Double> unsortedList = new ArrayList<Double>();
        for(int i = 0; i < 1000; i++){
            Double rand = Math.random();
            sortedList.add(rand);
            unsortedList.add(rand);
        }

        sortedList.sort(new DoubleComparator());

        GenericSortingLibrary<Double> genericSortingLibrary = new GenericSortingLibrary<Double>(new DoubleComparator());
        unsortedList = genericSortingLibrary.insertionSort(unsortedList);

        for(int i = 0; i < 1000; i++){
            assertEquals(sortedList.get(i), unsortedList.get(i));
        }

    }

    @Test
    public void testInsertionSortIntegerOne(){
        int[] array = {1,2,3,4};
        IntegerSortingLibrary.insertionSort(array);

        int[] sortedArray = {1,2,3,4};


        for(int i = 0; i < array.length; i++){
            assertEquals(array[i], sortedArray[i]);
        }
    }

    @Test
    public void testInsertionSortIntegerTwo(){
        int[] array = {1,3,2,4};
        IntegerSortingLibrary.insertionSort(array);

        int[] sortedArray = {1,2,3,4};


        for(int i = 0; i < array.length; i++){
            assertEquals(array[i], sortedArray[i]);
        }
    }


    private class DoubleComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            return Double.compare((double) o1, (double) o2);
        }
    }
}