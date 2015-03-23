package algorithm;

import java.util.HashSet;
import java.util.Set;

public class SudokuTest {

	 public static boolean isValidSudoku(char[][] board) {
		/*if(board == null) return false;
		 
		for(int i=0;i<9;i++) {
			if(board.length != 9 || board[i].length != 9) {
				return false;
			}
		}
		
		HashSet<Character> s = new HashSet<>();
		
		char[] subR = new char[9];
		int count = 0;
		//判断行满足不满足条件
		for(int i=0; i<9; i++) {
			subR = board[i];
			for(int j = 0; j<9; j++) {
				if(subR[j] != '.') {
					if(subR[j] >= '9' || subR[j] <= '0') {
						return false;
					}
					s.add(subR[j]);
					count++;
				}
			}
			if(count != s.size()) {
				return false;
			}
			count = 0;
		}
		//判断列漫步满足
		for(int i=0; i<9; i++) {
			for(int j=0; j<9;j++) {
				subR[j] = board[i][j];
			}
			
			for(int j = 0; j<9; j++) {
				if(subR[j] != '.') {
					if(subR[j] >= '9' || subR[j] <= '0') {
						return false;
					}
					s.add(subR[j]);
					count++;
				}
			}
			if(count != s.size()) {
				return false;
			}
			count = 0;
		}
		*/
		//判断子数组满不满足
		
		 int row; 
		 int numRow; 
		 int[] sqr = new int[3]; 
		 int[] column = new int[9];

	     for(int i=0; i<board.length; i++){
	    	 row = 0;
	         if(i%3 == 0){
	        	 sqr[0] = 0;
	             sqr[1] = 0;
	             sqr[2] = 0;
	         }

	         for(int j=0; j<board[0].length; j++){
	        	 if (board[i][j] != '.'){
	        		 numRow = board[i][j]-'0';

	        		 numRow = 1<<numRow;

	        		 if(0< (row & numRow) || 0< (sqr[j/3] & numRow) || 0< (column[j%9] & numRow)){
	        			 return false;
	        		 }
	        		 else{
	        			 row |= numRow;
	        			 sqr[j/3]|= numRow;
	        			 column[j%9] |= numRow;
	                 	}
	             	}
	        	 }
	         }

	        return true;
	}
	
	public static void main(String[] args) {
		char[][] board = {{'1','2','3','4','5','6','7','8','9'},{'2','4','.','.','.','.','.','.','.'},{'1','2','3','4','5','6','7','8','9'},{'1','2','3','4','5','6','7','8','9'},{'1','2','3','4','5','6','7','8','9'},{'1','2','3','4','5','6','7','8','9'},{'1','2','3','4','5','6','7','8','9'},{'1','2','3','4','5','6','7','8','9'},{'1','2','3','4','5','6','7','8','9'}};
		System.out.println(isValidSudoku(board));
	}

}
