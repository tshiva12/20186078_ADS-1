import java.util.Scanner;
import java.util.ArrayList;
class Stock {
	private String name;
	private Float perchange;
	Stock(final String name1, final Float perchange1) {
		this.name = name1;
		this.perchange = perchange1;
	}
	public String getName() {
		return this.name;
	}
	public Float getPerchange() {
		return this.perchange;
	}
	public int compareTo(Stock that) {
		if (this.perchange > that.perchange) {
			return 1;
		}
		if (this.perchange < that.perchange) {
			return -1;			
		}
		if (this.name.compareTo(that.name) > 0) {
			return 1;
		} else if (this.name.compareTo(that.name) < 0) {
			return -1;
		}
		return 0;
	}
}
class StockArray {
	Stock[] list;
	private int size;
	StockArray() {
		list = new Stock[50];
		size = 0;
	}
	public void add(Stock list1) {
		list[size++] = list1;
	}
	public int getSize() {
		return size;
	}
	public String show() {
		String str = "";
		for (int i = 0; i < size; i++) {
			str += list[i].getName() + " " + list[i].getPerchange() + "\n";
		}
		return str;
	}
	public void sort() {
		for (int i = 0; i < size - 1; i++) {
			int min = 1;
			for (int j = i + 1; j < size; j++) {
				if (less(list, j, min)) {
					min = j;
				}
			}
			swapping(list, i, min);
		}
	}
	public void swapping(Stock[] list, int i, int j) {
		Stock temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	public boolean less(Stock[] list2, int i, int j) {
		return list2[i].compareTo(list2[j]) > 0;
	}
}
public final class Solution {
	private Solution() {
		// default constructor is not used.
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		BinarySearchTable<String, Integer> bstable = new BinarySearchTable<String, Integer>(2);
		int temp = n;
		scan.nextLine();
		for (int i = 0; i < 6; i++) {
			if (i == 0) {
				MinPQ<String> minpq = new MinPQ<String>();
                MaxPQ<String> maxpq = new MaxPQ<String>();
                StockArray sa = new StockArray();
                while (n > 0) {
                	n--;
                	String[] token = scan.nextLine().split(",");
                	Stock s = new Stock(token[0], Float.parseFloat(token[1]));
                	sa.add(s);
                	minpq.insert(token[1]);
                	minpq.insert(token[1]);
                }
                sa.sort();
                for (int j = 0; j < 5; j++) {
					System.out.println(sa.list[j].getName() + " " + sa.list[j].getPerchange());                	
                }
                System.out.println();
			} else {
				MinPQ<String> minpq1 = new MinPQ<String>();
                MaxPQ<String> maxpq1 = new MaxPQ<String>();
                StockArray sa = new StockArray();
                while (n > 0) {
                	n--;
                	String[] token = scan.nextLine().split(",");
                	Stock s = new Stock(token[0], Float.parseFloat(token[1]));
                	sa.add(s);
                	minpq1.insert(token[1]);
                	minpq1.insert(token[1]);
                }
                sa.sort();
                for (int j = 0; j < 5; j++) {
					System.out.println(sa.list[j].getName() + " " + sa.list[j].getPerchange());                	
                }
                System.out.println();
                int listsize = sa.getSize();
                for (int k = listsize; k >= listsize - 5; k--) {
                	System.out.println(sa.list[k].getName() + " " + sa.list[k].getPerchange());
                }
			}
		}
		int query = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < query; i++) {
			String[] token1 = scan.nextLine().split(",");
		}
	}
}