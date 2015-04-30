/*
 * Program rotates a Symmetric Matrix 90 degrees
 */



public class MatrixTransform {

	public static void main(String[] args) {
		
		/* Declare variables */
		
		int[][] matrix = new int[6][6];
		
		/* Populate Matrix */
		
		for(int i =0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				matrix[i][j] = i+j;
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		
		/* Declare additional variables */
		
		int rows = matrix.length;
		int columns = matrix[0].length;
		int[][] newMatrix = new int[rows][columns];
		
		System.out.println("\n" + "....Transforming...." + "\n");
		
		
		/* Do transfomation 
		 * 
		 * for each row, i, create a new matrix that transforms the row into a column in the new matrix, i.
		 *   
		 * 
		 */
	
		
		for(int i = 0; i < rows; i++){
			for(int j = columns - 1; j >= 0; j--){
				newMatrix[i][columns - 1 - j] = matrix[j][i];
//				System.out.println(i + "," + (columns - 1 - j) + "->" + j + "," + i);
				System.out.print(newMatrix[i][columns- j - 1] + "\t");
			}
			System.out.println();
		}
		
		
		
		
		
	}

}
