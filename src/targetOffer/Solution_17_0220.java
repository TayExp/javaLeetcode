package targetOffer;

/* 输入两棵二叉树A，B，
 * 判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 * 递归（主函数）：根节点值等，进入Core判断，否则调用主函数以左右子节点递归；
 * 递归（Core函数）：出口为两者之一为空或者值不相等；调用Core函数左左and右右
 */
public class Solution_17_0220 {
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null)
			return false;
		boolean result = false;
		if (root1.val == root2.val){
			result = DoesT1haveT2(root1, root2);
		}
		if (!result)
			result = HasSubtree(root1.left, root2);
		if (!result)
			result = HasSubtree(root1.right, root2);
		return result;
	}

	public boolean DoesT1haveT2(TreeNode t1, TreeNode t2) {
		if (t2 == null)
			return true;
		if (t1 == null)
			return false;
		if (t1.val != t2.val)
			return false;
		return DoesT1haveT2(t1.left, t2.left) && DoesT1haveT2(t1.right, t2.right);
	}

}
