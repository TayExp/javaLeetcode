package targetOffer;

import java.util.Stack;

/* 
 * 能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Solution_20_220 {

	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();
	public void push(int node) {
		stack1.push(node);
		if (stack2.empty())
			stack2.add(node);
		else
			stack2.add(Math.min(node, stack2.peek()));
	}

	public void pop() {
		stack1.pop();
		stack2.pop();

	}

	public int top() {
		return stack1.peek();

	}

	public int min() {
		return stack2.peek();
	}

	public static void main(String[] args) {
		Solution_20_220 s = new Solution_20_220();
		s.push(1);
		s.push(2);
		System.out.println(s.min());
		s.push(0);
		System.out.println(s.min());
	}
}

