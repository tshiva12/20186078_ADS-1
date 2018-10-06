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
	 * @param      name1      The name
	 * @param      dob1       The dob
	 * @param      m11        The m 1
	 * @param      m21        The m 2
	 * @param      m31        The m 3
	 * @param      total1     The total
	 * @param      category1  The category
	 */
	Qualification(final String name1, final String dob1,
	 final int m11, final int m21, final int m31,
	  final int total1, final String category1) {
		this.name = name1;
		this.dob = dob1;
		this.m1 = m11;
		this.m2 = m21;
		this.m3 = m31;
		this.total = total1;
		this.category = category1;
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
	public int compareTo(final Qualification that) {
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
					} else if (
						this.getM1() > that.getM1()) {
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
	/**
	 * Comparable array.
	 */
	private Qualification[] qualified;
	/**
	 * Integer Variable.
	 */
	private int size;
	private final int ten = 10;
	/**
	 * Constructs the object.
	 */
	InsertionSort() {
		this.qualified = new Qualification[ten];
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
    public void add(final Qualification qual) {
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
    public void exch(final Qualification[] qf, final int i, final int j) {
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
            System.out.print(qualified[i].getName() + ","
             + qualified[i].getTotal() + ","
              + qualified[i].getCat());
            System.out.println();
        }
        System.out.println(qualified[i].getName() + "," +
         qualified[i].getTotal() + "," +
          qualified[i].getCat());
    }

}
/**
 * Class for solution.
 */
public final class Solution {
	private Solution() {
		//default constructor is not used.
	}
	/**
	 * main function that client needs.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
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