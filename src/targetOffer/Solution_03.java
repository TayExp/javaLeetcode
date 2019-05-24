package targetOffer;

import java.util.ArrayList;

public class Solution_03 {
	
	public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (listNode == null){
            return result;
        }
	    int l = 0;
	    while (listNode != null){
	    	result.add(listNode.val); 
	    	listNode = listNode.next;
	    	l++;
	    }
	    int i = 0, j = l - 1;
	    while (i<j){
	    	int temp = result.get(i);
	    	result.set(i++, result.get(j));
	    	result.set(j--, temp);
	    }
	    return result;
	}
}
