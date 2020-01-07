package leetcode;

import java.util.List;
import java.util.Stack;

public class S_385_MiniParser {

	// This is the interface that allows for creating nested lists.
	// You should not implement it, or speculate about its implementation
	class NestedInteger {
	    // Constructor initializes an empty nested list.
	    public NestedInteger() {
		}

	    // Constructor initializes a single integer.
	    public NestedInteger(int value) {
		}

	    // @return true if this NestedInteger holds a single integer, rather than a nested list.
	    public boolean isInteger() {
			return false;
		}

	    // @return the single integer that this NestedInteger holds, if it holds a single integer
	    // Return null if this NestedInteger holds a nested list
	    public Integer getInteger() {
			return null;
		}

	    // Set this NestedInteger to hold a single integer.
	    public void setInteger(int value) {
		}

	    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
	    public void add(NestedInteger ni) {
		}

	    // @return the nested list that this NestedInteger holds, if it holds a nested list
	    // Return null if this NestedInteger holds a single integer
	    public List<NestedInteger> getList() {
			return null;
		}
	}

	public NestedInteger deserialize(String s) {
        if(s == null || s.length() == 0)  
        	return new NestedInteger();
        if(s.charAt(0) != '[')
        	return new NestedInteger(Integer.valueOf(s));
        NestedInteger curr = new NestedInteger();
        Stack<NestedInteger> stack = new Stack<>();
        stack.push(curr);
        int l = 1;
        for(int r = 0; r < s.length(); r++) {
        	char c = s.charAt(r);
        	if(c == '[') {
        		NestedInteger ni = new NestedInteger();
        		stack.peek().add(ni);
        		stack.push(ni);
        		l = r + 1;
        	} else if(c == ']' || c == ',') {
        		if(r > l) {
        			stack.peek().add(new NestedInteger(Integer.valueOf(s.substring(l, r))));
        		}
        		l = r + 1;
        		if(c == ']') {
        			stack.pop();
        		}
        	} 
        }
        return curr;
    }
}
