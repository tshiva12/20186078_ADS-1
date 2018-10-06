import java.util.Scanner;
/**
 * Merge class.
 */
class QuickSort {
    /**
     * integer variable seven.
     */
    private final int seven = 7;
    /**
     * Constructs the object.
     */
    QuickSort() {
        //default constructor is not used.
    }
    /**
     * Partition method is used to partition the array based on pivot element.
     * Tine complexity is N.
     * 
     * @param      a     Comparable.
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     return j.
     */
    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) { 
            while (less(a[++i], v)) {
                if (i == hi) break;
            }
            while (less(v, a[--j])) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }
    /**
     * less method is a compare method.
     * Time complexity of less method is 1.
     *
     * @param      x     comparable.
     * @param      y     comparable.
     *
     * @return     return boolean value.
     */
    public boolean less(final Comparable x, final Comparable y) {
        return x.compareTo(y) < 0;
    }
    /**
     * Sort method is used for sorting. Time complexity of sort method is logN.
     *
     * @param      arr     The array
     * @param      lo      The lowwer value
     * @param      hi      The higher value
     * @param      cutOff  The cut off
     */
    public void sort(final Comparable[] arr,
                     final int lo, final int hi, int cutOff) {
        if (hi <= lo + cutOff - 1) {
            insertionSort(arr, lo, hi);
            System.out.println("insertionSort called");
            return;
        }
        int j = partition(arr, lo, hi);
        System.out.println(show(arr));
        sort(arr, lo, j-1, cutOff);
        sort(arr, j+1, hi, cutOff);
    }
    /**
     * sort method is used to sort the array with copy of that array. Time
     * complexity of Sort method is 1.
     *
     * @param      a       { parameter_description }
     * @param      cutOff  The cut off
     */
    public void sort(Comparable[] a, int cutOff) {
        sort(a, 0, a.length - 1, cutOff);
    }
    /**
     * insertion sort is a sorting technique.
     * It is used when size of array is lessthan 7.
     * Time complexity of insertion sort is N^2.
     *
     * @param      arr3  The arr 3
     * @param      lo    The lowwer value
     * @param      hi    The higher value
     */
    public void insertionSort(final Comparable[] arr3,
                              final int lo, final int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(arr3[j], arr3[j - 1]); j--) {
                exchange(arr3, j, j - 1);
            }
        }
    }
    /**
     * exchange methods is used to swap the elements in the array.
     * Time complexity of exch method is 1.
     *
     * @param      arr4  The arr 4
     * @param      i     {Integer i}
     * @param      j     {Integer j}
     */
    public void exchange(final Object[] arr4,
                     final int i, final int j) {
        Object swap = arr4[i];
        arr4[i] = arr4[j];
        arr4[j] = swap;
    }
    /**
     * show method is used to display the ouyput.
     * Time complexity for show method is N.
     *
     * @param      array  The array
     *
     * @return     return string.
     */
    public String show(final Comparable[] array) {
        String str = "[";
        int i;
        for (i = 0; i < array.length - 1; i++) {
            str += array[i] + ", ";
        }
        str += array[array.length - 1] + "]";
        return str;
    }
}
/**
 * class Solution.
 */
public final class Solution {
    private Solution() {
        // default constructor is not used.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        QuickSort qsort = new QuickSort();
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            int j = Integer.parseInt(scan.nextLine());
            String[] tokens = scan.nextLine().split(" ");
            if (tokens[0].equals("")) {
                System.out.println("[]");
            } else {
                qsort.sort(tokens, j);
                System.out.println(qsort.show(tokens));
            }
        }
    }
}