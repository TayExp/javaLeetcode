package targetOffer;

/*
 * 判断是否为平衡二叉树
 * 引入辅助的递归函数(root,depth,int[]newDepth)
 * {出口1：空返回真且新深度为0.
 *  左右递归。
 *  如果左右都不为空，左右深度差为1？是返回真，新深度为大的+1
 *  返回假，新深度为大的+1}
 */
public class Solution_39_225_skills {
	public boolean IsBalanced_Solution(TreeNode root) {
		int[] depth = new int[1];
		return IsBalanced(root, depth);
	}

	private boolean IsBalanced(TreeNode root, int[] newDepth) {
		if (root == null) {
			newDepth[0] = 0;
			return true;
		}
		int[] LnewDepth = new int[1];
		int[] RnewDepth = new int[1];
		boolean bLeft = IsBalanced(root.left, LnewDepth);
		boolean bRight = IsBalanced(root.right, RnewDepth);
		if (bLeft && bRight) {
			int diff = LnewDepth[0] - RnewDepth[0];
			if (diff <= 1 && diff >= -1) {
				newDepth[0] = Math.max(LnewDepth[0], RnewDepth[0]) + 1;
				return true;
			}
		}
		newDepth[0] = Math.max(LnewDepth[0], RnewDepth[0]) + 1;
		return false;
	}
}
