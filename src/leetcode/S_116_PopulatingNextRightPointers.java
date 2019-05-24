package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class S_116_PopulatingNextRightPointers {
	// 在原节点上操作
    public Node connect1(Node root) {
        ArrayList<LinkedList<Node>> queues = new ArrayList<>();
        queues.add(new LinkedList<Node>());
        queues.add(new LinkedList<Node>());
        int curr = 0;
        Node node = root;
        while(node != null){
        	queues.get(1-curr).add(node.left);
        	queues.get(1-curr).add(node.right);
        	if(queues.get(curr).isEmpty())
        		curr = 1 - curr;
        	else
        		node.next = queues.get(curr).peek(); 
        	node = queues.get(curr).removeFirst();
        }
        return root;
    }
    // 递归
    public Node connect(Node root) {
        if(root == null) return null;
        if(root.left != null) {
        	root.left.next = root.right;
        	if(root.next != null) root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
    public Node connect2(Node root) {
    	if(root == null) return null;
        ArrayList<LinkedList<Node>> queues = new ArrayList<>();
        queues.add(new LinkedList<Node>());
        queues.add(new LinkedList<Node>());
        Node node;
    	queues.get(0).add(root);
    	int curr = 0;
        while(!queues.get(0).isEmpty() || !queues.get(1).isEmpty()){
        	node = queues.get(curr).removeFirst();
        	if(node.left != null)
        		queues.get(1-curr).add(node.left);
        	if(node.right != null)
        		queues.get(1-curr).add(node.right);
    		if(queues.get(curr).isEmpty())
    			curr = 1 - curr;
    		else
    			node.next = queues.get(curr).peek(); 
        }
        return root;
    }
  //based on level order traversal
    public Node connect3(Node root) {
    	
    	Node head = null;
    	Node prev = null;
    	Node curr = root;
    	// 处理当前层
        while(curr != null){
        	// 处理当前节点的左右节点
        	while(curr != null){
        		if(curr.left != null){
        			if(prev != null) prev.next = curr.left;
        			else head = curr.left;
        			prev = curr.left;
        		}
        		if(curr.right != null){
        			if(prev != null) prev.next = curr.right;
        			else head = curr.right;
        			prev = curr.right;
        		}
        		curr = curr.next;
        	}
        	curr = head;
        	head = null;
        	prev = null;
        }
        return root;
    }
}
