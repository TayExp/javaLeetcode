package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S_212_WordSearchII {
	public final static int R =26;
	class TriesNode{		
		public String word;
		public TriesNode[] links = new TriesNode[R];
	}
	public TriesNode buildtries(String[] words) {
		TriesNode root = new TriesNode();
		for(String word : words) {
            TriesNode p = root;
			for(char c : word.toCharArray()) {
	        	if(p.links[c-'a'] == null)
	        		p.links[c-'a'] = new TriesNode();
	        	p = p.links[c-'a'];
	        }
	        p.word = word;
		}
        return root;
    }
	
	public List<String> findWords(char[][] board, String[] words) {
        List<String> ret = new ArrayList<>();
        TriesNode root = buildtries(words);      
        for(int i = 0; i < board.length; i++) 
        	for(int j = 0; j < board[0].length; j++) 
        		dfs(ret, board, root, i, j);
        return ret;
    }

	private void dfs(List<String> ret, char[][] board, TriesNode p, int i, int j) {
		char c = board[i][j];
		if(c == '#' || p.links[c-'a'] == null) return;
		p = p.links[c-'a'];
		if(p.word !=  null) {ret.add(p.word);p.word = null;}
		board[i][j] = '#'; 
		if(i > 0) dfs(ret, board, p, i-1, j);
		if(j > 0) dfs(ret,board, p, i, j-1);
		if(i < board.length-1) dfs(ret, board, p, i+1 ,j);
		if(j < board[0].length-1) dfs(ret, board, p, i, j+1);
		board[i][j] = c;
	}
}
