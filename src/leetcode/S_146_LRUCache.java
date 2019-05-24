package leetcode;

import java.util.HashMap;
import java.util.Map;

public class S_146_LRUCache {
	class Node{
		Node prev, next;
		int key, value;
		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	//初始化dummy节点
	Node head = new Node(0, 0), tail = new Node(0, 0);
	Map<Integer, Node> map = new HashMap<>();
	int capacity;
	public S_146_LRUCache(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}
 
	//get之后，把该节点放在最头部
    public int get(int key) {
        if(map.containsKey(key)){
        	Node node = map.get(key);
        	remove(node);
        	insertToHead(node);
        	return node.value;
        }
        return -1;
    }
    
    //删除一个节点
    private void remove(Node node) {
	    map.remove(node.key);
	    node.prev.next = node.next;
	    node.next.prev = node.prev;
	  }
	  //将一个节点加入首部,即head之后第一个
	  private void insertToHead(Node node){
		  map.put(node.key, node);
		  Node headNext = head.next;
		  head.next = node;
		  node.prev = head;
		  headNext.prev = node;
		  node.next = headNext;
	  }
   
	  //如果存在先删除，如果达到最大容量删除尾节点；
	  //由于访问所以将其放在最前面
	  public void put(int key, int value) {
		  if(map.containsKey(key)) {
			  remove(map.get(key));
		  }
		  if(map.size() == capacity) {
			  remove(tail.prev);
		  }
		  insertToHead(new Node(key, value));
	  }
	}
