package targetOffer;

/*链表中环的入口节点
 * slow走一步，fast走两步，直到相遇
 * 设另一slow2从头开始，slow2和slow一起走，直到相遇
 * 证明：2*slow-n = slow-x ==> x = n-slow
 */
public class Solution_55_31_linklist {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		ListNode slow = pHead, fast = pHead;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				ListNode slow2 = pHead;
				while (slow2 != slow) {
					slow = slow.next;
					slow2 = slow2.next;
				}
				return slow2;
			}
		}
		return null;
	}
}
