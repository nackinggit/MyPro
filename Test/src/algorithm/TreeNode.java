package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();
		LinkedList<TreeNode> nodequene = new LinkedList<>();
		nodequene.offer(root);// 将root加在结点队列的尾部
		TreeNode levelLast = root;
		List<Integer> res1 = new ArrayList<>();

		if (root == null)
			return res;

		while (nodequene.size() > 0) {
			TreeNode current = nodequene.poll(); // 获得并删除第一个Node
			res1.add(current.val);
			if (current.left != null)
				nodequene.offer(current.left);
			if (current.right != null)
				nodequene.offer(current.right);

			if (current == levelLast) {
				res.add(res1);
				res1 = new ArrayList<>();
				levelLast = nodequene.peekLast(); // 获得但不删除结点队列的第一个结点
			}
		}

		return res;
	}

	
	public TreeNode reConstruct(int[] preOrder, int[] inOrder) {
		if(preOrder.length != inOrder.length) return null;
		
		int len = preOrder.length;
		
		return _reConstruct(preOrder, 0, len - 1, inOrder, 0, len - 1);
	}

	private TreeNode _reConstruct(int[] preOrder, int ps, int pe, int[] inOrder, int is, int ie) {
		
		int rootVal = preOrder[0];
		TreeNode root = new TreeNode(rootVal);
		root.left = root.right = null;
		
		int rootIn = is;
		while(rootIn <= ie && inOrder[rootIn] != rootVal) {
			rootIn++;
		}
		
		int leftLen = rootIn - is;
		int leftPreEnd = leftLen + ps;
		
		if(leftLen > 0) {
			root.left = _reConstruct(preOrder, ps+1, leftPreEnd, inOrder, is, rootIn-1);
		}
		if(leftLen < pe - ps) {
			root.right = _reConstruct(preOrder, leftPreEnd+1, pe, inOrder, rootIn+1, ie);
		}
		
		return root;
	}
}
