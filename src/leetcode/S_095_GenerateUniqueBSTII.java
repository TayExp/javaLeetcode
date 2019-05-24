package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S_095_GenerateUniqueBSTII {
	public List<TreeNode> generateTrees(int n) {
		if(n<1)
			return new ArrayList<TreeNode>();
		return generate(1, n); 
    }

	private List<TreeNode> generate(int start, int end) {
		List<TreeNode> roots = new ArrayList<>();
        if(start > end){
            roots.add(null);
			return roots;
        }
		if(start == end){
			roots.add(new TreeNode(start));
			return roots;
		}
		for(int i = start; i <= end; i++){
			List<TreeNode> lefts = generate(start, i-1);
			List<TreeNode> rights = generate(i+1, end);
			for(TreeNode left :lefts)
				for(TreeNode right : rights){
					TreeNode tn = new TreeNode(i);
					tn.left = left;
					tn.right = right;
					roots.add(tn);
				}
		}
		return roots;
		
	}
	
	/*
	 * G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) 
	 */
	public int numTrees(int n) {
		int[] nums = new int[n+1];
		nums[0] = 1;
		if(n > 0){
			nums[1] = 1;
			for(int i = 2; i <= n; i++)
				for(int j = 0; j < i; j++){
					nums[i] += nums[j] * nums[i-1-j];
				}
		}
		return nums[n];
    }
}
