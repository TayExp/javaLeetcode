package leetcode;

import java.util.HashMap;

/*
 * Given a string S and a string T,
 * find the minimum window in S
 *  which will contain all the characters in T 
 *  in complexity O(n).
 */
public class S_076_MinumumWindowSubstring {
	 public String minWindow(String s, String t) {
		 if(s.length() == 0 || t.length() == 0||s.length()<t.length())
			 return "";
		 HashMap<Character, Integer> map = new HashMap<>();
		 for(char c : t.toCharArray())
			 map.put(c, map.getOrDefault(c, 0)+1); 
		 int left = 0, right = 0, minLeft = 0, minRight = s.length()+1;
		 int count = 0;
		 while(right <  s.length()){
			 if(map.containsKey(s.charAt(right))){
				 map.put(s.charAt(right),  map.get(s.charAt(right))-1);
				 if( map.get(s.charAt(right)) >= 0) //>=0才是真的需要这个字母，否则已经需要过了
					 count++; 
				 while(count == t.length()){
					 if(minRight - minLeft> right - left){
						 minLeft = left;
						 minRight = right;
					 }
					 if(map.containsKey(s.charAt(left))){
						 map.put(s.charAt(left), map.get(s.charAt(left))+1);
						 if(map.get(s.charAt(left)) > 0) //至少需要一个，才是真的减了一个count
							 count--;
					 }
					 left ++;
				 }
			 }
			 right++;	 
		 }
		 return minRight>s.length()? "" : s.substring(minLeft, minRight+1);
	 }
	 public static void main(String[] args){
		 System.out.println(new S_076_MinumumWindowSubstring().minWindow("ADOBECODEBANC","ABC"));
	 }
}
