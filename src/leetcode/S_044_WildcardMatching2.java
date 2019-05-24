package leetcode;

public class S_044_WildcardMatching2 {
	public boolean isMatch(String s, String p) {
        if(s.length()==0 && p.length()==0)
        	return true;
        if(p.length()>=2 && p.charAt(1) == '*'){
        	if(p.charAt(0) != '?' && p.charAt(0) != s.charAt(0))
        		return isMatch(s, p.substring(2));
        	for (int  i = 0; s.charAt(i+1) == s.charAt(i);i++)
        		if(s.length()>=i+1)
        			return isMatch(s.substring(i+1), p.substring(2));
        }else if(p.length()>=1 && s.length() >= 1){
        	if(p.charAt(0)!='?' && p.charAt(0) != s.charAt(0))
        		return false;
        	else
        		return isMatch(s.substring(1), p.substring(1));
        }
        return false;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new S_044_WildcardMatching2().isMatch("adceb", "*a*b"));
		
	}

}
