package targetOffer;

import java.util.Stack;

/*
 * 栈push的压入、弹出pop序列（假设压入栈的数字均不相等
 * 借用一个栈，仅当该栈为空且push中元素检查完才返回真
 * pPop=pPush=0，指向检查到的位置
 * 如果辅助栈为空或者栈顶元素与当下pop[pPop]不同，则 往辅助栈内加push[pPush]
 * 相同 则弹出辅助栈中元素，同时pPop+1
 */
public class Solution_21_221 {
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA.length != popA.length || pushA.length == 0)
			return false;
		// boolean bPossible = false;
		int pEnd = pushA.length;
		Stack<Integer> stackData = new Stack<>();
		int pPop = 0, pPush = 0;
		while (pPop < pEnd) {
			while (stackData.isEmpty() || stackData.peek() != popA[pPop]) {
				if (pPush == pEnd)
					break;
				stackData.push(pushA[pPush++]);
			}
			if (!stackData.isEmpty() && stackData.peek() == popA[pPop]){
				stackData.pop();
				pPop++;
			}
		}
		if (stackData.isEmpty() && pPush == pEnd)
			return true;
		else
			return false;

}
}
