package leetcode;

public class S_148_SortList_150_151 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head,prev = null, fast = head;
        while(fast != null && fast.next != null){
        	prev = slow;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        prev.next = null;
        slow = sortList(head);
        fast = sortList(slow);
        return merge(slow,fast);
    }

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0), p = dummy;
		while(l2!=null && l1!=null){
			if(l2.val < l1.val){
				p.next = l2;
				l2 = l2.next;
			}else{
				p.next = l1;
				l1 = l1.next;
			}
			p = p.next;
		}
		if(l1 != null)
			p.next = l1;
		else if(l2 != null)
			p.next = l2;
		return dummy.next;
	}
}
