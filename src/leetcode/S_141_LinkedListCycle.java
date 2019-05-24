package leetcode;

public class S_141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
    	if(head == null) return false;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null && fast!=slow){
        	slow = slow.next;
        	fast = fast.next.next;
        }
        return fast == slow;   
    }
    
    public ListNode detectCycle(ListNode head) {
    	
    	ListNode slow = head, fast = head;
    	while(fast != null && fast.next != null){
    		slow = slow.next;
    		fast = fast.next.next;
    		if(slow == fast){
    			slow = head;
    			while(slow != fast){
    				slow = slow.next;
    				fast = fast.next;
    			}
    			return slow;
    		}
    	}
    	return null;
    }
}
