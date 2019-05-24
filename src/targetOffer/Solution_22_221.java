package targetOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 使用队列即可
 */
public class Solution_22_221 {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> printList = new ArrayList<>();
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			TreeNode curNode = root;
			while (!queue.isEmpty() || curNode != null) {
				if (curNode != null) {
					printList.add(curNode.val);
					queue.add(curNode.left);
					queue.add(curNode.right);
				}
				// 不需要else，需要每次更换节点
				curNode = queue.poll();
			}

		}
		return printList;
	}

	public static void main(String[] args) {

	}
}
