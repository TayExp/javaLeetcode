package leetcode;

public class S_337_HouseRobberIII {
    public int rob(TreeNode root) {
    	int[] ret = robcore(root);
    	return Math.max(ret[0], ret[1]);
    }

	private int[] robcore(TreeNode root) {
		int[] ret = new int[2];
		if(root == null) return ret;
		int[] leftret = robcore(root.left);
		int[] rightret = robcore(root.right);
		ret[0] = Math.max(leftret[0], leftret[1]) + Math.max(rightret[0], rightret[1]);
		ret[1] = root.val + leftret[0] + rightret[0];
		return ret;
	}
}
