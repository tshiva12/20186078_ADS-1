import java.util.Scanner;
class IsMinHeap<E extends Comparable<E>> {
	private int length;
	private E[] array;
	IsMinHeap() {
		// default constructor is not used.
	}
	IsMinHeap(E[] array1) {
		length = array.length;
		array = (E[]) new Object[length + 1];
		for (int i = 0; i < length; i++) {
            array[i+1] = array1[i];
		}
		System.out.println(isMinHeap(1));
	}
	private boolean isMinHeap(int k) {
        if (k > length) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= length && greater(length, left))  return false;
        if (right <= length && greater(length, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }
    public boolean greater(int i, int j) {
    	return ((Comparable<E>) array[i]).compareTo(array[j]) > 0;
    }
}
 


class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1 = scan.nextLine();
		int num = Integer.parseInt(scan.nextLine());
		switch (str1) {
			case "String":
				for (int i = 0; i < num; i++) {
					String[] tokens = scan.nextLine().split(",");
					IsMinHeap<String> str2 = new IsMinHeap<String>(tokens);	
				}
			break;
			case "Integer":
				for (int i = 0; i < num; i++) {
					String[] tokens = scan.nextLine().split(",");
					Integer[] tokens1 = new Integer[tokens.length];
					for (int j = 0; j < tokens.length; j++) {
						tokens1[j] = Integer.parseInt(tokens[j]);
					}
					IsMinHeap<Integer> str2 = new IsMinHeap<Integer>(tokens1);	
				}
			break;
			case "Double":
				for (int i = 0; i < num; i++) {
					String[] tokens = scan.nextLine().split(",");
					Double[] tokens1 = new Double[tokens.length];
					for (int j = 0; j < tokens.length; j++) {
						tokens1[j] = Double.parseDouble(tokens[j]);
					}
					IsMinHeap<Double> str2 = new IsMinHeap<Double>(tokens1);	
				}
			break;
			case "Float":
				for (int i = 0; i < num; i++) {
					String[] tokens = scan.nextLine().split(",");
					Float[] tokens1 = new Float[tokens.length];
					for (int j = 0; j < tokens.length; j++) {
						tokens1[j] = Float.parseFloat(tokens[j]);
					}
					IsMinHeap<Float> str2 = new IsMinHeap<Float>(tokens1);
				}
			break;
		}

	}
}