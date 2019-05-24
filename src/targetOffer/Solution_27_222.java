package targetOffer;

/* 字符串的排列
 * 按字典序
 * 递归解法子函数：递归(字符串s，begin,end,result)
 * 			出口：begin == end,result.add
 * 			对于begin end之间任意字符：
 * 				交换其与begin字符，
 * 				调用递归(s,begin+1,end),
 * 				再交换回来（看情况需不需要写一行）
 *		注意！！！两个不同位置的字符相同，不用 再交换。
 */
import java.util.ArrayList;

public class Solution_27_222 {
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> result = new ArrayList<>();
		if (str.length() != 0)
			subPermutation(str, 0, str.length(), result);
		return result;
	}

	public void subPermutation(String str, int begin, int end, ArrayList<String> result) {
		if (begin == end)
			result.add(str);
		else {
			StringBuilder sb = new StringBuilder(str);
			for (int i = begin; i < end; i++) {
				if (sb.charAt(i) == sb.charAt(begin) && i != begin)
					continue;
				char tmp = sb.charAt(begin);
				sb.setCharAt(begin, sb.charAt(i));
				sb.setCharAt(i, tmp);
				subPermutation(sb.toString(), begin + 1, end, result);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution_27_222().Permutation("abc"));
	}
}
