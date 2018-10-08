import java.util.Scanner;
/**
 * Class for is minimum heap.
 *
 * @param      <E>   Generics code for IsMinHeap.
 */
class IsMinHeap<E> {
    /**
     * Integer variable.
     */
    private int length;
    /**
     * Generics array.
     */
    private E[] array;
    /**
     * Constructs the object.
     */
    IsMinHeap() {
        // default constructor is not used.
    }
    /**
     * Constructs the object.
     *
     * @param      array1  The array 1
     */
    IsMinHeap(final E[] array1) {
        length = array1.length;
        array = (E[]) new Object[length + 1];
        for (int i = 0; i < length; i++) {
            array[i + 1] = array1[i];
        }
        System.out.println(isMinHeap(1));
    }
    /**
     * Determines if minimum heap.
     *
     * @param      k     integer variable k.
     *
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap(final int k) {
        if (k > length) {
            return true;
        }
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left  <= length && greater(k, left)) {
            return false;
        }
        if (right <= length && greater(k, right)) {
            return false;
        }
        return isMinHeap(left) && isMinHeap(right);
    }
    /**
     * greater method is used to compare the two integer items,
     *
     * @param      i     Integer variable.
     * @param      j     Integer variable.
     *
     * @return     return boolean value.
     */
    public boolean greater(final int i, final int j) {
        return ((Comparable<E>) array[i]).compareTo(array[j]) > 0;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        switch (str1) {
            case "String":
                int num = scan.nextInt();
                for (int i = 0; i < num; i++) {
                    String[] tokens = scan.next().split(",");
                    try {
                        if (tokens[0].length() == 0) {
                            throw new Exception("false");
                        } else {
                        IsMinHeap<String> str2 = new
                         IsMinHeap<String>(tokens);
                        }
                    } catch (Exception e) {
                        System.out.println("false");
                    }
                }
            break;
            case "Integer":
                num = scan.nextInt();
                for (int i = 0; i < num; i++) {
                    String[] tokens = scan.next().split(",");
                    try {
                        if (tokens[0].length() == 0) {
                            throw new Exception("false");
                        } else {
                        Integer[] tokens1 = new
                         Integer[tokens.length];
                        for (int j = 0; j < tokens.length; j++) {
                            tokens1[j] = Integer.parseInt(tokens[j]);
                        }
                        IsMinHeap<Integer> str2 = new
                         IsMinHeap<Integer>(tokens1);
                        }
                    } catch (Exception e) {
                        System.out.println("false");
                    }   
                }
            break;
            case "Double":
                num = scan.nextInt();
                for (int i = 0; i < num; i++) {
                    String[] tokens = scan.next().split(",");
                    try {
                        if (tokens[0].length() == 0) {
                            throw new Exception("false");
                        } else {
                        Double[] tokens1 = new
                         Double[tokens.length];
                        for (int j = 0; j < tokens.length; j++) {
                            tokens1[j] = Double.parseDouble(tokens[j]);
                        }
                        IsMinHeap<Double> str2 = new
                         IsMinHeap<Double>(tokens1);
                        }
                    } catch (Exception e) {
                        System.out.println("false");
                    }
                }
            break;
            case "Float":
                num = scan.nextInt();
                for (int i = 0; i < num; i++) {
                    try {
                        String str3 = scan.next();
                        if (str3.length() == 0) {
                            throw new Exception("false");
                        } else {
                            String[] tokens = str3.split(",");
                        Float[] tokens1 = new
                         Float[tokens.length];
                        for (int j = 0; j < tokens.length; j++) {
                            tokens1[j] = Float.parseFloat(tokens[j]);
                        }
                        IsMinHeap<Float> str2 = new
                         IsMinHeap<Float>(tokens1);
                        }
                    } catch (Exception e) {
                        System.out.println("false");
                    }
                }
            break;
        }

    }
}