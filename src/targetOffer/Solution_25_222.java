package targetOffer;

/* 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
 * 返回结果为复制后复杂链表的head
 * 解法分为三步：克隆链表成双倍长度；克隆随机部分的指针；分离成原链表和要返回的副本链表。
 */
public class Solution_25_222 {
	public class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;

		RandomListNode(int label) {
			this.label = label;
		}
	}

	public RandomListNode Clone(RandomListNode pHead) {
		if (pHead == null)
			return null;
		RandomListNode pNode = pHead;
		while (pNode != null) {
			RandomListNode pCloned = new RandomListNode(pNode.label);
			pCloned.next = pNode.next;
			pNode.next = pCloned;
			pNode = pCloned.next;
		}
		pNode = pHead;
		while (pNode != null) {
			if (pNode.random != null)
				pNode.next.random = pNode.random.next;
			pNode = pNode.next;
			// 这写错了，，往下走两个
		}
		pNode = pHead;
		RandomListNode pClonedHead = pHead.next;
		RandomListNode pCloned = pClonedHead;
		while (pCloned.next != null) {
			pNode.next = pCloned.next;
			pCloned.next = pCloned.next.next;
			pNode = pNode.next;
			pCloned = pCloned.next;
		}
		pNode.next = null;
		return pClonedHead;
	}
}
