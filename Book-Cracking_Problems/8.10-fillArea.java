// O(MN) where M is number of row, N is number of column of screen
void paintFill(int[][] screen, int r, int c, int color){
  int prevColor = screen[r][c];		

  screen[r][c] = color;
  if(r > 0){
    if(screen[r-1][c] == prevColor){
      paintFill(screen, r-1, c, color);
    }
  }
  if(r < screen.length-1){
    if(screen[r+1][c] == prevColor){
      paintFill(screen, r+1, c, color);
    }
  }
  if(c > 0){
    if(screen[r][c-1] == prevColor){
      paintFill(screen, r, c-1, color);
    }
  }
  if(c < screen[0].length){
    if(screen[r][c+1] == prevColor){
      paintFill(screen, r, c+1, color);
    }
  }
}


// Solution
enum Color {Black, White, Red, Yellow, Green}

boolean paintFill(Color[][] screen, int r, int c, Color newColor){
if(screen[r][c] == newColor)	return false;
return paintFill(screen, r, c, screen[r][c], newColor);
}

boolean paintFill(Color[][] screen, int r, int c, Color oldColor, newColor){
// escape condition
if(r < 0 || c < 0 || r >= screen.length || c >= screen[0].length)
  return false;

if(screen[r][c] == oldColor){
  paintFill(screen, r-1, c, oldColor, newColor);
  paintFill(screen, r+1, c, oldColor, newColor);
  paintFill(screen, r, c-1, oldColor, newColor);
  paintFill(screen, r, c+1, oldColor, newColor);
}
return true;
}
