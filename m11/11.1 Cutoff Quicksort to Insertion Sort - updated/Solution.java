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
     * isSorted is a method check whether the array is sorted or not.
     * Time complexity of isSorted method is 1.
     *
     * @param      arr5  The arr 5
     *
     * @return     return true if sorted, false otherwise.
     */
    public boolean isSorted(final Comparable[] arr5) {
        return isSorted(arr5, 0, arr5.length - 1);
    }
    /**
     * isSorted is a method check whether the array is sorted or not.
     * Time complexity of isSorted method is 1.
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
     * Sort method is used for sorting.
     * Time complexity of sort method is logN.
     *
     * @param      arr   The array
     * @param      aux   The auxiliary array
     * @param      lo    The lowwer value
     * @param      hi    The higher value
     */
    public void sort(final Comparable[] arr,
                     final int lo, final int hi, int cutOff) {
        if (hi <= lo + cutOff - 1) {
            insertionSort(arr, lo, hi);
            System.out.println("insertionSort called");
            return;
        }
        int j = partition(arr, lo, hi);
        sort(arr, lo, j-1, cutOff);
        sort(arr, j+1, hi, cutOff);
        assert isSorted(arr, lo, hi);
    }
    /**
     * sort method is used to sort the array with copy of that array.
     * Time complexity of Sort method is 1.
     *
     * @param      arr1  The arr 1
     */
    public void sort(Comparable[] a, int cutOff) {
        sort(a, 0, a.length - 1, cutOff);
        assert isSorted(a);
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
public class Solution {
	public static void main(String[] args) {
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