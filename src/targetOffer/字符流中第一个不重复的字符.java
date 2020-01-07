package targetOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class 字符流中第一个不重复的字符 {
	int[] count = new int[256];
	ArrayList<Character> list = new ArrayList<>();
	public 字符流中第一个不重复的字符() {
		Arrays.fill(count, -1);
	}
	// Insert one char from stringstream
	public void Insert(char ch) {
		count[(int)ch] = count[(int)ch]==-1?1:-2;
		list.add(ch);
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		for(char c : list) {
			if(count[(int)c] == 1) return c;
		}
		return '#';
	}
}
