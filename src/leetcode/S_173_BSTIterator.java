package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class S_173_BSTIterator {
	Queue <Integer> sortedvals = new LinkedList<>();
	public S_173_BSTIterator(TreeNode root) {
		recursive(root);
    }
    
    private void recursive(TreeNode root) {
    	if(root == null) return;
    	recursive(root.left);
		sortedvals.add(root.val);
		recursive(root.right);
		
	}
	/** @return the next smallest number */
    public int next() {
        return sortedvals.poll();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !sortedvals.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
