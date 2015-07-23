package algorithm;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) 
 * Output: 7 -> 0 -> 8
 * 
 * @author Nacking
 * 
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode root = new ListNode(0);
		ListNode head = root;
		ListNode l11 = l1;
		ListNode l22 = l2;
		int count = 0;
		while(l11 != null || l22 != null) {
			int val1 = (l11 == null) ? 0 : l11.val;
			int val2 = (l22 == null) ? 0 : l22.val;
			int sum = val1 + val2 + count;
			count = 0;
			if(sum > 9) {
				count = sum/10;
				sum %= 10;
			}
			root.next = new ListNode(sum);
			root = root.next;
			l11 = (l11 == null) ? null : l11.next;
			l22 = (l22 == null) ? null : l22.next;
		}
		if(count != 0) {
			root.next = new ListNode(count);
		}
		return head.next;
	}
//        int num1 = getNum(l1);
//        int num2 = getNum(l2);
//        
//        num1 += num2;
//        
//        return constructList(num1);
//    }
//
//	private ListNode constructList(int num1) {
//		int tem = 0;
//		ListNode root = new ListNode(0);
//		ListNode head = root;
//		while(num1/10 != 0) {
//			tem = num1%10;
//			root.next = new ListNode(tem);
//			num1 = num1/10;
//			root = root.next;
//		}
//		root.next = new ListNode(num1);
//		return head.next;
//	}
//
//	private int getNum(ListNode l1) {
//		int sum = l1.val;
//		if(l1.next != null) {
//			sum += getNum(l1.next)*10;
//		}
//		return sum;
//	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(7);
		
		AddTwoNumbers a = new AddTwoNumbers();
		ListNode root = a.addTwoNumbers(l1, l2);
		System.out.println(root);
	}
}
