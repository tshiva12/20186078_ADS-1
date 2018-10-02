import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for cricket tour.
 */
class CricketTour implements Comparable<CricketTour> {
    /**
     * String Variable.
     */
    private String teamName;
    /**
     * Integer Variable.
     */
    private int wins;
    /**
     * Integer Variable.
     */
    private int losses;
    /**
     * Integer Variable.
     */
    private int draws;
    /**
     * Constructs the object.
     */
    CricketTour() {
        //default constructor is not used.
    }
    /**
     * Constructs the object. Time complexity of CricketTour constructor is 1.
     *
     * @param      teamname1  The teamname
     * @param      wins1      The wins
     * @param      losses1    The losses
     * @param      draws1     The draws
     */
    CricketTour(final String teamname1, final int wins1,
     final int losses1, final int draws1) {
        this.teamName = teamname1;
        this.wins = wins1;
        this.losses = losses1;
        this.draws = draws1;
    }
    /**
     * Gets the team name.
     * Time complexity of getTeamName method is 1.
     *
     * @return     The team name.
     */
    public String getTeamName() {
        return this.teamName;
    }
    /**
     * Gets the wins.
     * Time complexity of getWins method is 1.
     *
     * @return     The wins.
     */
    public int getWins() {
        return this.wins;
    }
    /**
     * Gets the losses.
     * Time complexity of getLosses method is 1.
     *
     * @return     The losses.
     */
    public int getLosses() {
        return this.losses;
    }
    /**
     * Gets the draws.
     * Time complexity of getDraws method is 1.
     *
     * @return     The draws.
     */
    public int getDraws() {
        return this.draws;
    }
    /**
     * CompareTo method is comparing the two items based on their order.
     * Time complexity of compareTo method is 1.
     *
     * @param      that  The that
     *
     * @return     return 1 if the condition is true otherwise -1.
     */
    public int compareTo(final CricketTour that) {
        if (this.getWins() < that.getWins()) {
            return 1;
        } else if (this.getWins() > that.getWins()) {
            return -1;
        } else {
            if (this.getLosses() > that.getLosses()) {
                return 1;
            } else if (this.getLosses() < that.getLosses()) {
                return -1;
            } else {
                if (this.getDraws() < that.getDraws()) {
                    return 1;
                } else if (this.getDraws() > that.getDraws()) {
                    return -1;
                }
            }
        }
        return 0;
    }

}
/**
 * Class for selection sort.
 */
class InsertionSort {
    /**
     * Array of team names.
     */
    private CricketTour[] teamnames;
    /**
     * integer variable.
     */
    private int size;
    /**
     * integer variable.
     */
    private final int ten = 10;
    /**
     * Constructs the object.
     * Time complexity of Selection sort constructor is 1.
     */
    InsertionSort() {
        this.teamnames = new CricketTour[ten];
        this.size = 0;
    }
    /**
     * sort method is used to sort the data based on teamnames and its values.
     * Time complexity for sort method is N^2.
     */
    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (teamnames[j].compareTo(teamnames[j - 1]) == -1) {
                    exch(teamnames, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
    /**
     * exchange method is used to swap the elements in an array.
     *
     * @param      cr    The carriage return
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    public void exch(final CricketTour[] cr, final int i, final int j) {
        CricketTour swap = cr[i];
        cr[i] = cr[j];
        cr[j] = swap;
    }
    /**
     * add method is used to add the teams.
     * Time complexity of add method is 1.
     *
     * @param      teams  The teams
     */
    public void add(final CricketTour teams) {
        if (size == teamnames.length) {
            resize();
        }
        teamnames[size++] = teams;
    }
    /**
     * show is to display the output by using Selection sort algorithm.
     * Time complexity of the show method is N.
     */
    public void show() {
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            System.out.print(teamnames[i].getTeamName() + ",");
        }
        System.out.println(teamnames[i].getTeamName());
    }
    /**
     * Gets the size.
     * Time complexity of getSize methd is 1.
     *
     * @return     The size.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * resize method is used to double the size for extending size value.
     * Time complexity of resize method is 1.
     */
    public void resize() {
        teamnames = Arrays.copyOf(teamnames, 2 * teamnames.length);
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
     * main function of Selection Sort.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        InsertionSort insert = new InsertionSort();
        final int three = 3;
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            insert.add(new CricketTour(tokens[0], Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[2]), Integer.parseInt(tokens[three])));
        }
        insert.sort();
        insert.show();
    }
}


