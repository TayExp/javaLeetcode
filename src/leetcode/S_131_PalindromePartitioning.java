package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S_131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
    	List<List<String>> ret = new ArrayList<>();
    	recursion(ret, new ArrayList<String>(), s, 0 );
    	return ret;
    }

	private void recursion(List<List<String>> ret, ArrayList<String> l, String s, int start) {
		if(!l.isEmpty() && start >= s.length()) {
			ret.add(new ArrayList<>(l));
			return;
		}
		for(int i = start; i < s.length(); i++){
			if(isPalindrome(s, start, i)){
				l.add(s.substring(start, i+1));
			    recursion(ret, l, s, i+1);
			    l.remove(l.size()-1);
            }	
		}
	}

	private boolean isPalindrome(String s, int start, int end) {
		for(int i = start,j = end; i < j; i++,j--)
			if(s.charAt(i)!=s.charAt(j))
				return false;
		return true;
	}
}
