package leetcode;

public class S_021_MergeSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head;
		if (l1.val <= l2.val) {
			head = l1;
			head.next = mergeTwoLists(l1.next, l2);
			return head;
		}
		else {
			head = l2;
			head.next = mergeTwoLists(l1, l2.next);
			return head;
		}
	}
}