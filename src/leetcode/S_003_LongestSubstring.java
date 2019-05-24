package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Given a string, find the length of 
 * the longest substring without repeating characters.
 * method1:nested loops with i from 0 to n−1 and j from i+1 to n
 * method2:A sliding window is a window "slides" its two boundaries to the certain direction
 * 
 */
public class S_003_LongestSubstring {

	public int lengthOfLongestSubstring1(String s) {
		int n = s.length(), i = 0, j = 0, ans = 0;
		Set<Character> set = new HashSet<>();
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;

	}

	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j)))
				i = Math.max(map.get(s.charAt(j)), i);
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;

	}

	public boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if (set.contains(ch))
				return false;
			set.add(ch);
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
