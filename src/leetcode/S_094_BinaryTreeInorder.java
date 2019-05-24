package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S_094_BinaryTreeInorder {
//    public List<Integer> inorderTraversal(TreeNode root) {
//    	List<Integer> inorder = new ArrayList<>();
//    	Stack<TreeNode> stack = new Stack<>();
//    	TreeNode pnode = root;
//    	while(!stack.isEmpty() || pnode != null){
//    		if(pnode!=null){
//    			if(pnode.right!=null)
//    				stack.push(pnode.right);
//    			inorder.add(pnode.val);
//    			pnode = pnode.left;
//    		}else{
//    			pnode = stack.pop();
//    		}
//    	}
//    	return inorder;
//    }
    public List<Integer> inorderTraversal(TreeNode pnode) {
    	List<Integer> inorder = new ArrayList<>();
    	Stack<TreeNode> stack = new Stack<>();
    	while(!stack.isEmpty() || pnode != null){
    		while(pnode!=null){
    			stack.push(pnode);
    			pnode = pnode.left;//寻找最左节点
    		}
    		pnode = stack.pop();
    		inorder.add(pnode.val);
    		pnode = pnode.right;
    	}
    	return inorder;
    }
}
