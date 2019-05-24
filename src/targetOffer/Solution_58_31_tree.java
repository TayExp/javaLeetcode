package targetOffer;

/*
 * 对称的二叉树
 */
public class Solution_58_31_tree {
	boolean isSymmetrical(TreeNode pRoot) {
		return isSymmetricalCore(pRoot, pRoot);
	}

	boolean isSymmetricalCore(TreeNode pRoot1, TreeNode pRoot2) {
		if (pRoot1 == null && pRoot2 == null)
			return true;
		if (pRoot1 == null || pRoot2 == null)
			return false;
		if (pRoot1.val != pRoot2.val)
			return false;
		return isSymmetricalCore(pRoot1.left, pRoot2.right) && isSymmetricalCore(pRoot1.right, pRoot2.left);

	}
}
