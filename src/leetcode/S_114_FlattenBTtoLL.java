package leetcode;

import java.util.Stack;

public class S_114_FlattenBTtoLL {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root.left!=null ||root.right!=null){
    		if(root.right != null)
    			stack.push(root.right);
    		if(root.left != null){
    			root.right = root.left;
    			root.left = null;
    			root = root.right;
    		}
    		else if(!stack.isEmpty()){
        		root.right = stack.pop();
        		root = root.right;
    		}
        }
    }
}
