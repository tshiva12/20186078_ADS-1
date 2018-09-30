import java.util.Scanner;
/**
 * Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //default constructor is used.
    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        LinkedList linked;
        Scanner scan = new Scanner(System.in);
        int lines = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < lines; i++) {
            String[] tokens = scan.nextLine().split(" ");
            linked = new LinkedList(Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]));
            linked.JosephusProblem();
        }
    }
}



