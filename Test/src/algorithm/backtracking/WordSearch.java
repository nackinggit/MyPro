package algorithm.backtracking;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 
 * For example,
 * Given board =
 * [
 * 	["ABCE"],
 * 	["SFCS"],
 * 	["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * @author Nacking
 *
 */
public class WordSearch {
	
	boolean solution = false;
	boolean[][] mark;
	
	public boolean exists(char[][] board, String word) {
		solution = false;
	    int sizey = board.length;
	    int sizex = board[0].length;
	    mark = new boolean[sizey][sizex];

	    for(int x = 0; x < sizex; x++) {
	        for (int y = 0; y < sizey; y++) {
	            if (board[y][x] == word.charAt(0)) backtrack(board, new Cordinate(x,y), 0 , word);
	            if(solution) return true;
	        }
	    }
	    return false ;  
		
	}
	
	private void backtrack(char[][] board, Cordinate c, int k, String word) {
		if(k == word.length()) {
			solution = true;
		}
		else {
			if(c.getX() < 0 || c.getX() >= board[0].length
					|| c.getY() < 0 || c.getY() >= board.length) {
				return;
			}
			
			if(board[c.getY()][c.getX()] != word.charAt(k)) return;
			if(mark[c.getY()][c.getX()] == true) return;
			mark[c.getY()][c.getX()] = true;
			
			for(int i=0; i<4; i++) {
				Cordinate nextC = c.getNext(i);
				backtrack(board, nextC, k+1, word);
				if(solution) return;
			}
			
			mark[c.getY()][c.getX()] = false;
		}
	}
}

class Cordinate {
	private int x;
	private int y;
	
	public Cordinate(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Cordinate getNext(int dir) {
		Cordinate c = new Cordinate(this.x, this.y);
		switch (dir) {
		case 0:
			c.y--;
			break;
		case 1:
			c.x++;
			break;
		case 2:
			c.y++;
			break;
		case 3:
			c.x--;
			break;
		}
		return c;
	}
}
