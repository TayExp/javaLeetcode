package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class S_187_RepeatedDNASequences_amazing {
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        HashSet<Integer> word = new HashSet<>();
        HashSet<Integer> doubleword = new HashSet<>();
        map.put('A',0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        for(int i = 0 ; i < s.length()-9; i++){
        	int v = 0;
        	for(int j = i; j < i+10; j++){
        		v <<= 2;
        		v |= map.get(s.charAt(j));
        	}
        	if(!word.add(v) && doubleword.add(v))
        		ret.add(s.substring(i, i+10));
        }
        return ret;
    }
}
