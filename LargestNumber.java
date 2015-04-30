
import java.util.*;
public class LargestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter an integer: ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		String number = Integer.toString(num);
		System.out.println(number);
		HashMap<Integer,Integer> table = new HashMap<Integer,Integer>(10);
		for(int i =0; i < number.length();i++){
			int digit = Character.digit(number.charAt(i),10);
			if(table.get(digit) == null){
				table.put(digit, 1);
			}
			else{
				int count = table.get(digit);
				count++;
				table.put(digit, count);
			}
		}
		
		String result = "";
		for(int i =9; i >= 0; i--){
			
			if(table.get(i) != null){
				int count = table.get(i);
				while(count > 0){
					result = result + i;
					count--;
				}
				
			}
		}
		System.out.println(result);
	}

}
