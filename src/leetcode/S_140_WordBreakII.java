package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S_140_WordBreakII {
	public List<String> wordBreak1(String s, List<String> wordDict) {
		List<String> ret = new ArrayList<>();
		backtrack(ret, wordDict, s, 0, new ArrayList<String>());
		return ret;
    }

	private void backtrack(List<String> ret, List<String> wordDict, String s, int start, ArrayList<String> l) {
		if(start >= s.length()){
			ret.add(String.join(" ", l));
			return;
		}

		for(String word : wordDict){
			if(s.substring(start).startsWith(word)){
				l.add(word);
				backtrack(ret, wordDict, s, start+word.length(), l);
				l.remove(l.size()-1);
			}
		}	
	}
	
	
	public List<String> wordBreak(String s, List<String> wordDict) {
		return dfs(s,wordDict, new HashMap<String, ArrayList<String>>());
    }

	private List<String> dfs(String s, List<String> wordDict, HashMap<String, ArrayList<String>> map) {
		if(map.containsKey(s)){
			return map.get(s);
		}
		ArrayList<String> ret = new ArrayList<>();
		if(s.length() == 0){
			ret.add("");
			return ret;
		}

		for(String word : wordDict){
			if(s.startsWith(word)){
				List<String> sublist = dfs(s.substring(word.length()), wordDict, map);
				for(String sub : sublist){
					ret.add(word + (sub.isEmpty()?"":" ") + sub);
				}
			}
		}
		map.put(s,ret);
		return ret;
	}
	
	
	public static void main(String[] args) {
		List<String> l  = new ArrayList<>();
		l.add("cat");
		l.add("cats");
		l.add("and");
		l.add("sand");
		l.add("dog");

		
		System.out.println(new S_140_WordBreakII().wordBreak("catsanddog", l));
	}
}
