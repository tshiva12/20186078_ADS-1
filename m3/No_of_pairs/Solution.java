import java.util.Scanner;
import java.util.Arrays;
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
		int n = Integer.parseInt(scan.nextLine());
		int[] list1 = new int[n];
		// NoofPairs pairs = new NoofPairs(list1, n);
		for (int i = 0; i < n; i++) {
			list1[i] = scan.nextInt();
		}
		Arrays.sort(list1);
		System.out.println(checkpairs(list1));
	}
	/**
	 * check pairs method.
	 *
	 * @param      list3  The list 3
	 *
	 * @return     return count.
	 */
	public static int checkpairs(final int[] list3) {
		int count = 1;
		int temp = 0;
		for (int i = 0; i < list3.length - 1; i++) {
			if (list3[i] == list3[i + 1]) {
				// System.out.println("Pairs are " + "{" + list3[i] + "," + list3[i + 1] + "}");
				count += 1;
			} else {
				temp = temp + (count * (count - 1))/2;
				count = 1;
			}
		}
		temp = temp + (count * (count - 1))/2;
		return temp;
	}
}
// class NoofPairs {
// 	int[] list2;
// 	int size;
// 	NoofPairs(int[] list1, int n) {
// 		list2 = list1;
// 		size = n;
// 	}
// }