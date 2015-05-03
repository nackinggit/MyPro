package algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class RomoveFromEnd {
	public ListNode2 removeNthFromEnd(ListNode2 head, int n) {
		ArrayList<ListNode2> list = new ArrayList<>();
		ListNode2 head2;
		ListNode2 head3;
		while (head != null) {
			list.add(head);
			head = head.next;
		}
		System.out.println(list.size());
		Collections.reverse(list);
		System.out.println(list.size());
		list.remove(n - 1);
		System.out.println(list.size());
		Collections.reverse(list);
		System.out.println(list.size());
		head2 = list.get(0);
		head3 = head2;
		for (int i = 1; i < list.size(); i++) {
			head2.next = list.get(i);
			head2 = head2.next;
		}
		return head3;
	}

	public static void main(String[] args) {
		ListNode2 head = new ListNode2(1);
		head.next = new ListNode2(2);

		RomoveFromEnd r = new RomoveFromEnd();
		ListNode2 h = r.removeNthFromEnd(head, 1);

		while (h != null) {
			System.out.println(h.val);
			h = h.next;
		}
	}
}

class ListNode2 {
	int val;
	ListNode2 next;

	ListNode2(int x) {
		val = x;
		next = null;
	}
}
