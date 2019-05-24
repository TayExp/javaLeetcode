package leetcode;

public class S_038_CountSay {
	public String countAndSay(int n) {
		if(n == 1)
			return "1";
		String s = countAndSay(n-1);
		StringBuilder ret = new StringBuilder();
		int i=1, count = 1;
        for(i = 1;i<s.length();i++)
        	if(s.charAt(i)!=s.charAt(i-1)){
        		ret.append(Integer.toString(count)).append(s.charAt(i-1));
        		count = 1;
        	}
        	else
        		count ++;
        ret.append(Integer.toString(count)).append(s.charAt(i-1));
        return ret.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new S_038_CountSay().countAndSay(5));
	}

}
