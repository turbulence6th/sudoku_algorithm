
public class Main {

	public static void main(String[] args) {
		
		Sudoku sudoku = new Sudoku();
		int [][] table = sudoku.getTable();
		
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				System.out.print("" + table[i][j] + " " );
			}
			System.out.println();
		}

	}

}
