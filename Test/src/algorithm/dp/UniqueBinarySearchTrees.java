package algorithm.dp;

import java.util.ArrayList;
import java.util.List;

import algorithm.TreeNode;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1...n?
 * 
 * For example, Given n = 3, there are a total of 5 unique BST's. 1 3 3 2 1 \ /
 * / / \ \ 3 2 1 1 3 2 / / \ \ 2 1 2 3
 * 
 * (�����Ҫ����еĶ������������������ʵ�����������������ȡ����ֻҪ����������������Ҫ��Ϳ��ԡ�
 * �Ӵ���������ĽǶ�������ѡȡһ�����Ϊ�����Ͱѽ���г�������������������Ϊ���Ŀ��ж������������������������ж����������ĳ˻���
 * �����ܵ������ǽ������н��Ϊ���Ŀ��н���ۼ�����) res[0] = 1, res[n+1] = sigma(res[i]*res[n-i]) i>=0
 * 
 * @author Nacking
 * 
 */
public class UniqueBinarySearchTrees {

	public int numTrees(int n) {
		if (n <= 0)
			return 0;
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				res[i] += res[j] * res[i - j - 1];
			}
		}
		return res[n];
	}

	public List<TreeNode> generateTrees(int n) {
		return generateTree(1, n + 1);
	}

	private List<TreeNode> generateTree(int min, int max) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		// base case
		if (min >= max) {
			TreeNode node = null;
			list.add(node);
		}
		// general case
		for (int i = min; i < max; i++) {
			List<TreeNode> left = generateTree(min, i);
			List<TreeNode> right = generateTree(i + 1, max);
			for (int p = 0; p < left.size(); p++) {
				for (int q = 0; q < right.size(); q++) {
					TreeNode root = new TreeNode(i);
					root.left = left.get(p);
					root.right = right.get(q);
					list.add(root);
				}
			}
		}
		return list;
	}

}
