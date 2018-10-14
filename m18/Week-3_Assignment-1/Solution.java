import java.util.Scanner;
/**
 * Class for stock.
 */
class Stock {
    /**
     * String variable.
     */
    private String name;
    /**
     * Double variable.
     */
    private Double perchange;
    /**
     * Constructs the object.
     *
     * @param      name1       The name 1
     * @param      perchange1  The perchange 1
     */
    Stock(final String name1, final Double perchange1) {
        this.name = name1;
        this.perchange = perchange1;
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
     * Gets the perchange.
     *
     * @return     The perchange.
     */
    public Double getPerchange() {
        return this.perchange;
    }
    /**
     * compareTo mehod is used to compare the two items.
     * Time complexity is 1.
     *
     * @param      that  The that
     *
     * @return     return integer value.
     */
    public int compareTo(final Stock that) {
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
/**
 * Class for stock array.
 */
class StockArray {
    /**
     * Stock array variable list.
     */
    Stock[] list;
    /**
     * Integer variable.
     */
    private int size;
    /**
     * Integer variable.
     */
    private final int fifty = 50;
    /**
     * Constructs the object.
     */
    StockArray() {
        list = new Stock[fifty];
        size = 0;
    }
    /**
     * add method is used to add the items to a list.
     * Time complexity is 1.
     *
     * @param      list1  The list 1
     */
    public void add(final Stock list1) {
        list[size++] = list1;
    }
    /**
     * Gets the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return size;
    }
    /**
     * show method is used to print the array.
     * Time complexity is N.
     *
     * @return     return string value.
     */
    public String show() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += list[i].getName() + " " + list[i].getPerchange() + "\n";
        }
        return str;
    }
    /**
     * sort method is used to sort the array of items in the list.
     * Time complexity is N^2.
     */
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less(list, j, min)) {
                    min = j;
                }
            }
            swapping(list, i, min);
        }
    }
    /**
     * swapping method is used to exchange the two integer variables.
     * Time complexity is 1.
     *
     * @param      list3  The list
     * @param      i     integer variable.
     * @param      j     integer variable.
     */
    public void swapping(final Stock[] list3, final int i, final int j) {
        Stock temp = list3[i];
        list3[i] = list3[j];
        list3[j] = temp;
    }
    /**
     * less method is used to compare the two two integer variables.
     * Time complexity is 1.
     *
     * @param      list2  The list 2
     * @param      i      integer variable.
     * @param      j      integer variable.
     *
     * @return     return boolean value.
     */
    public boolean less(final Stock[] list2, final int i, final int j) {
        return list2[i].compareTo(list2[j]) > 0;
    }
}
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
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        BinarySearchTable<String, Integer>
         bstable = new BinarySearchTable<String, Integer>(2);
        int temp = n;
        scan.nextLine();
        final int six = 6;
        for (int i = 0; i < six; i++) {
            n = temp;
            final int five = 5;
            if (i == 0) {
                MinPQ<String> minpq = new MinPQ<String>();
                MaxPQ<String> maxpq = new MaxPQ<String>();
                StockArray sa = new StockArray();
                while (n > 0) {
                    n--;
                    String[] token = scan.nextLine().split(",");
                    Stock s = new Stock(token[0],
                     Double.parseDouble(token[1]));
                    sa.add(s);
                    minpq.insert(token[1]);
                    minpq.insert(token[1]);
                }
                sa.sort();
                for (int j = 0; j < five; j++) {
                    System.out.println(sa.list[j].getName()
                     + " " + sa.list[j].getPerchange());
                }
                System.out.println();
                 int listsize = sa.getSize();
                for (int k = listsize - 1; k >= listsize - five; k--) {
                    System.out.println(sa.list[k].getName()
                     + " " + sa.list[k].getPerchange());
                }
                System.out.println();
            } else {
                MinPQ<String> minpq1 = new MinPQ<String>();
                MaxPQ<String> maxpq1 = new MaxPQ<String>();
                StockArray sa = new StockArray();
                while (n > 0) {
                    n--;
                    String[] token = scan.nextLine().split(",");
                    Stock s = new Stock(token[0],
                     Double.parseDouble(token[1]));
                    sa.add(s);
                    minpq1.insert(token[1]);
                    minpq1.insert(token[1]);
                }
                sa.sort();
                for (int j = 0; j < five; j++) {
                    System.out.println(sa.list[j].getName()
                     + " " + sa.list[j].getPerchange());
                }
                System.out.println();
                int listsize = sa.getSize();
                for (int k = listsize - 1; k >= listsize - five; k--) {
                    System.out.println(sa.list[k].getName()
                     + " " + sa.list[k].getPerchange());
                }
                System.out.println();
            }
        }
        int query = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < query; i++) {
            String[] token1 = scan.nextLine().split(",");
        }
    }
}


