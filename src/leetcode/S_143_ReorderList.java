package leetcode;

public class S_143_ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
    	int count = 1;
        ListNode node = head;
        while(node.next!=null){
        	count++;
        	node = node.next;
        }
        //保存最后一个节点
        ListNode dummy = node;
        count = count/2 + 1;
        node = head;
        while(count > 1){
        	count--;
        	node = node.next;
        }
        //将反序的节点接在dummy后面,构成一个环
        dummy.next = node.next;
        node.next = null;
        node = dummy.next.next;
        dummy.next.next = null;
        while(node!=dummy){
        	ListNode tmp = node.next;
        	node.next = dummy.next;
        	dummy.next = node;
        	node = tmp;
        }
        //合并两个链表
        while(head != null && dummy != null){
        	ListNode tmp = dummy.next;
        	dummy.next = head.next;
        	head.next = dummy;
        	head = dummy.next;
        	dummy = tmp;
        }
    }
}
