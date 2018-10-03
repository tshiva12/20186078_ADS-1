import java.util.Scanner;
/**
 * Merge class.
 */
class Merge {
    /**
     * integer variable seven
     */
    private final int seven = 7;
    /**
     * Constructs the object.
     */
    Merge() {
        //default constructor is not used.
    }
    /**
     * Merge method is used to merge the array in ascending order. Time
     * Time complexity of merge method is N.
     *
     * @param      array  The array
     * @param      aux    The auxiliary
     * @param      lo     The lower value
     * @param      mid    The middle value
     * @param      hi     The higher value
     */
    public void merge(final Comparable[] a, final Comparable[] aux,
                      final int lo, final int mid, final int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                aux[k] = a[j++];
            } else if (j > hi) {
                aux[k] = a[i++];
            } else if (less(a[j], a[i])) {
                aux[k] = a[j++];
            } else {
                aux[k] = a[i++];
            }
        }
        assert isSorted(aux, lo, hi);
    }
    /**
     * Sort method is used for sorting.
     * Time complexity of sort method is logN.
     *
     * @param      arr   The array
     * @param      aux   The auxiliary array
     * @param      lo    The lowwer value
     * @param      hi    The higher value
     */
    public void sort(final Comparable[] arr, final Comparable[] aux,
                     final int lo, final int hi) {
        if (hi <= lo + seven) {
            insertionSort(aux, lo, hi);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid + 1, hi);
        if (!less(arr[mid + 1], arr[mid])) {
            for (int i = lo; i <= hi; i++) {
                aux[i] = arr[i];
            }
            System.out.println(
                "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merge(arr, aux, lo, mid, hi);
    }
    /**
     * sort method is used to sort the array with copy of that array.
     *
     * @param      arr1  The arr 1
     */
    public void sort(final Comparable[] arr1) {
        Comparable[] arr2 = arr1.clone();
        sort(arr1, arr2, 0, arr1.length - 1);
        assert isSorted(arr1);
    }
    /**
     * insertion sort is a sorting technique. It is used when size of array is
     * lessthan 7. Time complexity of insertion sort is N^2.
     *
     * @param      arr3  The arr 3
     * @param      lo    The lowwer value
     * @param      hi    The higher value
     */
    public void insertionSort(final Comparable[] arr3,
                              final int lo, final int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(arr3[j], arr3[j - 1]); j--) {
                exch(arr3, j, j - 1);
            }
        }
    }
    /**
     * less method is a compare method.
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
     * isSorted is a method check whether the array is sorted or not.
     *
     * @param      arr6  The arr 6
     * @param      lo    The lowwer
     * @param      hi    The higher
     *
     * @return     return true if sorted, false otherwise.
     */
    public boolean isSorted(final Comparable[] arr6,
                            final int lo, final int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(arr6[i], arr6[i - 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * isSorted is a method check whether the array is sorted or not.
     *
     * @param      arr5  The arr 5
     *
     * @return     return true if sorted, false otherwise.
     */
    public boolean isSorted(final Comparable[] arr5) {
        return isSorted(arr5, 0, arr5.length - 1);
    }
    /**
     * exchange methods is used to swap the elements in the array.
     *
     * @param      arr4  The arr 4
     * @param      i     {Integer i}
     * @param      j     {Integer j}
     */
    public void exch(final Object[] arr4,
                     final int i, final int j) {
        Object swap = arr4[i];
        arr4[i] = arr4[j];
        arr4[j] = swap;
    }
    /**
     * show method is used to display the ouyput.
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
        str += array[i] + "]";
        return str;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Unused Constructor.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Merge merge = new Merge();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            merge.sort(tokens);
            System.out.println(merge.show(tokens));
            System.out.println();
        }
    }
}