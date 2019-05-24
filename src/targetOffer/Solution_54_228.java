package targetOffer;

import java.util.ArrayList;

/* 
 * 字符流中第一个不重复的字符
 * 使用哈希表
 */
public class Solution_54_228 {
	private int[] occr = new int[256];
	private ArrayList<Character> s = new ArrayList<>();

	public Solution_54_228() {
		for (int i = 0; i < occr.length; i++)
			occr[i] = -1;
	}
	// Insert one char from stringstream
	public void Insert(char ch) {
		if(occr[(int)ch] == -1)
			occr[(int) ch] = 1;
		else
			occr[(int) ch] = -2;
		s.add(ch);
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		for (int i = 0; i < s.size(); i++)
			if (occr[(int) s.get(i)] == 1)
				return s.get(i);
		return '#';
	}
}
