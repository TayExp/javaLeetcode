package targetOffer;

/* 二叉搜索树与双向链表
 * 输入一棵“二叉搜索树”，将该二叉搜索树转换成一个“排序”的“双向”链表。
 * 要求不能创建任何新的结点，“只能调整树中结点指针”的指向。
 * 主函数：“辅助变量pLastNodeInList,初始为空，存取处理好的最后一个节点”
 * 		核心函数(根节点,辅助变量)，调用后末尾节点=辅助变量，从后往左直到头结点而返回
 * 递归函数：出口为节点为空；
 * 		pCurrent = pNode;
 * 		处理pcurrent.left
 * 		构造双向链表：purrent.left = 辅助节点;辅助节点.right = pCurrent
 *		处理pcurrent.right
 */
public class Solution_26_222_H {
	TreeNode lastNodeInList = null;
	public TreeNode Convert(TreeNode pRootOfTree) {
		ConvertNode(pRootOfTree);
		while (lastNodeInList != null && lastNodeInList.left != null)
			lastNodeInList = lastNodeInList.left;
		return lastNodeInList;
	}

	public void ConvertNode(TreeNode pNode) {
		if(pNode == null)
			return;
		TreeNode pCurrent = pNode;
		if (pCurrent.left != null)
			ConvertNode(pCurrent.left);
		pCurrent.left = lastNodeInList;
		if (lastNodeInList != null)
			lastNodeInList.right = pCurrent;
		lastNodeInList = pCurrent;
		if (pCurrent.right != null)
			ConvertNode(pCurrent.right);
	}
}
