package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class S_102_BT_LOT {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        int toPrint = 1;
	    ArrayList<Integer> level = new ArrayList<>();
	    Queue<TreeNode> q = new ArrayDeque<>();
	    q.add(root);
	    while(!q.isEmpty()){
	    	root = q.poll();
	    	level.add(root.val);
	    	toPrint--;
	    	if(root.left != null) q.add(root.left);
	    	if(root.right != null) q.add(root.right);
	    	if(toPrint == 0){
	    		ret.add(new ArrayList<Integer>(level));
	    		level.clear();
	    		toPrint = q.size();
	    	}
	    }
        
        return ret;
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        int toPrint = 1;
	    ArrayList<Integer> level = new ArrayList<>();
	    Queue<TreeNode> q = new ArrayDeque<>();
	    q.add(root);
	    while(!q.isEmpty()){
	    	root = q.poll();
	    	level.add(root.val);
	    	toPrint--;
	    	if(root.left != null) q.add(root.left);
	    	if(root.right != null) q.add(root.right);
	    	if(toPrint == 0){
	    		ret.add(0,new ArrayList<Integer>(level));
	    		level.clear();
	    		toPrint = q.size();
	    	}
	    }
        return ret;
    }
}
