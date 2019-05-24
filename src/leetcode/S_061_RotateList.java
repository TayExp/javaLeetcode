package leetcode;

public class S_061_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0)
        	return head;
    	ListNode pNode = head;
        int count = 1;
    	while(pNode.next != null){
    		count++;
    		pNode = pNode.next;
    	}
    	
    	k = count - k % count;
    	if(k == count)
            return head;
    	pNode.next = head; // 放在return之后
    	for(int i = 0; i < k; i++)
    		pNode = pNode.next;
    	head = pNode.next;
    	pNode.next = null;
    	return head;
    }
}
