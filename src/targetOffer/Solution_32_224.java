package targetOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 把数组排成最小的数
 * 给数组排序：排序规则/定义：比较x+y和y+x大小
 */
public class Solution_32_224 {
	public String PrintMinNumber(int[] numbers) {
		if (numbers.length == 0)
			return "";
		ArrayList<Integer> list = new ArrayList<>();
		for (int num : numbers)
			list.add(num);
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return (Integer.toString(o1) + Integer.toString(o2))
						.compareTo((Integer.toString(o2) + Integer.toString(o1)));
			}
		});
		StringBuilder res = new StringBuilder();
		for (Integer str : list)
			res.append(str);
		return res.toString();

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution_32_224().PrintMinNumber(new int[] { 3 }));
	}

}
