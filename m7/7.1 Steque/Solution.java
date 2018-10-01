import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//default constructor is used.
	}
	/**
	 * main function.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < n; i++) {
			Steque steque = new Steque();
			while (scan.hasNext()) {
				String str = scan.nextLine();
				if (str.equals("")) {
					break;					
				}
				String[] tokens = str.split(" ");
				switch (tokens[0]) {
					case "push" :
					steque.push(
						Integer.parseInt(tokens[1]));
					steque.show();
					break;
					case "pop" :
					steque.pop();
					steque.show();
					break;
					case "enqueue" :
					steque.enque(
						Integer.parseInt(tokens[1]));
					steque.show();
					break;
					default :
					break;
				}
			}
			System.out.println();
		}
	}
}