public void DFS(boolean[][] chess, int row){
	
}

public void checkQueen(boolean[][] chess, int row, int column){
	for(int i = 0; i < chess.length; i++){
		chess[row][i] = true;
		chess[i][column] = true;

		for(int j = 0; j < chess.length; j++){
			if(Math.abs(column - i) == Math.abs(row-j)){
				chess[i][j] = true;
				break;
};
}
}

}



// Wrote after see solution
int SIZE = 8;

void placeQueens (int row, int[] column, ArrayList<Integer[]> results){
	if(row == SIZE){
		results.add(column.clone);
		return;
}

for(int col = 0; col < SIZE; col++){
	if(isPromising(column, row, col)){
		column[row] = col;
		placeQueens(row+1, column, results);
}
}

}

boolean isPromising(int[] column, int row, int col){
	int tempRow;
	
for(tempRow = 0; tempRow < row; tempRow++){
	int tempCol = column[tempRow];
	if(tempCol == col || Math.abs(tempCol - col) == Math.abs(tempRow - row))
		return false;
}
return true;
}
