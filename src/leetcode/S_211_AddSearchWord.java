package leetcode;

public class S_211_AddSearchWord {

	class WordDictionary {
		class TriesNode{		
			public boolean isEnd;
			public TriesNode[] links = new TriesNode[R];
		}
		public final static int R =26;
		private TriesNode root;
	    /** Initialize your data structure here. */
	    public WordDictionary() {
	        root = new TriesNode();
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        TriesNode p = root;
	        for(char c : word.toCharArray()) {
	        	if(p.links[c-'a'] == null)
	        		p.links[c-'a'] = new TriesNode();
	        	p = p.links[c-'a'];
	        }
	        p.isEnd = true;
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	        return searchcore(word, 0, root);
	    }
	    public boolean searchcore(String word,int start,TriesNode p) {
	    	if(p == null) return false; // 再琢磨琢磨
	        for(int i = start; i < word.length();i++) {
	        	char c = word.charAt(i);
	        	if(c=='.') {
	        		for(int j = 0; j < R; j++ )
	        			if(searchcore(word, i+1, p.links[j])) return true;
	        		return false;
	        	}else {
	        		if(p.links[c-'a'] == null) 
	        			return false;
	        		p = p.links[c-'a'];
	        	}
	        }
	        return p.isEnd;
	    }
	    /**
	     * Your WordDictionary object will be instantiated and called as such:
	     * WordDictionary obj = new WordDictionary();
	     * obj.addWord(word);
	     * boolean param_2 = obj.search(word);
	     */
	}
	

}
