package leetcode;

public class S_086_PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode before_head = new ListNode(0);
		ListNode after_head = new ListNode(0);
		ListNode before = before_head, after = after_head;
		while(head != null){
			if(head.val < x){
				//put less than x node in listbefore
				before.next = head;
				before = head;
			}else{
				//put equal or greater than x node in listafter
				after.next = head;
				after = head;
			}
			head = head.next;
		}
		before.next = after_head.next;
		after.next = null;
		return before_head.next;
	}
}
