import java.util.Arrays;
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //default constructot
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        while (scan.hasNext()) {
            char[] str1 = scan.nextLine().toCharArray();
            System.out.println(balance(str1));
        }
    }
    /**
     * check balanced parenthis.
     *
     * @param      str1  The string 1
     *
     * @return     return boolean value.
     */
    public static String balance(final char[] str1) {
        Stack s = new Stack();
        for (char str2 : str1) {
            if (str2 == '{' || str2 == '[' || str2 == '(') {
                s.push(str2);
            } else {
                if (!s.isempty()) {
                    char char1 = s.peek();
                    if ((char1 == '{' && str2 == '}') || (char1 == '[' && str2 == ']')
                     || (char1 == '(' && str2 == ')')) {
                        s.pop();
                    } else {
                        return "YES";
                    }
                } else {
                    return "NO";
                }
            }
        }
        if (s.isempty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
/**
 * List of .
 */
class Stack {
    /**
     * char array variable.
     */
    private char[] braces;
    /**
     * Integer variable.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Stack() {
        braces = new char[10];
        size = 0;

    }
    /**
     * push.
     *
     * @param      brace1  The brace 1
     */
    public void push(final char brace1) {
        if (isfull()) {
            braces = Arrays.copyOf(braces, braces.length * (2));
        }
        braces[size++] = brace1;

    }
    /**
     * pop.
     *
     * @return     return pop value.
     */
    public char pop() {
        return braces[--size];

    }
    /**
     * isempty.
     *
     * @return    return boolean value.
     */
    public boolean isempty() {
        return size == 0;
    }
    /**
     * peek.
     *
     * @return     return last inserted item.
     */
    public char peek() {
        return braces[size - 1];
    }
    /**
     * isfull.
     *
     * @return     return boolean value.
     */
    public boolean isfull() {
        return size == braces.length;
    }
}
// class Stack {
//     private String[] s;
//     private int N = 0;
//     public void Stack(int capacity) {
//         s = new String[capacity];
//     }
//     public boolean isEmpty() {
//         return N == 0;
//     }
//     public void push(String item) {
//         s[N++] = item;
//     }
//     public String pop()   {
//         return s[--N];
//     }
// }
