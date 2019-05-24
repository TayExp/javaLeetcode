package targetOffer;
public class Solution_04 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0 || pre.length != in.length){
        	return null;
        }
        return constructCore(pre, in, pre.length);
    }
    public TreeNode constructCore(int[] pre, int[] in ,int length){
    	TreeNode root = new TreeNode(pre[0]);
    	if (length == 1){
    		return root;
    	}
    	int i;
    	for (i = 0; i < length; i ++){
    		if (in[i] == pre[0]){
    			break;
    		}
    	}
    	int [] pre_left = new int[i];
    	int [] in_left = new int[i];
    	for (int j = 0; j < i; j ++){
    		pre_left[j] = pre[j+1];
    		in_left[j] = in[j];
    	}
    	int [] pre_right = new int[length-1-i];
    	int [] in_right = new int[length-1-i];
    	for (int j = 0; j < length-1-i; j ++){
    		pre_right[j] = pre[i+1+j];
    		in_right[j] = in[i+1+j];
    	}
    	
    	if (i > 0){
    		root.left = constructCore(pre_left, in_left, i);
    	}
    	if (length-1-i > 0){
    		root.right = constructCore(pre_right, in_right, length-1-i);
    	}   	
    	return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
