import java.util.Scanner;
public class Solution {
	public static int count = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(show(scan.nextLine()));
		System.out.println("count is " + count);
	}
	public static String show(String str) {
		int length = str.length();
		if (length == 1) {
			count++;
			return str;
		}
		if (str.charAt(0) == str.charAt(1)) {
			count++;
			return str.charAt(0) + "*" + show(str.substring(1));
		}
		count++;
		return str.charAt(0) + show(str.substring(1));
	}
}