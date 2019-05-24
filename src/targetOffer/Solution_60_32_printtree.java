package targetOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * nextLevel += 1
 *  if toBePrinted == 0:
                result.append(currentResult)
                currentResult = []
                toBePrinted, nextLevel = nextLevel, 0
 */
public class Solution_60_32_printtree {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (pRoot == null)
			return result;
		Queue<TreeNode> q = new LinkedList<>();
		int tobePrinted = 1, nextLevel = 0;
		q.add(pRoot);
		TreeNode pNode;
		ArrayList<Integer> list = new ArrayList<>();
		while (!q.isEmpty()) {
			pNode = q.poll();
			list.add(pNode.val);
			tobePrinted--;
			if (pNode.left != null) {
				q.add(pNode.left);
				nextLevel++;
			}
			if (pNode.right != null) {
				q.add(pNode.right);
				nextLevel++;
			}
			if (tobePrinted == 0) {
				result.add((ArrayList<Integer>) list.clone());
				list.clear();
				tobePrinted = nextLevel;
				nextLevel = 0;
			}
		}
		return result;
	}
}
