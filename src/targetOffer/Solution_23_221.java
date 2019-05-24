package targetOffer;

import java.util.ArrayList;

/* 
 * 该数组是不是某二叉搜索树的 后序遍历 的结果
 * 任意两个数字都互不相同
 * 递归解法：将左子树和右子树的分界线找出来，过程中能保证左子树都小于root
 * 检查右子树是否均大于root
 * 递归左右，返回and
 */
public class Solution_23_221 {
	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence.length == 0)
			return false;
		int len = sequence.length;
		int i;
		ArrayList<Integer> leftSequence = new ArrayList<>();

		for (i = 0; i < len - 1; i++) {
			if (sequence[i] < sequence[len-1])
				leftSequence.add(sequence[i]);
			else
				break;
		}
		int[] rightArray = new int[len - 1 - i];
		for (int j = i; j < len - 1; j++) {
			if (sequence[j] > sequence[len - 1])
				rightArray[j - i] = sequence[j];
			else
				return false;
		}
		boolean bLeft = true,bRight = true;
		if (!leftSequence.isEmpty()) {
			int[] left = new int[leftSequence.size()];
			for (int k = 0; k < left.length; k++)
				left[k] = leftSequence.get(k);
			bLeft = VerifySquenceOfBST(left);
		}
		if (rightArray.length != 0) {
			bRight = VerifySquenceOfBST(rightArray);
		}
		return bLeft && bRight;
	}

	public static void main(String[] args) {
		System.out.println(new Solution_23_221().VerifySquenceOfBST(new int[] {}));
	}

}
