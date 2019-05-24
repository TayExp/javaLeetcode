package leetcode;

public class S_025_ReverseNodes {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode realHead = new ListNode(-1);
		ListNode pPrev = realHead, pTemp = head, pNode = head, pLast = pNode;
		int cn = 0, len = 0, loop = 0;
		while (pTemp != null) {
			pTemp = pTemp.next;
			len++;
		}
		if (len <= 1 || len < k)
			return head;
		len /= k;
		while (pNode != null) {
			if (cn == k) {
				loop++;
				if (loop == len) {// 剩下的不足k个
					pLast.next = pNode;
					break;
				}
				pPrev = pLast;
				cn = 0;
				pLast = pNode;
			}
			pTemp = pNode;
			pNode = pNode.next;// 保存下个节点
			pTemp.next = pPrev.next;// 将节点插入到pPrev后面
			pPrev.next = pTemp;// realhead->已处理节点->null
			cn++;
		}
		return realHead.next;
	}
}
