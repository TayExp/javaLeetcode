package leetcode;

public class S_316_RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if(s.length() == 0) return s;
        int[] count = new int[26];
        for(char c: s.toCharArray())
        	count[c-'a']++;
        int pos = 0, i = 0;
        for(; i < s.length(); i++){
            if(s.charAt(i) < s.charAt(pos))
                pos = i;
            if(--count[s.charAt(i)-'a'] == 0)
                break;
        }
        String subs =  s.substring(i+1).replaceAll(s.charAt(pos)+"", "");
        return s.charAt(pos) + removeDuplicateLetters(subs);
    }
    public static void main(String[] args) {
		System.out.println(new S_316_RemoveDuplicateLetters().removeDuplicateLetters("cbacdcbc"));
	}
    
}
