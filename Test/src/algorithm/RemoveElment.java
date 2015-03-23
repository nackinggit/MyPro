package algorithm;

import java.util.ArrayList;

public class RemoveElment {
	public int removeElment(int[] A, int elem) {
		 ArrayList<Integer> index_A = new ArrayList<>();
	        
	        int length = A.length;
	        int newLength = length;
	        for(int i=0; i<length; i++) {
	            if(elem == A[i]) {
	                index_A.add(i);
	                newLength--;
	            }
	        }
	        
	        for(int i=index_A.size()-1; i>=0; i--) {
	        	
	            int index = index_A.get(i);
	            for(int j=index; j<length; j++) {
	            	if(j != length-1) A[j] = A[j+1];
	            }
	            for(int m:A)
	        		System.out.println(m);
	            
	            System.out.println("----------------");
	            /*A[index] = A[length-1];
	            A[length-1] = elem;
	            length--;
	            */
	        }
	        
	        for(int i=newLength; i<length; i++) {
	        	A[i] = elem;
	        }
	        
	        return newLength;
	}
	
	public static void main(String[] args) {
		int[] A = {3,3,3,3,4,5,6,7};
		int elem = 3;
		RemoveElment re = new RemoveElment();
		System.out.println(re.removeElment(A, elem));
		
		for(int i:A)
		System.out.println(i);
	}
}
