package targetOffer;

/*
 * 中序遍历顺序的下一个结点并且返回
 * 树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Solution_57_31_tree_needtolookback {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null)
			return null;
		TreeLinkNode pNext;
		if (pNode.right != null) {
			pNext = pNode.right;
			while (pNext.left != null)
				pNext = pNext.left;
		} else {
			TreeLinkNode pParent = pNode.next;
			pNext = pNode;
			while (pParent != null && pNext == pParent.right) {
				pNext = pParent; // 如果是父节点的右节点，继续往上
				pParent = pParent.next;
			}
			pNext = pParent;
		}
		return pNext;
	}
}
