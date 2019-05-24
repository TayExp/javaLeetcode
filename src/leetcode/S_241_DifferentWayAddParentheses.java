package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S_241_DifferentWayAddParentheses {
    HashMap<String, ArrayList<Integer>> map = new HashMap<>(); 
	public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
        	char c = input.charAt(i);
        	if(c == '+' || c == '-' || c == '*') {
        		String s1 = input.substring(0, i), s2 = input.substring(i+1);
        		List<Integer> l,r;
	        	l = map.containsKey(s1)?map.get(s1):diffWaysToCompute(s1);
	        	r = map.containsKey(s2)?map.get(s2):diffWaysToCompute(s2);
	        	for(int j : l)
	        		for(int k : r) 
	        			switch(c) {
				        	case '+': ret.add(j+k); break;
				        	case '-': ret.add(j-k); break;
				        	case '*': ret.add(j*k); break;
	        			}
        	}
        }
        if(ret.size() == 0) ret.add(Integer.valueOf(input));
        return ret;
    }
}
