import java.util.ArrayList;
import java.util.List;


public class StringPermutations {

	public static void main(String[] args) {
		String test = "abcd";
		
		stringPermutations(test);
	}
	
	private static List<char[]> stringPermutations(String inputStr){
		
		char[] input = inputStr.toCharArray();	
		
//		System.out.println(input);
		
		int[] visited = new int[input.length];
		
		ArrayList<char[]> result = new ArrayList<char[]>();
		
		
		for(int i = 0; i < visited.length; i++){
			visited[i] = 0;
		}
		char[] word = new char[input.length];
		doPermutations(input, visited, word, 0, input.length);
		
		return result;
		
	}
	
	private static void doPermutations(char[] input, int[] visited, char[] word, int count, int length){
		
		if(count == length){
			System.out.println(word);
			return;
		}
		
		for(int i = 0; i < length; i++){
			if(visited[i] == 1){
				continue;
			}
			else{
				word[count] = input[i];
				visited[i] = 1;
				doPermutations(input, visited, word, count + 1, length);
				visited[i] = 0;
			}
		}
		
	}

}
