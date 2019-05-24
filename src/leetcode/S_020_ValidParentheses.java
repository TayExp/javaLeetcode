package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class S_020_ValidParentheses {
	private HashMap<Character, Character> mappings;

	public S_020_ValidParentheses() {
		this.mappings = new HashMap<>();
		mappings.put(')', '(');
		mappings.put(']', '[');
		mappings.put('}', '{');
	}
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (mappings.containsKey(s.charAt(i)))
				if (!stack.isEmpty() && stack.peek() == mappings.get(s.charAt(i)))
					stack.pop();
				else
					return false;
			else
				stack.push(s.charAt(i));
		}
		if (stack.isEmpty())
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new S_020_ValidParentheses().isValid("]"));
	}

}
