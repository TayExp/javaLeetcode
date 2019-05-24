package leetcode;

public class S_092_ReverseListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m==n)
        	return head;
		int count = 1;
        ListNode prev = null, curr = head;
        while(curr!=null && count <= n){
        	count++;
        	if(count == m)
        		prev = curr;//记住第m-1个节点
        	curr = curr.next;	
        }
        //连上第n+1个节点
        ListNode dummy = new ListNode(0);
        dummy.next = curr;
        curr = prev == null?head:prev.next;
        count = m;
        while(curr!=null && count <= n){
        	ListNode temp = curr.next; 
        	curr.next = dummy.next;
        	dummy.next = curr;
        	curr = temp;
        	count++;
        }
        if(prev == null)
        	return dummy.next;
        prev.next = dummy.next;
		return head;
	}
}
