package leetcode;

import java.util.Stack;

public class S_109_ConvertSortedListToBST {
	//借用数组已经实现的方法
    public TreeNode sortedListToBST1(ListNode head) {
        Stack<Integer> nums = new Stack<>();
        while(head!=null)
            nums.push(head.val);
        return helper(nums, 0 , nums.size()-1);
    }
    
    private TreeNode helper(Stack<Integer> nums, int low, int high){
        if(low > high)
            return null;
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = helper(nums,low,mid-1);
        root.right = helper(nums,mid+1,high);
        return root;
    }
    
    //处理链表
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
        	return null;
        ListNode slow = head, fast = head, prev = null;
        while(fast.next != null && fast.next.next != null){
        	prev = slow;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if(prev != null)
            prev.next = null;
        else
            head = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
