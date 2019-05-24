package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S_030_SubstringConcatenation {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ret = new ArrayList<>();
		int numW = words.length, lenS = s.length();
		if (lenS == 0 || numW == 0)
			return ret;
		int sizeW = words[0].length(), sizeChs = sizeW * numW;
		// 统计词频
	 	final Map<String, Integer> map = new HashMap<>();
		for (String word : words) 
			map.put(word, map.getOrDefault(word, 0) + 1);
			
		// 挨个检查
		for (int i = 0; i <= lenS - sizeChs; i++) {
			final Map<String,Integer> seen = new HashMap<>();
			int j = 0;
			while(j<numW){
				String w = s.substring(i + j * sizeW, i + (j + 1) * sizeW);
				if (map.containsKey(w)) {
					seen.put(w, seen.getOrDefault(w, 0) + 1);
					if (seen.get(w) > map.getOrDefault(w, 0))
						break;
				} else {
					break;
				}
				j++;
			}
			if (j == numW)
				ret.add(i);
		}
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
				new S_030_SubstringConcatenation().findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }));
		System.out.println(
				new S_030_SubstringConcatenation().findSubstring("", new String[] {}));
	}

}
