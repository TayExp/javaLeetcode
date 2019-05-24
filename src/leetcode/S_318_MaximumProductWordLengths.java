package leetcode;
// 利用位运算：与
public class S_318_MaximumProductWordLengths {
    public int maxProduct(String[] words) {
        int ret = 0;
        for(int i = 0; i < words.length; i++) {
        	for(int j = i+1; j< words.length; j++)
        		if(noCommon(words[i], words[j]))
        			ret = Math.max(ret, words[i].length()*words[j].length());
        }
        return ret;
    }

	private boolean noCommon(String str1, String str2) {
		int[] cn =  new int[26];
		for(char c : str1.toCharArray())
			cn[c-'a']++;
		for(char c : str2.toCharArray())
			if(cn[c-'a'] != 0)
				return false;
		return false;
	}
}
