package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S_049_GroupAnagrams {
	
	public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
        	int[] count = new int[26];
        	for(char ch : s.toCharArray())
        		count[ch-'a'] ++;
        	StringBuilder sb = new StringBuilder();
        	for(int i = 0; i < 26; i++)
        		sb.append("#").append(count[i]);
        	String key = sb.toString();
        	if(!map.containsKey(key))
        		map.put(key, new ArrayList<String>());
        	map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
