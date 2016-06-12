import java.util.ArrayList;
import java.util.Collections;

public class Sudoku {
	
	public int[][] getTable() {
		int[][] table = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				table[i][j] = 0;
			}
		}

		fillTable(table);
		return table;
	}

	public boolean fillTable(int[][] table) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (table[i][j] == 0) {
					ArrayList<Integer> possibles = odds(table, i, j);

					for (Integer possible : possibles) {
						int[][] tempTable = new int[9][9];
						for (int k = 0; k < 9; k++) {
							for (int l = 0; l < 9; l++) {
								tempTable[k][l] = table[k][l];
							}
						}

						tempTable[i][j] = possible;
						if (fillTable(tempTable)) {
							for (int k = 0; k < 9; k++) {
								for (int l = 0; l < 9; l++) {
									table[k][l] = tempTable[k][l];
								}
							}
							return true;
						}
					}

					return false;
				}
			}
		}

		return true;
	}

	public ArrayList<Integer> odds(int[][] table, int row, int column) {

		boolean[] numbers = new boolean[9];
		for (int i = 0; i < 9; i++)
			numbers[i] = true;

		for (int i = 0; i < 9; i++) {
			if (i != row && table[i][column] != 0) {
				numbers[table[i][column] - 1] = false;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (i != column && table[row][i] != 0) {
				numbers[table[row][i] - 1] = false;
			}
		}

		int startX = 0, endX = 0, startY = 0, endY = 0;

		if (row >= 0 && row <= 2) {
			startX = 0;
			endX = 2;
		}

		else if (row >= 3 && row <= 5) {
			startX = 3;
			endX = 5;
		}

		else if (row >= 6 && row <= 8) {
			startX = 6;
			endX = 8;
		}

		if (column >= 0 && column <= 2) {
			startY = 0;
			endY = 2;
		}

		else if (column >= 3 && column <= 5) {
			startY = 3;
			endY = 5;
		}

		else if (column >= 6 && column <= 8) {
			startY = 6;
			endY = 8;
		}

		for (int i = startX; i <= endX; i++) {
			for (int j = startY; j <= endY; j++) {
				if ((i != row || j != column) && table[i][j] != 0) {
					numbers[table[i][j] - 1] = false;
				}
			}
		}

		ArrayList<Integer> possibleNumbers = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			if (numbers[i])
				possibleNumbers.add(i + 1);
		}

		Collections.shuffle(possibleNumbers);

		return possibleNumbers;
	}

}
