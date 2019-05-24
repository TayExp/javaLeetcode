package targetOffer;

/* 输入一个链表，输出该链表中倒数第k个结点。
 * 两个指针，辅助指针先走k步
 * 再同步走，直到辅助指针走到头
 */
public class Solution_14 {

	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k <= 0)
			return null;
		ListNode pAhead = head;
		ListNode pBehind = head;
		for (int i = 0; i < k; i++) {
			pAhead = pAhead.next;
			if (pAhead == null)
				if (i < k - 1)
					return null;
				else
					return head;
		}
		while (!(pAhead == null)) {
			pAhead = pAhead.next;
			pBehind = pBehind.next;
		}
		return pBehind;
	}

}
