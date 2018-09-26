import java.util.Arrays;
import java.util.Scanner;
/**
 * Class for solution of array problem.
 */
public final class Solution {
    /**
     * Constructs the object of solution.
     */
    private Solution() {

    }
    /**
     * main function is here.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = scan.nextInt();
        }
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < num - 2; i++) {
            int j = i + 1;
            int k = num - 1;
            while (j < k) {
                if (array[i] + array[j] + array[k] == 0) {
                    count++;
                    j++;
                    k--;
                } else if (array[i] + array[j] + array[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        System.out.println(count);
    }
}