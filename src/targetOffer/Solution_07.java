package targetOffer;

public class Solution_07 {
	public int Fibonacci(int n) {
		if (n<2)
			return n;
		int minusOne = 1;
		int minusTwo = 0;
		int fn = 1;
		for (int i = 2; i <= n; i++){
			fn = minusOne + minusTwo;
			minusTwo = minusOne;
            minusOne = fn;
		}
		return fn;
	}


}
