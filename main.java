import org.csu.cpsc.IntegerSortingLibrary;
import org.csu.cpsc.GenericSortingLibrary;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class main {
    public static void main(String[] args) {
        //Testing A Integer Sorting Function

        int[] array = {5,2,10,4,5,1};
        array = IntegerSortingLibrary.bubbleSort(array);

        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + ",");
        }

        System.out.println();

        //Testing A Generic Sorting Function
        List<Double> list = new ArrayList<Double>();
        list.add(1.5);
        list.add(3.2);
        list.add(1.0);
        list.add(2.5);

        GenericSortingLibrary<Double> genericSortingLibrary = new GenericSortingLibrary<Double>(new DoubleComparator());
        list = genericSortingLibrary.bubbleSort(list);

        System.out.println(list.toString());
    }


    private static class DoubleComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return Double.compare((double) o1, (double) o2);
        }
    }
}
