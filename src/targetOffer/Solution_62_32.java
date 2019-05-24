package targetOffer;

/*
 * 二叉搜索树种的第K(小)节点
 */
public class Solution_62_32 {
	TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot != null && k > 0) {
			int[] ks = new int[1];
			ks[0] = k;
			return KthNodeCore(pRoot, ks);
		}
		else
			return null;
	}

	private TreeNode KthNodeCore(TreeNode pRoot, int[] k) {
		TreeNode target = null;
		if (pRoot.left != null)
			target = KthNodeCore(pRoot.left, k);
		if(target == null){
			if(k[0]==1)
				target = pRoot;
			k[0]--;
		}
		if (target == null && pRoot.right!=null)
			target = KthNodeCore(pRoot.right, k);
		return target;
	}
}
