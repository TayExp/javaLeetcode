package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S_022_GenerateParentheses_backtrack {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		backtraking(res, "", 0, 0, n);
		return res;
	}

	public void backtraking(List<String> res, String cur, int open, int close, int max) {
		if (cur.length() == max * 2) {
			res.add(cur);
			return;
		}
		if (open < max) {
			backtraking(res, cur + "(", open + 1, close, max);
		}
		if (close < open) {
			backtraking(res, cur + ")", open, close + 1, max);
		}
	}



}
