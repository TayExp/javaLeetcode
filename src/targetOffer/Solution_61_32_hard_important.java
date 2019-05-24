package targetOffer;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Solution_61_32_hard_important {
	String Serialize(TreeNode root) {
		StringBuilder res = new StringBuilder();
		SerializeCore(root, res);
		return res.toString();
	}

	void SerializeCore(TreeNode root, StringBuilder res) {
		if (root == null) {
			res.append("#,");
			return;
		}
		res.append(root.val + ",");
		SerializeCore(root.left, res);
		SerializeCore(root.right, res);
	}

	TreeNode Deserialize(String str) {
		Queue<Integer> res = ReadStr(str);
		return DeserializeCore(res);
	}

	TreeNode DeserializeCore(Queue<Integer> list) {
		int val = list.poll();
		TreeNode root = null;
		if (val < Integer.MAX_VALUE) {
			root = new TreeNode(val);
			root.left = DeserializeCore(list);
			root.right = DeserializeCore(list);
		}
		return root;
	}

	Queue<Integer> ReadStr(String str) {
		Queue<Integer> res = new LinkedList<>();
		int count = 0;
		while (count < str.length()) {
			if(str.charAt(count)=='#'){
				count+=2;
				res.add(Integer.MAX_VALUE);
			}
			else{
				int num =0;
				while(str.charAt(count)!=','){
					num = num * 10 + (str.charAt(count++) - '0');
				}
				res.add(num);
				count++;
			}
		}
		return res;
	}
}
