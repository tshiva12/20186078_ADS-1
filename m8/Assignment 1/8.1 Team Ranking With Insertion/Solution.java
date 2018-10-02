import java.util.Scanner;
import java.util.Arrays;
class CricketTour implements Comparable<CricketTour> {
    private String teamName;
    private int wins;
    private int losses;
    private int draws;
    CricketTour() {
        this.teamName = null;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
    }
    CricketTour(final String teamname, final int wins, final int losses, final int draws) {
        this.teamName = teamname;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
    }
    public String getTeamName() {
        return this.teamName;
    }
    public int getWins() {
        return this.wins;
    }
    public int getLosses() {
        return this.losses;
    }
    public int getDraws() {
        return this.draws;
    }
    public void setTeamName(final String str1) {
        this.teamName = str1;
    }
    public void setWins(final int win) {
        this.wins = win;
    }
    public void setLosses(final int loss) {
        this.losses = loss;
    }
    public void setDraws(final int draw) {
        this.draws = draw;
    }
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
class SelectionSort {
    private CricketTour[] teamnames;
    private int size;
    SelectionSort() {
        this.teamnames = new CricketTour[10];
        this.size = 0;
    }
    public void resize() {
        teamnames = Arrays.copyOf(teamnames, 2 * teamnames.length);
    }
    public int getSize() {
        return this.size;
    }
    public void add(final CricketTour teams) {
        if (size == teamnames.length) {
            resize();
        }
        teamnames[size++] = teams;
    }
    public void sort() {
        for (int i = 1; i < size; i++) {
            CricketTour cricket = teamnames[i];
            int j = i - 1;
            int count = cricket.compareTo(teamnames[j]);
            while (j >= 0 && count == -1) {
                teamnames[j + 1] = teamnames[j];
                j--;
                if (j >= 0) {
                    count = cricket.compareTo(teamnames[j]);
                }
            }
            teamnames[j + 1] = cricket;
        }
    }
    public void show() {
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            System.out.print(teamnames[i].getTeamName() + ",");
        }
        // System.out.println(teamnames[i].getTeamName());
    }
}
public class Solution {
    private Solution() {
        //default constructor is not used.
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        SelectionSort select = new SelectionSort();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            select.add(new CricketTour(tokens[0], Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
        }
        select.sort();
        select.show();
    }
}