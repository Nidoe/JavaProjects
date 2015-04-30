import java.util.HashMap;
import java.util.Scanner;


public class FibSequence {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		while(true){
			System.out.print("Enter the nth element you would like in the Fibonnaci Sequence:");
			int input = in.nextInt();
			HashMap<Integer, Integer> fibonnaciMap = new HashMap<Integer, Integer>();
			int nthElement = input;
			int count = 0;
			int result = 0;
			while(count < nthElement){
				result = Fibonnaci(count, fibonnaciMap);
				count++;
			}
			System.out.println(result);
		}
	}
	
	public static int Fibonnaci(int n, HashMap<Integer, Integer> fibonnaciMap){
		if(fibonnaciMap.get(n) != null){
			return fibonnaciMap.get(n);
		}
		else if(n == 0){
			fibonnaciMap.put(0, 0);
			return 0;
		}
		else if (n == 1) {
			fibonnaciMap.put(1, 1);
			return 1;
		}
		else if (n > 1) {
			int first = Fibonnaci(n - 1, fibonnaciMap);
			int second = Fibonnaci(n - 2, fibonnaciMap);
			fibonnaciMap.put(n, first + second);
			return fibonnaciMap.get(n);
		}
		else{
			return 0;
		}
	}

}
