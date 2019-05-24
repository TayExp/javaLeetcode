package targetOffer;

import java.util.ArrayList;
import java.util.Stack;

/*
 * 按照之字形打印二叉树
 * if current == 0:
                if node.left:
                    stack[1-current].append(node.left)
                if node.right:
                    stack[1-current].append(node.right)
            else: # 1
                if node.right:
                    stack[1-current].append(node.right)
                if node.left:
                    stack[1-current].append(node.left)
 */
public class Solution_59_32_printtree {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (pRoot == null)
			return result;
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Stack<TreeNode>> stacks = new ArrayList<>();
		stacks.add(new Stack<TreeNode>());
		stacks.add(new Stack<TreeNode>());
		int current = 0;
		stacks.get(0).add(pRoot);
		TreeNode pNode;
		while (!stacks.get(0).isEmpty() || !stacks.get(1).isEmpty()) {
			pNode = stacks.get(current).pop();
			list.add(pNode.val);
			if (current == 0) {
				if (pNode.left != null)
					stacks.get(1).add(pNode.left);
				if (pNode.right != null)
					stacks.get(1).add(pNode.right);
			} else {
				if (pNode.right != null)
					stacks.get(0).add(pNode.right);
				if (pNode.left != null)
					stacks.get(0).add(pNode.left);
			}
			if (stacks.get(current).isEmpty()) {
				result.add((ArrayList<Integer>) list.clone());
				list.clear();
				current = 1 - current;
			}
		}
		return result;
	}
}
