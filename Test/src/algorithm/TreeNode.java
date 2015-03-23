package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		
		List<List<Integer>> res = new ArrayList<>();
		LinkedList<TreeNode> nodequene = new LinkedList<>();
		nodequene.offer(root);//将root加在结点队列的尾部
		TreeNode levelLast = root;
		List<Integer> res1 = new ArrayList<>();
		
		if(root == null) return res;
		
		while(nodequene.size() > 0) {
			TreeNode current = nodequene.poll(); //获得并删除第一个Node
			res1.add(current.val);
			if(current.left != null) nodequene.offer(current.left);
			if(current.right != null) nodequene.offer(current.right);
			
			if(current == levelLast) {
				res.add(res1);
				res1 = new ArrayList<>();
				levelLast = nodequene.peekLast(); //获得但不删除结点队列的第一个结点
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		TreeNode root = null;
		//root.left = new TreeNode(3);
		//root.right = new TreeNode(5);
		//root.left.right = new TreeNode(6);
		
		System.out.println(levelOrder(root));
	}
}
