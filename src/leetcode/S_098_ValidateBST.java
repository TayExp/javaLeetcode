package leetcode;

import java.util.Stack;

public class S_098_ValidateBST {
   	//判断是否是二叉搜索树
	//中序遍历是否是排序数组
	public boolean isValidBST(TreeNode root) {
        boolean startflag = false;
        int last = 0;
        Stack<TreeNode> stack = new Stack<>();
        while( root!=null || !stack.isEmpty()){
        	while(root!=null){
        		stack.push(root);
        		root = root.left;
        	}
        	root = stack.pop();
        	if(startflag && root.val <= last)
        		return false;
        	else{
        		startflag = true;
        		last = root.val;
        	}
        	last = root.val;
        	root = root.right;
        }
		return true;
	}
	
	
	//判断是否是平衡二叉树
	public boolean IsBalanced_Solution(TreeNode root) {
		int[] depth = new int[1];
		return IsBalanced(root, depth);
	}

	private boolean IsBalanced(TreeNode root, int[] newDepth) {
		if (root == null) {
			newDepth[0] = 0;
			return true;
		}
		int[] LnewDepth = new int[1], RnewDepth = new int[1];
		boolean bLeft = IsBalanced(root.left, LnewDepth);
		boolean bRight = IsBalanced(root.right, RnewDepth);
		if (bLeft && bRight) {
			if (Math.abs(LnewDepth[0] - RnewDepth[0]) <= 1 ) {
				newDepth[0] = Math.max(LnewDepth[0], RnewDepth[0]) + 1;
				return true;
			}
		}
		return false;
	}
}
