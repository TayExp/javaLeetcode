package leetcode;

public class S_209_Tries {
	class Trie {
		class TrieNode{
			public final int R = 26;
			public TrieNode[] links = new TrieNode[R];
			public boolean isEnd;
		}
	    /** Initialize your data structure here. */
		private TrieNode root;
		public Trie() {
	        root = new TrieNode();
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        TrieNode p = root;
	    	for(int i = 0; i < word.length();i++){
	    		char c = word.charAt(i);
	        	if(p.links[c-'a'] == null)
	        		p.links[c-'a'] = new TrieNode();
	        	p = p.links[c-'a'];
	        }
	    	p.isEnd = true;
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	    	TrieNode node = searchPrefix(word);
	        return node!=null && node.isEnd; 
	    }
	    public TrieNode searchPrefix(String prefix) {
	        TrieNode p = root;
	        for(int i = 0; i < prefix.length(); i++){
	        	char c = prefix.charAt(i);
	        	if(p.links[c-'a'] == null) return null;
	        	p = p.links[c-'a'];
	        }
	        return p;
	    }
	    /** Returns if there is any word in the trie that starts with the given prefix. */

	    public boolean startsWith(String prefix) {
	        return searchPrefix(prefix) != null;
	    }
	}

}
