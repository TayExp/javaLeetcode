package targetOffer;

/*
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 注意: 在返回值的list中，数组长度大的数组靠前
 * 核心函数：（root,expectNum,curNum,path,ipath）
 * 递归解法：当前值=当前val，ipath同时增加当前节点。如果符合条件保存路径
 * 如果左不空，递归左；如果右不空，递归右
 * 回溯，ipath中pop当前节点
 */
import java.util.ArrayList;

public class Solution_24_221_H {
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		ArrayList<Integer> ipath = new ArrayList<>();
		int curSum = 0;
		FindPathCore(root, target, curSum, result, ipath);
		return result;
	}

	public void FindPathCore(TreeNode root, int target, int curSum, ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> ipath) {
		curSum += root.val;
		ipath.add(root.val);
		if (curSum == target && root.left == null && root.right == null)
			result.add(new ArrayList<Integer>(ipath));
		if (root.left != null)
			FindPathCore(root.left, target, curSum, result, ipath);
		if (root.right != null)
			FindPathCore(root.right, target, curSum, result, ipath);
		ipath.remove(ipath.size() - 1);
	}
}
