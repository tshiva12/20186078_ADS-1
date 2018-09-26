import java.util.Scanner;
import java.util.Arrays;
class Sortlist {
	private int[] listone;
	private int[] listtwo;
	Sortlist(int[] l1, int[] l2) {
		this.listone = l1;
		this.listtwo = l2;
	}
	public String sort(int[] lis1, int[] lis2) {
		int i = 0, j = 0, k = 0;
		int[] list = new int[lis1.length + lis2.length];
		while (i < lis1.length && j < lis2.length) {
			if (lis1[i] < lis2[j]) {
				list[k++] = lis1[i++];
			} else {
				list[k++] = lis1[j++];
			}
		}
		while (i < lis1.length) {
			list[k++] = lis1[i++];
		}
		while (j < lis2.length) {
			list[k++] = lis2[j++];
		}
		String result ="";
		for (int z = 0; z < list.length - 1; z++) {
			result += list[z] + ",";			
		}
		return result;
	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size1 = Integer.parseInt(scan.nextLine());
		int size2 = Integer.parseInt(scan.nextLine());
		String[] str1 = scan.nextLine().split(",");
		String[] str2 = scan.nextLine().split(",");
		int[] list1 = new int[size1];
		int[] list2 = new int[size2];
		for (int i = 0; i < size1; i++) {
			list1[i] = Integer.parseInt(str1[i]);
		}
		for (int j = 0; j < size2; j++) {
			list2[j] = Integer.parseInt(str2[j]);
		}
		Sortlist s = new Sortlist(list1, list2);
		System.out.println(s.sort(list1, list2));
	}
}