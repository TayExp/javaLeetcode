package targetOffer;

/* 输入一个链表，反转链表后，输出新链表的表头。
 * 
 */
public class Solution_15 {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode ReverseList(ListNode head) {
		ListNode pNode = head;
		ListNode pPrev = null;
		while (!(pNode == null)) {
			ListNode pNext = pNode.next;// 保存下个节点
			pNode.next = pPrev;
			pPrev = pNode;
			pNode = pNext;// 接着处理下个
		}
		return pPrev;
	}
}
