package leetcode;

import java.util.Stack;

public class S_394_DecodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int i = 0, end = s.length();
        while(i < end){
            if(s.charAt(i) == '['){
                i++;
            } else if(s.charAt(i) == ']'){
                String base = stack.pop();
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && stack.peek().charAt(0) >= 'A'){
                    base = stack.pop() + base;
                }
                int num = Integer.parseInt(stack.pop());
                for(int j = 0; j < num; j++)
                    sb.append(base);
                base = sb.toString();
                while(!stack.isEmpty() && stack.peek().charAt(0) >= 'A'){
                    base = stack.pop() + base;
                }
                stack.push(base); 
                i++;
            } else{
                int j = i+1;
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9' ){
                    while(j < end && s.charAt(j) >= '0' && s.charAt(j) <= '9')
                        j++;
                }else{
                    while(j < end && s.charAt(j) >= 'A' && s.charAt(j) != ']')
                        j++;
                }
                stack.push(s.substring(i,j));
                i = j;
            }
        }
        String ret = new String();
        while(!stack.isEmpty())
        	ret = stack.pop()+ret;
        return ret;
    }
    public static void main(String[] args) {
		System.out.println(new S_394_DecodeString().decodeString("2[abc]3[cd]ef"));
		System.out.println(new S_394_DecodeString().decodeString("3[a2[c]]"));
		System.out.println(new S_394_DecodeString().decodeString("3[a]2[b4[F]c]"));
	}
}
