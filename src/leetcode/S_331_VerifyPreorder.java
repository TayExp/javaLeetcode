package leetcode;

import java.util.Stack;

public class S_331_VerifyPreorder {
    public boolean isValidSerialization(String preorder) {
        if(preorder.length() == 1) return preorder.charAt(0) == '#';
        Stack<Character> stack = new Stack<>();
        int i = 0, l = preorder.length();
        while(i < l){
            char c = preorder.charAt(i);
            if( c != '#')
                while(i+1 < l && preorder.charAt(1+i) != ',') i++;
            i += 2;
            if(c == '#' && !stack.isEmpty() && stack.peek() == '#'){
                while(!stack.isEmpty() && stack.peek() == '#'){
                    stack.pop();
                    if(stack.isEmpty()) return false;
                    stack.pop();
                }
            }
            stack.push(c);
        }
        return stack.size() == 1;
    }
    public static void main(String[] args) {
		System.out.println(new S_331_VerifyPreorder().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
	}
}
