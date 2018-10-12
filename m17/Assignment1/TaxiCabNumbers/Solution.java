import java.util.Scanner;
/**
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum> {
    private final int sum;
    private final int i;
    private final int j;
    public CubeSum(int i, int j) {
        this.sum = i * i *  i + j * j * j;
        this.i = i;
        this.j = j;
    }
    public int getSum() {
        return this.sum;
    }
    public int getI() {
        return this.i;
    }
    public int getJ() {
        return this.j;
    }
    public int compareTo(CubeSum that) {
        if (this.getSum() < that.getSum()) {
            return -1;
        }
        if (this.getSum() < that.getSum()) {
            return +1;
        }
        return 0;
    }
    public String toString() {
        return getSum() + " = " + getI() + "^3" + " + " + getJ() + "^3";
    }
}
public class Solution {
    private Solution() {
        // default constructor is not used.
    }
    public static void main(String[] args) {
        int n = 1200;
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
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
            if (count == M - 1) {
                N--;
                if (N == 0) {
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