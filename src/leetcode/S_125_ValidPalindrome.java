package leetcode;

public class S_125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] array = toarray(s.trim());
        for(int i = 0, j = array.length-1; i<j ;i++,j--)
            if(array[i]!=array[j])
                return false;
        return true;
    }
    
    private char[] toarray(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                sb.append(s.charAt(i));
            else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                sb.append((char)(s.charAt(i)-'A'+'a'));
            else if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                sb.append(s.charAt(i));
        return sb.toString().toCharArray();
    }
    
    public static void main(String[] args) {
		//System.out.println(new S_125_ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(new S_125_ValidPalindrome().isPalindrome("0P"));
	}
}
