package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S_017_LetterCombinations_backtracking {
	List<String> output = new ArrayList<>();
	Map<String, String> map = new HashMap<String, String>() {
		{
			put("2", "abc");
		    put("3", "def");
		    put("4", "ghi");
		    put("5", "jkl");
		    put("6", "mno");
		    put("7", "pqrs");
		    put("8", "tuv");
		    put("9", "wxyz");
		}
	};
	public List<String> letterCombinations(String digits) {
		if(digits.length()!=0)
			backtrack("", digits);
		return output;
	}

	public void backtrack(String combination, String next_digits) {
		if (next_digits.length() == 0)
			output.add(combination);
		else {
			String digit = next_digits.substring(0,1);
			String letter = map.get(digit);
			for (int i = 0; i < letter.length(); i++)
				backtrack(combination + letter.charAt(i), next_digits.substring(1));
		}
	}
	public static void main(String[] args) {
		System.out.println(new S_017_LetterCombinations_backtracking().letterCombinations("23"));

	}

}
