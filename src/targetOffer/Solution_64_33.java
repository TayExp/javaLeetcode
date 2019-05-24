package targetOffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * 滑动窗口的最大值
 * 动态规划:在队列index里存入数字在数组里的下标，而非数值
 * 			当一个数字的下标与当前处理的数字下标 查 大于等于 窗口大小，从队列中删除
 * 			index是一个两端队列  保存有可能是滑动窗口最大值的数字的下标
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 */
public class Solution_64_33 {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> res = new ArrayList<>();
		if (num.length == 0 || num.length < size)
			return res;
		//
		Deque<Integer> index = new LinkedList<>();
		for (int i = 0;i<size;i++){
			while (!index.isEmpty() && num[i] >= num[index.getLast()])
				index.removeLast();
			index.addLast(i);
		}
		//
		for (int i = size; i < num.length; i++) {
			res.add(num[index.getFirst()]);
			while (!index.isEmpty() && num[i] >= num[index.getLast()])
				index.removeLast();
			if (!index.isEmpty() && (index.getFirst() <= (i - size)))
				index.removeFirst();// 从队首滑出
			index.addLast(i);// 不要忘了
		}
		res.add(num[index.getFirst()]);
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution_64_33().maxInWindows(new int[] { 2, 3, 4, 2, 6, 2, 5, 1 }, 3));
	}

}
