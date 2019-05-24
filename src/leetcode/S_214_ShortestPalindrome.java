package leetcode;

public class S_214_ShortestPalindrome {
    public String shortestPalindrome1(String s) {
		int oriLength = s.length();
		char[] sc = s.toCharArray();
		if (oriLength == 0)  return "";
		int maxLength = 1;
		int i = 1, j = 1;
		for (; i <= (oriLength-1)/2; i++) {
			for (j = 1; i - j >= 0 && i + j < oriLength; j++) {
				if (sc[i - j] != sc[i + j])  break;
			}
			if(i-j < 0)
				maxLength = 2*i+1;
		}
		for (i=(maxLength-1)/2; i <= oriLength/2 - 1; i++) {
			for (j = 1; i - j + 1 >= 0 && i + j < oriLength; j++) {
				if (sc[i - j + 1] != sc[i + j]) break;
			}
			if(i-j+1 < 0)
				maxLength = 2*j-2;
		}
        StringBuilder pre = new StringBuilder();
        for(i = s.length()-1; i >= maxLength; i--)
        	pre.append(sc[i]);
        return pre.toString()+s;
    }
    
    public String shortestPalindrome(String s) {
		int maxLen = 1;
    	for(int j = 1; j < s.length(); j++) {
    		if(isPalindrome(s, 0, j))
    			maxLen = j+1;
    	}
        StringBuilder pre = new StringBuilder();
        for(int j = s.length()-1; j >= maxLen; j--)
        	pre.append(s.charAt(j));
        return pre.toString()+s;
			
    }
    
    private boolean isPalindrome (String s, int i, int j) {
    	while(i < j) {
    		if(s.charAt(i++) != s.charAt(j--))
    			return false;
    	}
    	return true;
    }
    
    
    public static void main(String[] args) {
		System.out.println(new S_214_ShortestPalindrome().shortestPalindrome("abccbaa"));
	}
    
}
