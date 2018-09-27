import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private Solution() {

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        while (scan.hasNext()) {
            char[] str1 = scan.nextLine().toCharArray();
            System.out.println(balance(str1));
        }
    }
    public static String balance(char[] str1) {
        Stack s = new Stack();
        for (char str2 : str1) {
            if (str2 == '{' || str2 == '[' || str2 == '(') {
                s.push(str2);
            } else {
                if (!s.isempty()) {
                    char char1 = s.peek();
                    if ((char1 == '{' && str2 == '}') || (char1 == '[' && str2 == ']') || (char1 == '(' && str2 == ')')) {
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
class Stack {
    char [] braces;
    int size;
    public Stack() {
        braces = new char[10];
        size = 0;

    }
    public void push(char brace1) {
        if(isfull()){
            braces = Arrays.copyOf(braces,braces.length*(2));
        }
        braces[size++] = brace1;

    }
    public char pop() {
        return braces[--size];

    }
    public boolean isempty() {
        return size == 0;
    }
    public char peek() {
        return braces[size - 1];
    }
    public boolean isfull(){
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
