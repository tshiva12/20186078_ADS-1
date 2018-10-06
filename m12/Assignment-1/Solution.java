import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for qualification.
 */
class Qualification implements Comparable<Qualification> {
	/**
	 * String variable.
	 */
	private String name;
	/**
	 * String variable.
	 */
	private String dob;
	/**
	 * Integer variable.
	 */
	private int m1;
	/**
	 * Integer variable.
	 */
	private int m2;
	/**
	 * Integer variable.
	 */
	private int m3;
	/**
	 * Integer variable.
	 */
	private int total;
	/**
	 * String variable.
	 */
	private String category;
	/**
	 * Constructs the object.
	 */
	Qualification() {
		//default constructor is not used.
	}
	/**
	 * Constructs the object.
	 *
	 * @param      name      The name
	 * @param      dob       The dob
	 * @param      m1        The m 1
	 * @param      m2        The m 2
	 * @param      m3        The m 3
	 * @param      total     The total
	 * @param      category  The category
	 */
	Qualification(String name, String dob,
	 int m1, int m2, int m3,
	  int total, String category) {
		this.name = name;
		this.dob = dob;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
		this.total = total;
		this.category = category;
	}
	/**
	 * Gets the name.
	 *
	 * @return     The name.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Gets the Date of birth.
	 *
	 * @return   The Date of birth.  
	 */
	public String dob() {
		return this.dob;
	}
	/**
	 * Gets the m 1.
	 *
	 * @return     The m 1.
	 */
	public int getM1() {
		return this.m1;
	}
	/**
	 * Gets the m 2.
	 *
	 * @return     The m 2.
	 */
	public int getM2() {
		return this.m2;
	}
	/**
	 * Gets the m 3.
	 *
	 * @return     The m 3.
	 */
	public int getM3() {
		return this.m3;
	}
	/**
	 * Gets the total.
	 *
	 * @return     The total.
	 */
	public int getTotal() {
		return this.total;
	}
	/**
	 * Gets the cat.
	 *
	 * @return     The cat.
	 */
	public String getCat() {
		return this.category;
	}
	/**
	 * compareTo method is used to compare the two elements.
	 *
	 * @param      that  The that
	 *
	 * @return     boolean values if true 1 else -1.
	 */
	public int compareTo(Qualification that) {
		if (this.getTotal() < that.getTotal()) {
			return 1;
		} else if (this.getTotal() > that.getTotal()) {
			return -1;
		} else {
			if (this.getM3() < that.getM3()) {
				return 1;
			} else if (this.getM3() > that.getM3()) {
				return -1;
			} else {
				if (this.getM2() < that.getM2()) {
					return 1;
				} else if (this.getM2() > that.getM2()) {
					return -1;
				} else {
					if (this.getM1() < that.getM1()) {
						return 1;
					} else if (this.getM1() > that.getM1()) {
						return -1;
					}
				}
			}
		}
		return 0;
	}
}
/**
 * Class for insertion sort.
 */
class InsertionSort {
	private Qualification[] qualified;
	private int size;
	/**
	 * Constructs the object.
	 */
	InsertionSort() {
		this.qualified = new Qualification[10];
		this.size = 0;
	}
	/**
	 * Gets the size.
	 *
	 * @return     The size.
	 */
	public int getSize() {
        return this.size;
    }
    /**
     * add method is used to add the elements.
     *
     * @param      qual  The qual
     */
    public void add(Qualification qual) {
        if (size == qualified.length) {
            resize();
        }
        qualified[size++] = qual;
    }
    /**
     * Increasing the size.
     */
    public void resize() {
        qualified = Arrays.copyOf(qualified, 2 * qualified.length);
    }
	/**
	 * sort method is used to sort the array.
	 */
	public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (qualified[j].compareTo(qualified[j - 1]) == -1) {
                    exch(qualified, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
    /**
     * exch method is used to swap the two elements in an array.
     *
     * @param      qf    Comparable
     * @param      i     Integer
     * @param      j     Integer
     */
    public void exch(Qualification[] qf, int i, int j) {
        Qualification swap = qf[i];
        qf[i] = qf[j];
        qf[j] = swap;
    }
    /**
     * show method is used to display the output.
     */
    public void show() {
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            System.out.print(qualified[i].getName() + "," +
             qualified[i].getTotal() + "," +
              qualified[i].getCat());
        }
        System.out.println(qualified[i].getName() + "," +
         qualified[i].getTotal() + "," +
          qualified[i].getCat());
    }

}
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * main function that client needs.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		InsertionSort insert = new InsertionSort();
		int N = Integer.parseInt(scan.nextLine());
		int Vac = Integer.parseInt(scan.nextLine());
		int Un = Integer.parseInt(scan.nextLine());
		int Bc = Integer.parseInt(scan.nextLine());
		int Sc = Integer.parseInt(scan.nextLine());
		int St = Integer.parseInt(scan.nextLine());
		while(scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			insert.add(new Qualification(tokens[0], (tokens[1]),
			 Integer.parseInt(tokens[2]),
			  Integer.parseInt(tokens[3]),
			   Integer.parseInt(tokens[4]),
			    Integer.parseInt(tokens[5]),
			     tokens[6]));
		}
		insert.sort();
		insert.show();
	}
}