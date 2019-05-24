package targetOffer;

/*
 * 正则表达式匹配
 * 字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）
 * str一次处理一个字符，pattern可能一次处理两个（*
 */
public class Solution_52_228_zhengze {
	public boolean match(char[] str, char[] pattern) {
		return matchCore(str, 0, str.length, pattern, 0, pattern.length);
	}

	boolean matchCore(char[] str, int p1, int len1, char[] pattern, int p2, int len2) {
		if (p1 == len1 && p2 == len2)
			return true;
		if (p1 < len1 && p2 == len2)
			return false;
		if (p2 + 1 < len2 && pattern[p2 + 1] == '*') {
			if (p1 == len1 || (str[p1] != pattern[p2] && pattern[p2] != '.'))
				return matchCore(str, p1, len1, pattern, p2 + 2, len2);
			else {
				return matchCore(str, p1 + 1, len1, pattern, p2, len2)
						|| matchCore(str, p1, len1, pattern, p2 + 2, len2)
						|| matchCore(str, p1 + 1, len1, pattern, p2 + 2, len2);
			}

		} else if (p1 < len1) {
			if (str[p1] == pattern[p2] || pattern[p2] == '.')
				return matchCore(str, p1 + 1, len1, pattern, p2 + 1, len2);
		}
		return false;
		
	}


}
