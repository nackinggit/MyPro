package algorithm;

public class ErchaShuBianLi {
	
	public static void inOrder(Node root) {
		if(root != null) {
			inOrder(root.l);
			System.out.println(root.val);
			inOrder(root.r);
		}
	}
	
	public static void afterOrder(Node root) {
		if(root != null) {
			inOrder(root.l);
			inOrder(root.r);
			System.out.println(root.val);
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(5);
		root.l = new Node(6);
		root.r = new Node(4);
		
		inOrder(root);
		afterOrder(root);
	}
	
}

class Node {
	Node l;
	Node r;
	int val;
	public Node(int val) {
		this.val = val;
	}
}