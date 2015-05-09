package algorithm.arrays;

/**
 * Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn, reorder it to:
 * L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author Nacking
 * 
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if(head == null || head.next == null) return;
		
		int len = 1;
		ListNode duph = head.next;
		ListNode head1 = new ListNode(head.val);
		ListNode curr = head1;
		while(duph != null) {
			len++;
			curr.next = new ListNode(duph.val);
			duph = duph.next;
			curr = curr.next;
		}
		
		head1 = reverseList(head1);
		
		curr = head;
		ListNode curr2 = head1;
		for(int i=0; i<len-1; i++) {
			ListNode tem = curr.next;
			curr.next = curr2;
			curr = curr2;
			curr2 = tem;
		}
		
		curr.next = null;
		curr2.next = null;
	}
	
	public ListNode reverseList(ListNode head) {
        if(head == null || (head.next == null) ) {
            return head;
        }
        
        ListNode pre = head;
        ListNode cur = head;
        ListNode nex = head;
        
        while(cur != null) {
            nex = cur.next;
            if(cur == head) {
                cur.next = null;
            } else {
                cur.next = pre;
            }
            pre = cur;
            cur = nex;
        }
        
        return pre;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		
		ReorderList r = new ReorderList();
		r.reorderList(head);
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
