package leetcode;

// Definition for singly-linked list.

public class S_002_ElementaryMath {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode p = l1;
		ListNode q = l2;
		int sum = 0;
		ListNode currentNode = null;
		ListNode sumNode = null;
		int carry = 0;

		while ((p != null) || (q != null)) {
			if (p == null && q != null) {
				sum = q.val + carry;
				q = q.next;
			} else if (q == null) {
				sum = p.val + carry;
				p = p.next;
			} else {
				sum = p.val + q.val + carry;
				p = p.next;
				q = q.next;
			}
			carry = sum / 10;
			if (currentNode == null) {
				sumNode = currentNode = new ListNode(sum % 10);
				continue;
			}
			currentNode.next = new ListNode(sum % 10);
			currentNode = currentNode.next;
		}
		if (carry == 1)
			currentNode.next = new ListNode(1);
		return sumNode;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		// l1.next = new ListNode(4);
		// l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		// l2.next = new ListNode(6);
		// l2.next.next = new ListNode(4);
		ListNode sum = new S_002_ElementaryMath().addTwoNumbers(l1, l2);
		System.out.println(sum.val + " " + sum.next.val + " ");
	}
}
