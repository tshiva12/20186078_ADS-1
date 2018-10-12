import java.util.Scanner;
/**
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum> {
    /**
     * Integer variable.
     */
    private final int sum;
    /**
     * Integer variable.
     */
    private final int i;
    /**
     * Integer variable.
     */
    private final int j;
    /**
     * Constructs the object.
     *
     * @param      i1    I 1
     * @param      j1    The j 1
     */
    CubeSum(final int i1, final int j1) {
        this.sum = i1 * i1 *  i1 + j1 * j1 * j1;
        this.i = i1;
        this.j = j1;
    }
    /**
     * Gets the sum.
     *
     * @return     The sum.
     */
    public int getSum() {
        return this.sum;
    }
    /**
     * Gets i.
     *
     * @return     I.
     */
    public int getI() {
        return this.i;
    }
    /**
     * Gets the j.
     *
     * @return     The j.
     */
    public int getJ() {
        return this.j;
    }
    /**
     * { function_description }
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final CubeSum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        if (this.sum > that.sum) {
            return +1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
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
        // default constructor is not used.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int n = 1200;
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int values = scan.nextInt();
        int count = 0;
        int z = -1;
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= n; i++) {
            pq.insert(new CubeSum(i, i));
        }
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            if (z == s.getSum()) {
                count++;
            } else {
                count = 0;
            }
            if (count == values - 1) {
                values--;
                if (num == 0) {
                    System.out.println(s.getSum());
                    break;
                }
            }
            z = s.getSum();
            if (s.getJ() < n) {
                pq.insert(new CubeSum(s.getI(), s.getJ() + 1));
            }
        }
    }
}