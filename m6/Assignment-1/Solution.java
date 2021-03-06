/**
 * @author tshiva12.
 */
import java.util.Scanner;
/**
 * Class for add large numbers.
 */
final class AddLargeNumbers {
    /**
     * Constructs the object.
     */
    private AddLargeNumbers() { }
    /**
     * numberTodigits.
     *
     * @param      number  The number
     *
     * @return     return string value.
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList str = new LinkedList();
        String[] str1 = number.split("");
        for (int i = 0; i < str1.length; i++) {
            str.push(str1[i]);
        }
        return str;
    }
    /**
     * digitsToNumber.
     *
     * @param      list  The list
     *
     * @return     return string.
     */
    public static String digitsToNumber(final LinkedList list) {
        String str2 = "";
        while (!list.isEmpty()) {
            str2 += list.pop();
        }
        return str2;
    }
    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     return string.
     */
    public static LinkedList addLargeNumbers(final LinkedList list1,
     final LinkedList list2) {
        return null;
    }
}
/**
 * main class solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //default constructor.
    }
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
        // System.out.println(p);
        // System.out.println(q);
        switch (input) {
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(
                    pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
            default:
            break;
        }
    }
}




