package algorithm;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;

		ListNode res = new ListNode(0);
		ListNode head = res;

		ListNode root1 = l1;
		ListNode root2 = l2;

		while (root1 != null && root2 != null) {
			if (root1.val < root2.val) {
				res.next = root1;
				root1 = root1.next;
				res = res.next;
			} else if (root1.val >= root2.val) {
				res.next = root2;
				root2 = root2.next;
				res = res.next;
			}
		}

		if (root1 != null) {
			res.next = root1;
		} else if (root2 != null) {
			res.next = root2;
		}

		head = head.next;
		return head;
	}

	public static void main(String[] args) {

		MergeTwoSortedLists m = new MergeTwoSortedLists();

		ListNode l1 = new ListNode(0);
		// l1.next = new ListNode(3);
		ListNode l2 = new ListNode(1);
		// l2.next = new ListNode(4);

		System.out.println(m.mergeTwoLists(l1, l2));
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		ListNode root = this;
		while (root != null) {
			sb.append(root.val);
			sb.append(", ");
			root = root.next;
		}

		return sb.toString();
	}
}
