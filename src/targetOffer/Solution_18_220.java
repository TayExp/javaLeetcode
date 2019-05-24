package targetOffer;

import java.util.Stack;

/* 操作给定的二叉树，将其变换为源二叉树的镜像
 * 递归解法（简洁）：交换左右子树，递归左右子树
 * 循环解法（用栈）：while(栈不空或者节点不为null）{先让右节点进栈，交换左右、处理右节点}
 */
public class Solution_18_220 {
	public void Mirror(TreeNode root) {
		if (root != null) {
			if (root.left != null || root.right != null) {
				TreeNode temp = root.left;
				root.left = root.right;
				root.right = temp;
			}
			if (root.left != null)
				Mirror(root.left);
			if (root.right != null)
				Mirror(root.right);
		}
	}
	public void Mirror2(TreeNode root) {
		if(root!=null){
			Stack <TreeNode> tStack =new Stack<>();
			TreeNode pNode = root;
			while(!tStack.isEmpty() || pNode!=null){
				if (pNode!=null){
					tStack.push(pNode.right);
					if (pNode.left != null || pNode.right != null) {
						TreeNode temp = pNode.left;
						pNode.left = pNode.right;
						pNode.right = temp;
					}

					pNode = pNode.right;
				} else
					pNode = tStack.pop();
			}
		}
	}
}
