package targetOffer;

import targetOffer.Solution_15.ListNode;

/* 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 合成后的链表满足单调不减规则。
 * 递归算法：以两者中较小表头为合并后的表头head；head.next=调用函数。
 */
public class Solution_16 {
	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		ListNode pMergedHead;
		if (list1.val < list2.val) {
			pMergedHead = list1;
			pMergedHead.next = Merge(list1.next, list2);
		} else {
			pMergedHead = list2;
			pMergedHead.next = Merge(list1, list2.next);
		}
		return pMergedHead;
	}
}
