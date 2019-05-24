package leetcode;

import java.util.Stack;

public class S_147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0), node = null;
        while(head!=null){
        	ListNode temp = head.next;
            node = dummy;
        	while(node!=null){
        		if(node.next == null || node.next.val > head.val){
        			head.next = node.next;
        			node.next = head;
        			break;
        		}
                node = node.next;
        	}
        	head = temp;
        }
       return dummy.next;
    }
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(s.equals("+"))
            	stack.push(stack.pop() + stack.pop());
            else if(s.equals("-"))
            	stack.push(- stack.pop() + stack.pop());
            else if(s.equals("*"))
            	stack.push(stack.pop() * stack.pop());
            else if(s.equals("/")){
                int tmp = stack.pop();
                stack.push(stack.pop()/tmp);
            }  	
            else 
            	stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arrayS = s.split("\\s+");
        for(int i = arrayS.length-1; i >= 0; i--)
        	 sb.append(" " + arrayS[i]);
        return sb.toString().trim();
    }
    public static void main(String[] args) {
		System.out.println("**"+ new S_147_InsertionSortList().reverseWords("     HEL  LO WORLD  ")+"**");
	}
    
}
