package leetcode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javafx.util.Pair;

public class S_127_WordLadder {
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int L = beginWord.length(), size = wordList.size();
		// bfs,queue
		Queue<Pair<String, Integer>> Q = new LinkedList<>();
	    Q.add(new Pair(beginWord,1));
	    int count = 0;
	    Set<String> visited = new HashSet<>();
	    visited.add(beginWord);
		while(!Q.isEmpty() && count < size){
			int level = Q.peek().getValue();
			String curr_word = Q.poll().getKey();//先进先出
			//找下一层的所有可能词汇，未访问过的
			for(int i = 0; i < size; i++){
				if(!visited.contains(wordList.get(i)) && match(curr_word, wordList.get(i), L)){
					if(wordList.get(i).equals(endWord))
						return level+1; //如果与结果词相同，返回level+1
					Q.offer(new Pair(wordList.get(i),level+1));//还没找到结果则加入下一层当中Q.offer
					visited.add(wordList.get(i));
					count++;
				}
			}
		}
		return 0;
	}
	
	private boolean match(String s1, String s2, int l){
		int cn = 0;
		for(int i = 0; i < l; i++){
			if(s1.charAt(i)!=s2.charAt(i))
				cn++;
			if(cn>1)
				return false;
		}
		return cn == 1;
	}
	
	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList<>();
		l.add("lot");
		l.add("dot");
		l.add("dog");
		l.add("hot");
		l.add("log");
		l.add("cog");
		
		System.out.println(new S_127_WordLadder().ladderLength("hit","cog",l));
	}
}
