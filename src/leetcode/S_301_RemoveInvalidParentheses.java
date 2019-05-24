package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S_301_RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new ArrayList<>();
        remove(ret, s, 0, 0, new char[]{'(', ')'});
        return ret;
    }
    
    private void remove(List<String> ret, String s, int last_i, int last_j, char[] par){
        for(int stack = 0, i = last_i; i < s.length(); i++){
            if(s.charAt(i) == par[0]) stack++;
            if(s.charAt(i) == par[1]) stack--;
            if(stack >= 0) continue;
            for(int j = last_j; j <= i; j++){
                if(s.charAt(j) == par[1] && (j==last_j || s.charAt(j-1)!=par[1]))
                    remove(ret, s.substring(0,j)+s.substring(j+1), i, j, par);
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(par[0] == '(')
            remove(ret, reversed, 0, 0, new char[]{')','('});
        else
        	ret.add(reversed);
    }
    public static void main(String[] args) {
		System.out.println(new S_301_RemoveInvalidParentheses().removeInvalidParentheses("()())()"));
	}
}
