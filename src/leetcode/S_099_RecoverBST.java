package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S_099_RecoverBST {
	
	// 中序遍历
	public void recoverTreex(TreeNode root) {
		if(root == null) return;
        TreeNode prev = null, first = null, second = null;
  	    Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
        	while(root!=null){
        		stack.push(root);
        		root = root.left;
        	}
        	root = stack.pop();
        	if(prev != null && root.val < prev.val){
        		if(first == null) first = prev; //存第一个反序对的前一个节点 
        		second = root;//存第二个反序对的后一个节点
        	}
        	prev = root;
        	root = root.right;
        }
    	int tmp = second.val;
    	second.val = first.val;
    	first.val = tmp;
    }
	
	
	//morris中序遍历
	 public List<Integer> inorderTraversal(TreeNode root) {
	    	List<Integer> inorder = new ArrayList<>();
	    	TreeNode pnode = root, tmp = null;
	    	while(pnode != null){
	    		if(pnode.left == null){
	    			inorder.add(pnode.val);
	    			pnode = pnode.right; //总是指向中序的下一个节点
	    		} else{
	    			tmp = pnode.left;
	    			// 找到左子树的最右子节点
	    			while(tmp.right != null && tmp.right != pnode)
	    				tmp = tmp.right;
	    			if(tmp.right == null){ //第一次遍历 == null
	    				tmp.right = pnode; // 叶子节点的右孩子记录将要遍历的顺序
	    				pnode = pnode.left;
	    			} else{ //第二次遍历 == pnode
	    				inorder.add(pnode.val); 
	    				tmp.right = null; //恢复为空节点
	    				pnode = pnode.right;
	    			}
	    		}
	    	}
	    	return inorder;
	  }
	public void recoverTree(TreeNode pnode) {
		if(pnode == null) return;
		TreeNode prev = null, first = null, second = null;
		TreeNode tmp = null;
		while(pnode != null){
			if(pnode.left == null){
				if(prev != null && pnode.val < prev.val){
		     		if(first == null) first = prev; //存第一个反序对的前一个节点 
		     		second = pnode;//存第二个反序对的后一个节点
		     	}
				prev = pnode;
				pnode = pnode.right;
			} else{
				tmp = pnode.left;
				// 找到左子树的最右子节点
				while(tmp.right != null && tmp.right != pnode)
					tmp = tmp.right;
				if(tmp.right == null){ //第一次遍历 == null
					tmp.right = pnode; // 叶子节点的右孩子记录将要遍历的顺序
					pnode = pnode.left;
				} else{ 
					if(prev != null && pnode.val < prev.val){
			     		if(first == null) first = prev; //存第一个反序对的前一个节点 
			     		second = pnode;//存第二个反序对的后一个节点
			     	}
					prev = pnode;
					tmp.right = null; //恢复为空节点
					pnode = pnode.right;
				}
			}
		}
		int temp = second.val;
    	second.val = first.val;
    	first.val = temp;
	}
}
