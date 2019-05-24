package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S_282_ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<>();
        if(num.length() == 0) return ret;
        helper(ret, "", num, target, 0, 0, 0);
        return ret;
    }
    
    private void helper(List<String> ret, String path, String num, int target, int pos, long eval, long mult){
        if(pos == num.length() && eval == target)
            ret.add(path);    
        for(int i = pos; i < num.length(); i++){
            if(pos != i && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos,i+1));
            if(pos == 0){
                helper(ret, path+cur, num, target, i+1, cur, cur);
            } else{
                helper(ret, path+"+"+cur, num, target, i+1, eval+cur, cur);
                helper(ret, path+"-"+cur, num, target, i+1, eval-cur, -cur);
                helper(ret, path+"*"+cur, num, target, i+1, eval-mult+mult*cur, mult*cur);
            }
        }
    }
    public static void main(String[] args) {
		System.out.println(new S_282_ExpressionAddOperators().addOperators("3456237490", 9191));
	}
}
