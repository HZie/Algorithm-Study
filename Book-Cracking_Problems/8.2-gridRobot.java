// WRONG! READ QUESTION CAREFULLY
// recursive
int pathCount(int[][] grid){
	return pathCount(grid, 0, 0);
}

int pathCount(int[][] grid, int currRow, int currCol){
	// grid[i][j] == 0 → prohibited
	if(currRow == grid.length || currCol == grie[0].length || grid[currRow, currCol] == 1)
		return 0;
	
	return pathCount(grid, currRow+1, currCol) + pathCount(currRow, currCol+1);
}

// memoization
int pathCount(int[][] grid){
	int[][] mem = new int[grid.length][grid[0].length];
	Arrays.fill(mem, -1);
	pathCount(grid, 0, 0, mem);
}

int pathCount(int[][] grid, int currRow, int currCol, int[][] mem){
	if(currRow >= grid.length || currCol >= grid[0].length || grid[currRow, currCol] == 1)
		return 0;
	
	if(mem[row][col] == -1){
		mem[row][col] = pathCount(grid, row+1, col, mem) + pathCount(grid, row, col+1, mem);
	}
	
	return mem[row][col];
}



// Solution
// recursion
ArrayList<Point> getPath(boolean[][] maze){
	if(maze == null || maze.length == 0)	return null;
	ArrayList<Point> path = new ArrayList<Point>();
	if(getPath(maze, maze.length-1, maze[0].length-1, path)){
		return path;
	}
	return null;
}

boolean getPath(boolean[][] mze, int row, int col, ArrayList<Point> path){
	if(col < 0 || row < 0 || !maze[row][col])
		return false;
	
	boolean isAtOrigin = (row == 0) && (col == 0);
	
	if(isAtOrigin || getPath(maze, row, col-1, path) || getPath(maze, row-1, col, path)){
		Point p = new Point(row,col);
		path.add(p);
		retrun true;
	}

	return false;
}

// memoization
ArrayList<Point> getPath(boolean[][] maze){
	if(maze == null || maze.length == 0)	return null;
	ArrayList<Point> path = new ArrayList<>();
	
	if(getPath(maze, maze.length-1, maze[0].length-1, path, new HashSet<>()))
		return path;
	return null;
}

boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failed){
	if(col < 0 || row < 0 || !maze[row][col]
		return false;
	Point p = new Point(row, col);
	if(failed.contains(p))
		return false;
	boolean isAtOrigin = (row == 0) && (col == 0);
	if(isAtOrigin || getPath(maze, row-1, col, path, failed) || getPath(maze, row, col-1, path, failed)){
		path.add(p);
		return true;
	}
	failed.add(p);
	return false;
}
