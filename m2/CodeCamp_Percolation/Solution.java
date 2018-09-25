// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
import java.util.Scanner;
class Percolation {
	private boolean[] list;
	private WeightedQuickUnionUF weight;
	private int n;
	private int size;
	private int first;
	private int last;
	private int count;
	public Percolation(int n1) {
		this.n = n1;
		this.count = 0;
		this.size = n1 * n1;
		this.first = size;
		this.last = size + 1;
		weight = new WeightedQuickUnionUF((size + 2));
		list = new boolean[size];
		for (int i = 0; i < n; i++) {
			weight.union(first, i);
			weight.union(last, size - i - 1);
		}
	}
	private void linkOpenSites(int row, int col) {
		if (list[col] && !weight.connected(row, col)) {
			weight.union(row, col);
		}
	}
	public void open(int row, int col) {
		int index = Dim(row, col);
		list[index] = true;
		count++;
		if (n == 1) {
			weight.union(first, index);
			weight.union(last, index);
		}
		int bottom = index + n;
		int top = index - n;
		if (bottom < size) {
			linkOpenSites(index, bottom);
		}
		if (top >= 0) {
			linkOpenSites(index, top);
		}
		if (col == 1) {
			if (col != n) {
				linkOpenSites(index, index + 1);
			}
			return;
		}
		if (col == n) {
			linkOpenSites(index, index - 1);
			return;
		}
		linkOpenSites(index, index + 1);
		linkOpenSites(index, index - 1);
	}
	public boolean isOpen(int row, int col) {
		return list[Dim(row, col)];
	}
	public int numberOfOpenSites() {
		return count;
	}
	public boolean percolates() {
		return weight.connected(first, last);
	}
	public int Dim(int row, int col) {
		return n * (row - 1) + col - 1;
	}
} 
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		Percolation per = new Percolation(n);
		int i = 0;
		while(scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			per.open(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		}
		System.out.println(per.percolates() && per.numberOfOpenSites() != 0);
	}
}