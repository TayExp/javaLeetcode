package targetOffer;

/*删除列表中重复的节点
 * 重复的结点"保留"
 * “排序链表”
 */
public class Solution_56_31_linklist {
	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null)
			return null;
		ListNode pNode = pHead;
		while (pNode.next != null && pNode.next.val == pNode.val)
			pNode = pNode.next;
		if (pNode.next == null) {
			pHead = pNode;
		}else{
			pHead = pNode;
			ListNode preNode = pHead.next;
			int preVal = preNode.val;
			pNode = preNode.next;
			while (pNode != null) {
				if (pNode.val != preVal) {
					preNode.next = pNode;
					preNode = pNode;
					preVal = preNode.val;
				}
				pNode = pNode.next;
			}
			preNode.next = null;
		}
		return pHead;
	}

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }	
}
