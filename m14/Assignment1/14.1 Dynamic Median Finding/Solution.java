import java.util.Scanner;
/**
 * class Solution.
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
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		MinPQ<Float> minpq = new MinPQ<Float>(num);
        MaxPQ<Float> maxpq = new MaxPQ<Float>(num);
        Float median = 0.0f;
        for (int i = 0; i < num; i++) {
            Float res = scan.nextFloat();
            if (res > median) {
                minpq.insert(res);
            } else {
                maxpq.insert(res);
            }
            if (minpq.size() == maxpq.size()) {
                median = (minpq.min() + maxpq.max()) / 2;
                System.out.println(median);
            }
            if (maxpq.size() > minpq.size()) {
                median = maxpq.max();
                System.out.println(median);
            }
            if (minpq.size() > maxpq.size()) {
                median = minpq.min();
                System.out.println(median);
            }
            if (minpq.size() - maxpq.size() > 1) {
                maxpq.insert(minpq.delMin());
            }
            if (maxpq.size() - minpq.size() > 1) {
                minpq.insert(maxpq.delMax());  
            }
        }
	}
}