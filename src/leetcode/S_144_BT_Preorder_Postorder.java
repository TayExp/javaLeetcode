package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S_144_BT_Preorder_Postorder {
	public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root != null)
        	preorder(root, ret);
        return ret;
    }

	private void preorder(TreeNode root, List<Integer> ret) {
		ret.add(root.val);
		if(root.left!=null) preorder(root.left, ret);
		if(root.right!=null) preorder(root.right, ret);
	}
	
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
        	if(root != null){
        		ret.add(root.val);
        		if(root.right!=null)
        			stack.push(root.right);
        		root = root.left;
        	} else{
        		root = stack.pop();
        	}
        }
        return ret;
    }
	public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root != null)
        	postorder(root, ret);
        return ret;
    }

	private void postorder(TreeNode root, List<Integer> ret) {
		
		if(root.left!=null) postorder(root.left, ret);
		if(root.right!=null) postorder(root.right, ret);
		ret.add(root.val);
    }
	
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
        	//下行循环直到栈顶的两子树空
        	while(root != null){
        		stack.push(root);
        		root = root.left != null ? root.left : root.right;
        	}
        	root = stack.pop();//栈顶是应该访问的节点
        	ret.add(root.val);
        	if(!stack.isEmpty() && stack.peek().left == root)
        		root = stack.peek().right;
        	else
        		root = null;
        }
        return ret;
    }
}
