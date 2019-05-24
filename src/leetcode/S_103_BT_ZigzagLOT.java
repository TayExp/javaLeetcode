package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S_103_BT_ZigzagLOT {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null)  return ret;
        List<Stack<TreeNode>> q = new ArrayList<>();
        q.add(new Stack<TreeNode>());
        q.add(new Stack<TreeNode>());
        List<Integer> level = new ArrayList<>();
        int current = 0;
        q.get(current).push(root);
        while(!q.get(0).isEmpty() || !q.get(1).isEmpty()){
        	root = q.get(current).pop();
        	level.add(root.val);
        	if(current == 1){
        		if(root.right != null)
        			q.get(1-current).push(root.right);
        		if(root.left != null)
        			q.get(1-current).push(root.left);
        	}else{
        		if(root.left != null)
        			q.get(1-current).push(root.left);
        		if(root.right != null)
        			q.get(1-current).push(root.right);
        	}
        	if(q.get(current).isEmpty()){
        		current = 1 - current;
				ret.add(new ArrayList<Integer>(level));
				level.clear();
        	}
        }
        return ret;
    }
}
