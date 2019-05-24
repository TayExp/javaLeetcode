package targetOffer;

/*
 * 二叉树的深度（含根和叶节点的最长路径
 */
public class Solution_38_225 {
	public int TreeDepth(TreeNode root) {
		if (root == null)
			return 0;
		int nLeft = TreeDepth(root.left);
		int nRight = TreeDepth(root.right);
		return Math.max(nLeft, nRight) + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
