package leetcode;

import java.util.HashMap;

public class S_013_RomanToInteger {
	public int romanToInt(String s) {
		HashMap<Character, Integer> roman = new HashMap<>();
		roman.put('I', 1);
		roman.put('V', 5);
		roman.put('X', 10);
		roman.put('L', 50);
		roman.put('C', 100);
		roman.put('D', 500);
		roman.put('M', 1000);
		int i = 0, result = 0;
		int len = s.length();
		while (i < len) {
			if (i + 1 == len) {
				result += roman.get(s.charAt(i));
				break;
			}
			int curr = roman.get(s.charAt(i));
			int next = roman.get(s.charAt(i + 1));
			if (curr >= next) {
				result += curr;
				i++;
			} else {
				result += next - curr;
				i += 2;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new S_013_RomanToInteger().romanToInt("MCMXCIV"));
	}

}
