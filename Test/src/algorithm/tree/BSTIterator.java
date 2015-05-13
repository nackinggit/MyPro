package algorithm.tree;

import java.util.Stack;

import algorithm.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * @author Nacking
 * 
 */
public class BSTIterator {
	
	private Stack<Integer> values = new Stack<>();
	
	public BSTIterator(TreeNode root) {
		visit(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return !values.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return values.pop();
    }
    
    private void visit(TreeNode n) {
    	if(n == null) {
    		return;
    	}
    	visit(n.right);
    	values.push(n.val);
    	visit(n.left);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
