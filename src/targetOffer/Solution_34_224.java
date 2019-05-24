package targetOffer;

/*
 * 第一次只出现一次的字符，返回它的位置
 * 大小为256的哈希表
 */
public class Solution_34_224 {
	public int FirstNotRepeatingChar(String str) {
		if (str.isEmpty())
			return -1;
		int[] hashTable = new int[256];
		for(int i = 0;i<str.length();i++)
			hashTable[(int)str.charAt(i)] += 1;
		for(int i = 0;i<str.length();i++)
			if (hashTable[(int) str.charAt(i)] == 1)
				return i;
		return -1;
	}
}
