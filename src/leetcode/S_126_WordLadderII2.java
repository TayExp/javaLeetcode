package leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javafx.util.Pair;
public class S_126_WordLadderII2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    	int L = beginWord.length();
    	for(int i = 0; i< wordList.size();i++){
			if(match(beginWord, wordList.get(i),L) == L && match(endWord, wordList.get(i),L) == L  )
				wordList.remove(i);
		}
    	int size = wordList.size();
		// bfs,queue
		List<List<String>> ret = new ArrayList<>();
		List<String> currlist = new ArrayList<>();
		currlist.add(beginWord);
		Queue<Pair<String, List<String>>> Q = new LinkedList<>();
	    Q.add(new Pair(beginWord,new ArrayList<>(currlist)));
	    int count = size;
		while(!Q.isEmpty()){
			currlist = Q.peek().getValue();
			if(currlist.size() >= count)
				break;
			String curr_word = Q.poll().getKey();//先进先出
			//找下一层的所有可能词汇，未访问过的
			for(int i = 0; i < size; i++){
				if(!currlist.contains(wordList.get(i)) && match(curr_word, wordList.get(i), L)==1){
					List<String> tmp = new ArrayList<>(currlist);
					tmp.add(wordList.get(i));
					if(wordList.get(i).equals(endWord)){
						// 得到最低层数， 后续处理
						if(ret.isEmpty())
							count = tmp.size();
						ret.add(new ArrayList<>(tmp));
						if(L == 1)
							return ret;
						break;
					}
					Q.offer(new Pair(wordList.get(i), tmp));//还没找到结果则加入下一层当中Q.offer	
				}
			}
		}
		return ret;
	}
	
	private int match(String s1, String s2, int l){
		int cn = 0;
		for(int i = 0; i < l; i++){
			if(s1.charAt(i)!=s2.charAt(i))
				cn++;
		}
		return cn;
	}
	
	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList<>();
		l.add("lot");
		l.add("dot");
		l.add("dog");
		l.add("hot");
		l.add("log");
		l.add("cog");
		
		System.out.println(new S_126_WordLadderII2().findLadders("hit","cog",l));
		ArrayList<String> l1 = new ArrayList<>();
		l1.add("ted");
		l1.add("tex");
		l1.add("red");
		l1.add("tax");
		l1.add("tad");
		l1.add("den");
		l1.add("rex");
		l1.add("pee");

		
		System.out.println(new S_126_WordLadderII2().findLadders("red",
				"tax",l1));
	}
}
