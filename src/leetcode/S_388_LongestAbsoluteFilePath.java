package leetcode;

import java.util.Stack;

public class S_388_LongestAbsoluteFilePath {
    public int lengthLongestPath(String s) {
        Stack<Integer> stack = new Stack<>();
        int left = 0, right = 1, end = s.length();
        stack.push(-1);
        int ret = 0;
        while(left < end){
        	while(right < end && s.charAt(right) != '\n') 
        		right++;
        	stack.push(stack.peek() + 1 + right - left);
        	if(right >= 4 && s.charAt(right - 4) == '.' && stack.peek() > ret)
                ret = stack.pop();
            int level = 1;
            while(++right < end && (s.charAt(right) == '\t'))
                level++;
        	while(stack.size() > level){
        		stack.pop();
        	}
            left = right;
        }
        return ret;
    }
	public static void main(String[] args) {
		System.out.println(new S_388_LongestAbsoluteFilePath().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
		System.out.println(new S_388_LongestAbsoluteFilePath().lengthLongestPath("a\naa.ext"));
	}

}
