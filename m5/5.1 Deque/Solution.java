import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
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
        LinkedList linked = new LinkedList();
        Scanner scan = new Scanner(System.in);
        int lines = scan.nextInt();
        for (int i = 0; i <= lines; i++) {
            String str = scan.nextLine();
            String[] tokens = str.split(" ");
            switch (tokens[0]) {
                case "pushLeft":
                linked.pushLeft(Integer.parseInt(tokens[1]));
                break;
                case "pushRight":
                linked.pushRight(Integer.parseInt(tokens[1]));
                break;
                case "popLeft":
                linked.popLeft();
                break;
                case "popRight":
                linked.popRight();
                break;
                case "isEmpty":
                System.out.println(linked.isEmpty());
                break;
                case "size":
                System.out.println(linked.size());
                break;
                default:
                break;
            }
        }
    }
}