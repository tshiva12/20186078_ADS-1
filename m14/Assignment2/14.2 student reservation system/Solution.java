import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
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
    private Date dob;
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
     * boolean variable.
     */
    private boolean allocation;
    /**
     * Constructs the object.
     */
    Qualification() {
        //default constructor is not used.
    }
    /**
     * Constructs the object.
     *
     * @param      namex      The name
     * @param      dobx       The dob
     * @param      m1x        The m 1
     * @param      m2x        The m 2
     * @param      m3x        The m 3
     * @param      totalx     The total
     * @param      categoryx  The category
     */
    Qualification(final String namex, final String dobx,
     final int m1x, final int m2x, final int m3x,
      final int totalx, final String categoryx) {
        this.name = namex;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.dob = sdf.parse(dobx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.m1 = m1x;
        this.m2 = m2x;
        this.m3 = m3x;
        this.total = totalx;
        this.category = categoryx;
        this.allocation = false;
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
     * Sets the name.
     *
     * @param      name1  The name 1
     */
    public void setName(final String name1) {
        this.name = name1;
    }
    /**
     * Gets the Date of birth.
     *
     * @return   The Date of birth.
     */
    public Date getDob() {
        return this.dob;
    }
    /**
     * Sets the dob.
     *
     * @param      dob1  The dob 1
     */
    public void setDob(final Date dob1) {
        this.dob = dob1;
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
     * Sets the m 1.
     *
     * @param      m11   The m 11
     */
    public void setM1(final int m11) {
        this.m1 = m11;
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
     * Sets the m 2.
     *
     * @param      m21   The m 11
     */
    public void setM2(final int m21) {
        this.m2 = m21;
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
     * Sets the m 3.
     *
     * @param      m31   The m 31
     */
    public void setM3(final int m31) {
        this.m3 = m31;
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
     * Sets the total.
     *
     * @param      total1  The total 1
     */
    public void setTotal(final int total1) {
        this.total = total1;
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
     * Sets the cat.
     *
     * @param      category1  The category 1
     */
    public void setCat(final String category1) {
        this.category = category1;
    }
    /**
     * Gets the allocation.
     *
     * @return     The allocation.
     */
    public boolean getAllocation() {
        return allocation;
    }
    /**
     * Sets the allocation.
     *
     * @param      allocation1  The allocation 1
     */
    public void setAllocation(final boolean allocation1) {
        this.allocation = allocation1;
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
        }
        if (this.getTotal() > that.getTotal()) {
            return -1;
        }
        if (this.getM3() < that.getM3()) {
            return 1;
        }
        if (this.getM3() > that.getM3()) {
            return -1;
        }
        if (this.getM2() < that.getM2()) {
            return 1;
        }
        if (this.getM2() > that.getM2()) {
            return -1;
        }
        if (this.getM1() < that.getM1()) {
            return 1;
        }if (this.getM1() > that.getM1()) {
            return -1;
        }
        if (this.getDob().compareTo(that.getDob()) < 0) {
            return 1;
        }
        if (this.getDob().compareTo(that.getDob()) > 0) {
            return -1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getName() + ",");
        sb.append(this.getTotal() + ",");
        sb.append(this.getCat());
        return sb.toString();
    }
}
/**
 * Class for insertion sort.
 */
class HeapSort {
    /**
     * Constructs the object.
     */
    HeapSort() {
        // default constructor.
    }
    /**
     * sort method is used to sort the array.
     * Time complexity is NlogN.
     */
    public static void sort(final Comparable[] pq) {
        int n = pq.length;
        for (int k = n / 2; k >= 1; k--) {
            sink(pq, k, n);
        }
        while (n > 1) {
            exch(pq, 1, n--);
            sink(pq, 1, n);
        }
    }
    /**
     * exch method is used to swap the two elements in an array.
     *
     * @param      qf    Comparable
     * @param      i     Integer
     * @param      j     Integer
     */
    public static void exch(final Object[] pq, final int i, final int j) {
        Object swap = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = swap;
    }
    /**
     * to sink the values.
     * Time complexity is log N.
     *
     * @param      pq    { parameter_description }
     * @param      k     { parameter_description }
     * @param      n     { parameter_description }
     */
    private static void sink(final Comparable[] pq, final int k, final int n) {
        int l = k;
        while (2 * l <= n) {
            int j = 2 * l;
            if (j < n && less(pq, j, j + 1)) {
                j++;
            }
            if (!less(pq, l, j)) {
                break;
            }
            exch(pq, l, j);
            l = j;
        }
    }
    /**
     * to compare the values.
     * Time complexity is 1.
     *
     * @param      pq    { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private static boolean less(final Comparable[] pq, final int i,
        final int j) {
        return pq[i - 1].compareTo(pq[j - 1]) < 0;
    }
    /**
     * show method is used to display the output.
     */
    public void show(final Comparable[] a) {
        int i = 0;
        for (i = 0; i < a.length - 1; i++) {
            // System.out.print(qualified[i].getName()
            //  + "," + qualified[i].getTotal()
            //   + "," + qualified[i].getCat());
            System.out.println(a[i]);
        }
        // System.out.println(qualified[i].getName()
        //  + "," + qualified[i].getTotal()
        //   + "," + qualified[i].getCat());
        // System.out.println();
    }

}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
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
        int n = Integer.parseInt(scan.nextLine());
        int vac = Integer.parseInt(scan.nextLine());
        int un = Integer.parseInt(scan.nextLine());
        int bc = Integer.parseInt(scan.nextLine());
        int sc = Integer.parseInt(scan.nextLine());
        int st = Integer.parseInt(scan.nextLine());
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        Qualification[] qualcands = new Qualification[n];
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split(",");
            qualcands[i] = new Qualification(tokens[0], (tokens[1]),
             Integer.parseInt(tokens[2]),
              Integer.parseInt(tokens[three]),
               Integer.parseInt(tokens[four]),
                Integer.parseInt(tokens[five]),
                 tokens[six]);
        }
        HeapSort.sort(qualcands);
        print(qualcands);
        vacancies(qualcands, vac, un, bc, sc, st);
    }
    public static void print(final Qualification[] qualcands) {
        for (Qualification qualcands1 : qualcands) {
            System.out.println(qualcands1);
        }
        System.out.println();
    }
    public static void vacancies(final Qualification[] qualcands,
     final int vac, final int un, final int bc,
      final int sc, final int st) {
        int vac1 = vac;
        int un1 = un;
        int bc1 = bc;
        int sc1 = sc;
        int st1 = st;
        int i = 0;
        int j = 0;
        int quallen = qualcands.length;
        Qualification[] vacancy = new Qualification[vac1];
        for (i = 0; i < quallen; i++) {
            if (vac1 == 0) {
                break;
            }
            if (un1 > 0) {
                un1--;
                qualcands[i].setAllocation(true);
                vacancy[j++] = qualcands[i];
                vac1--;
            }
            if (bc1 > 0) {
                if (qualcands[i].getCat().equals("BC") && !qualcands[i].getAllocation()) {
                    bc1--;
                    qualcands[i].setAllocation(true);
                    vacancy[j++] = qualcands[i];
                    vac1--;
                }
            }
            if (sc1 > 0) {
                if (qualcands[i].getCat().equals("SC") && !qualcands[i].getAllocation()) {
                    sc1--;
                    qualcands[i].setAllocation(true);
                    vacancy[j++] = qualcands[i];
                    vac1--;
                }
            }
            if (st1 > 0) {
                if (qualcands[i].getCat().equals("ST") && !qualcands[i].getAllocation()) {
                    st1--;
                    qualcands[i].setAllocation(true);
                    vacancy[j++] = qualcands[i];
                    vac1--;
                }
            }
            for (i = 0; i < quallen; i++) {
                if (vac1 > 0 && qualcands[i].getCat().equals("Open") && !qualcands[i].getAllocation()) {
                    qualcands[i].setAllocation(true);
                    vacancy[j++] = qualcands[i];
                    vac1--;
                }
            }
            HeapSort.sort(vacancy);
            print(vacancy);
        }
    }
}


