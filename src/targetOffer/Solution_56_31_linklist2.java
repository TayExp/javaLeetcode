package targetOffer;

/*删除列表中重复的节点
 * 重复的结点"不保留"
 * “排序链表”
 */
public class Solution_56_31_linklist2 {
	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead != null && pHead.next != null) {
			ListNode pNode = pHead;
			int reserveflag = 1;
			while (pNode.next != null && pNode.next.val == pNode.val) {
				reserveflag = 0;
				pNode = pNode.next;
			}
			if(pNode.next == null)
				return null;
			else{
				if (reserveflag == 0)
					pHead = deleteDuplication(pNode.next);
				else
					pHead.next = deleteDuplication(pNode.next);
			}
		}
		return pHead;
	}
	
	//use two pointers, slow - track the node before the dup nodes, 
		// fast - to find the last node of dups.
	public ListNode deleteDuplicates(ListNode head) {
	    ListNode dummy = new ListNode(0), fast = head, slow = dummy;
	    slow.next = fast;
	    while(fast != null) {
	    	while (fast.next != null && fast.val == fast.next.val) {
	     		fast = fast.next;    //while loop to find the last node of the dups.
	    	}
	    	if (slow.next != fast) { //duplicates detected.
	    		slow.next = fast.next; //remove the dups.
	    		fast = slow.next;     //reposition the fast pointer.
	    	} else { //no dup, move down both pointer.
	    		slow = slow.next;
	    		fast = fast.next;
	    	}
	    }
	    return dummy.next;
	} 
}
