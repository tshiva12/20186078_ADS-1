import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor.
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        LinearProbingHashST<String, Integer> linear = new LinearProbingHashST<>();
        for (int i = 0; i <= num; i++) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
                case "put": linear.put(tokens[1], Integer.parseInt(tokens[2]));
                break;
                case "display":
                    if (linear.size() == 0) {
                    System.out.println("{}");
                } else {
                    String str = "";
                    for (String str1: linear.keys()) {
                        str += str1 + ":" + linear.get(str1) + ", ";
                    }
                    System.out.println("{" + str.substring(
                        0, str.length()) + "}");
                }
                break;
                case "delete":
                linear.delete(tokens[1]);
                break;
                case "get":
                System.out.println(linear.get(tokens[1]));
                break;
                default:
                break;
            }
        }
    }
}
