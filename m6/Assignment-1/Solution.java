/**
 * @author tshiva12.
 */
import java.util.Scanner;
/**
 * Class for add large numbers.
 */
class AddLargeNumbers {
    /**
     * numberTodigits.
     *
     * @param      number  The number
     *
     * @return     return string value.
     */
    public static LinkedList numberToDigits(final String number) {
        return null;
    }
    /**
     * digitsToNumber.
     *
     * @param      list  The list
     *
     * @return     return string.
     */
    public static String digitsToNumber(final LinkedList list) {
        return null;
    }
    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     return string.
     */
    public static LinkedList addLargeNumbers(final LinkedList list1, final LinkedList list2) {
        return null;
    }
}
/**
 * main class solution.
 */
public final class Solution {
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                LinkedList p1Digits = AddLargeNumbers.numberToDigits(p);
                LinkedList q1Digits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(p1Digits, q1Digits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
}
