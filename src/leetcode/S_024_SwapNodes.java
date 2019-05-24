package leetcode;

public class S_024_SwapNodes {
	public ListNode swapPairs(ListNode head) {
		if (head == null || (head != null && head.next == null))
			return head;
		ListNode node1 = head;
		ListNode node2 = head.next;
		ListNode node3 = head.next.next;
		head = node2; // 存表头

		while (node3 != null) {
			if (node3.next == null) {
				node1.next = node3;
				break;
			}
			node1.next = node3.next;
			node2.next = node1;
			node1 = node3;
			node2 = node3.next;
			node3 = node2.next;
			if (node3 == null) {
				node1.next = null;
				break;
			}
		}

			node2.next = node1;
		if (node1.next == node2)
				node1.next = null;
		return head;
		}
}
