package leetcode;

public class S_044_WildcardMatching3 {
	public boolean isMatch(String s, String p) {
        if(s.length()==0 && p.length()==0)
        	return true;
        if(p.length()>0){
        	if(p.charAt(0)=='?'&& s.length()>0 || s.length()>0 && p.charAt(0)==s.charAt(0))
        		return isMatch(s.substring(1), p.substring(1));
	        else if(p.charAt(0)=='*'){
	        	while(p.length() > 0 && p.charAt(0)=='*')
	        		p = p.substring(1);
	        	if(p.length() <= 1)
					return true;
	        	String ch = p.substring(1, 2);
	        	int i = 2;
	        	while(ch.equals("*")){
	        		if(p.length()<i+1)
	        			return true;
	        		ch = p.substring(i,i+1);
	        		i++;
	        	}
	        	int index = s.indexOf(ch); 
	        	while(index != -1){
	        		if(isMatch(s.substring(index), p.substring(1)))
	        			return true;
	        		index = s.indexOf(ch, index+1); 	
	        	}
	        }
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new S_044_WildcardMatching3().isMatch("acdcb", "a*c?b"));
		System.out.println(new S_044_WildcardMatching3().isMatch("", "?"));
		System.out.println(new S_044_WildcardMatching3().isMatch("aaaa", "***a"));
		System.out.println(new S_044_WildcardMatching3().isMatch("aaaa", "****"));
		//实在算不出来啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
		System.out.println(new S_044_WildcardMatching3().isMatch("mississippi","m??*ss*?i*pi"));
		
	}

}
