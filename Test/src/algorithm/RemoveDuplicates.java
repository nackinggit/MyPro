package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicates {
	public int removeDuplicates(int[] A) {
		
		if(A.length == 0) return 0;
		
        Set<Integer> set = new TreeSet<>();
        for(int i=0; i<A.length; i++) {
            set.add(A[i]);
        }
        
        Object[] m = set.toArray();
        
        for(int i=0; i<m.length; i++) {
        	A[i] = (Integer)m[i];
        	System.out.println(A[i]);
        }
        
        return m.length;
    }
	
	public static void main(String[] args) {
		RemoveDuplicates r = new RemoveDuplicates();
		int[] A = {-1,0,0,0,0,3,3};
		System.out.println(r.removeDuplicates(A));
	}
	
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode head2 = head;
        while(head != null) {
            ListNode next = head.next;
            ListNode cur = head;
            if(next != null && cur.val == next.val) {
                head.next = next.next;
                cur = head.next;
                continue;
            }
            head = head.next;
        }
        return head2;
    }
}
