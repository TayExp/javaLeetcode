package leetcode;

public class S_138_CopyListRandomPointers {
	class Node {
	    public int val;
	    public Node next;
	    public Node random;

	    public Node() {}

	    public Node(int _val,Node _next,Node _random) {
	        val = _val;
	        next = _next;
	        random = _random;
	    }
	};
	public Node copyRandomList(Node head) {
		if(head == null) return null;
		Node node = head;
        while(node!=null){
        	Node copynode = new Node(node.val, node.next, null);
        	node.next = copynode;
        	node = copynode.next;
        }
        node = head;
        while(node!=null){
        	if(node.random != null)
        		node.next.random =node.random.next;
        	node = node.next.next;
        }
        Node newhead = head.next;
        node = head.next;
        while(node.next!=null){
        	head.next = node.next;
        	head = head.next;
        	node.next = head.next;
        	node = node.next;
        }
        head.next = null;
        return newhead;
    }
}
