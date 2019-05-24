package leetcode;

public class S_019_RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;
		ListNode behindnode = head;
		ListNode frontnode = head;
		for(int i = 0;i<n;i++){
			if (frontnode == null) {
				if (i + 1 < n)
					return null;
				else
					break;
			}
			frontnode = frontnode.next;
		}
		if (frontnode == null) {
			head = head.next;
			return head;
		}
		while (frontnode.next != null) {
			frontnode = frontnode.next;
			behindnode = behindnode.next;
		}
		behindnode.next = behindnode.next.next;
		return head;
	}
}
