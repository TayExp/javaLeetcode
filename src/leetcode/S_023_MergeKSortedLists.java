package leetcode;

public class S_023_MergeKSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		int end = lists.length;
		if (end == 0) {
			ListNode node = null;
			return node;
		}
		while (end > 1) {
			for (int i = 0; i < end - 1 - i; i++) {
				lists[i] = mergeTwoLists(lists[i], lists[end - 1 - i]);
			}
			end = (end + 1) / 2;
		}

		return lists[0];

	}
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
