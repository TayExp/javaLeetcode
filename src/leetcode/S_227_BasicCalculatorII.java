package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class S_227_BasicCalculatorII {
	
	private LinkedList<String> inffix2suffix(String exp) {
		LinkedList<String> list = new LinkedList<>();
		int i = 0;
		// 分离字符
		while(i < exp.length()) {
			char e = exp.charAt(i);
			if(e >= '0' && e <= '9') {
				int j=i;
				while (e >= '0' && e <= '9'&& ++j < exp.length()) {
					e = exp.charAt(j);
				}
				String s = exp.substring(i, j);
				list.add(s);
				i = j;
			}else {
				if(e != ' ') list.add(String.valueOf(e));
				i++;
			}
				
		}
		System.out.println(list);
		// 变成后缀表达式
		LinkedList<String> ret = new LinkedList<>();
		Map<String, Integer> map = new HashMap<>();
		Stack<String> stack = new Stack<>();
		map.put("(", 0);
		map.put("+", 1);
		map.put("-", 1);
		map.put("*", 2);
		map.put("/", 2);
		for(String s:list) {
			if(s.charAt(0)>='0' && s.charAt(0)<='9')
				ret.add(s);
			else if(s.equals("(") || stack.isEmpty())
				stack.push(s);
			else if(map.containsKey(s)) {
				while(!stack.isEmpty() && map.get(stack.peek())>=map.get(s))
					ret.add(stack.pop());
				stack.push(s);
			}
			else {
				while(!stack.peek().equals("("))
					ret.add(stack.pop());
				stack.pop();
			}
		}
		while(!stack.isEmpty())
			ret.add(stack.pop());
		return ret;
	}
	// 后缀表达式求值
    public int calculate(String s) {
    	LinkedList<String> exp = inffix2suffix(s);
    	System.out.println(exp);
    	Stack<Integer> stack = new Stack<>();
    	for(String e : exp) {
    		if(e.equals("+")) {
    			stack.push(stack.pop()+stack.pop());
    		}
    		else if(e.equals("-")) {
    			stack.push(-stack.pop()+stack.pop());
    		}
    		else if(e.equals("*")) {
    			stack.push(stack.pop()*stack.pop());
    		}
    		else if(e.equals("/")) {
    			int d = stack.pop();
    			stack.push(stack.pop()/d);
    		}
    		else
    			stack.push(Integer.parseInt(e));
    	}
    	return stack.pop();
        
    }
	public static void main(String[] args) {
		System.out.println(new S_227_BasicCalculatorII().calculate("(1+(4+5+2)-3)+(6+8)" + 
				""));

	}

}
