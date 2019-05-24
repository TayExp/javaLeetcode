package leetcode;

public class S_124_BTMaximumPathSum {
	int maxValue;
	public int maxPathSum(TreeNode p) {
		maxValue = Integer.MIN_VALUE;
		findMaxSum(p);
		return maxValue;
	}
	
	private int findMaxSum(TreeNode p) {
		if(p == null) return 0;
		int left = Math.max(0, findMaxSum(p.left));
		int right = Math.max(0, findMaxSum(p.right));
		maxValue = Math.max(maxValue, p.val + left + right);
		return Math.max(left, right) + p.val;
		
	}
//		int ret = 0;
//        Stack<TreeNode> stack = new Stack<>();
//        Stack<Integer> level  = new Stack<>();
//        Stack<Integer> maxsum = new Stack<>();
//        int currlevel = 0, currsum = 0;;
//        while(!stack.isEmpty() || p != null){
//    		if(p!=null){
//    			currsum = Math.max(currsum + p.val, p.val);
//	        	maxsum.push(currsum);
//	        	ret = Math.max(ret, currsum);
//	    		if(p.right != null){
//	    			stack.push(p.right);
//	    			level.push(currlevel+1);
//	    		}
//	    		p = p.left;
//	    		currlevel++;
//    		} else{
//    			p = stack.pop();
//    			while(currlevel > level.peek()){
//    				maxsum.pop();
//    				currlevel--;
//    			}
//    			level.pop();
//    		}
//        }
//        return ret;
//	}
	
}
