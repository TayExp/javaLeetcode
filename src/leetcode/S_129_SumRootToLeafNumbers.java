package leetcode;

import java.util.Stack;

public class S_129_SumRootToLeafNumbers {
	public int sumNumbers(TreeNode p) {
		int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level  = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int currlevel = 0;
        while(!stack.isEmpty() || p != null){
    		if(p!=null){
	        	sb.append(p.val);
	    		if(p.left == null && p.right == null)
	    			sum += Integer.parseInt(sb.toString());
	    		if(p.right != null){
	    			stack.push(p.right);
	    			level.push(currlevel+1);
	    		}
	    		p = p.left;
	    		currlevel++;
    		} else{
    			currlevel--;
    			p = stack.pop();
    			sb.delete(level.peek(),currlevel+1);
    			currlevel = level.pop();
    		}
        }
        return sum;
    }
}
