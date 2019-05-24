package targetOffer;

import targetOffer.Solution_03.ListNode;

/*
 * 两个链表的第一个公共节点
 * 方法：确定两个链表的长度，两个指针，，长链表的指针先走几步
 */
public class Solution_36_224 {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		int len1 = 0, len2 = 0;
		ListNode pNode1 = pHead1, pNode2 = pHead2;
		while (pNode1 != null) {
			len1++;
			pNode1 = pNode1.next;
		}
		while (pNode2 != null) {
			len2++;
			pNode2 = pNode2.next;
		}
		pNode1 = pHead1;
		pNode2 = pHead2;
		while(len1>len2){
			len1--;
			pNode1 = pNode1.next;
		}
		while(len1<len2){
			len2--;
			pNode2 = pNode2.next;
		}
		while (pNode1 != pNode2 && pNode1 != null) {
			pNode1 = pNode1.next;
			pNode2 = pNode2.next;
		}
		return pNode1;
	}
}
