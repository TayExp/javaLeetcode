package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class S_071_SimplifyPath {
	public String simplifyPath(String path) {
        HashSet<String> skip = new HashSet<>(Arrays.asList("/","","..","."));
        Stack<String> stack = new Stack<>();
        for(String str : path.split("/")){
        	if(str.equals("..") && !stack.isEmpty())
        		stack.pop();
        	else if(!skip.contains(str))
        		stack.push(str);
        }
        String res = "";
        for(String str : stack)
        	res += "/" + str;
        return res.length() == 0?"/" :res;
    }
}
