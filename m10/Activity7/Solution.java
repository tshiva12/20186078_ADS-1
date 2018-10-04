import java.util.Scanner;
public class Solution {
	static int count = 0;
   	public static void main(String args[]) {
    	Scanner scan = new Scanner(System.in);
      	int num = scan.nextInt();
      	int factorial = fact(num);
      	System.out.println(factorial);
      	System.out.println("count " + count);
   	}
   	public static int fact(int n) {
       	int result;
       	if (n == 1){
       		count++;
         	return 1;
       	}
       	count++;
       	result = fact(n-1) * n;
       	return result;
   }
}