package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S_279_PerfectSquares {
	public int numSquares1(int n) {
		if(n <= 0) return 0;
		int[] count = new int[n+1];
		Arrays.fill(count, Integer.MAX_VALUE);
		count[0] = 0;
		for(int i = 1; i <= n; i++)
			for(int j = 1; j*j <= i; j++) {
				count[i] = Math.min(count[i], count[i-j*j]+1);
			}
		return count[n];
	}
	
	// 数学方法:1,2,3,4
	// 4<-   4^k*(8*m + 7)
	public int numSquares2(int n) {
		if(isSquare(n)) return 1;
		while((n&3) == 0) //n%4 == 0，末位是00
			n >>= 2;
		if((n&7) == 7)
			return 4;
		//check 2
		for(int i = 1; i * i <= n; i++)
			if(isSquare(n-i*i))
				return 2;
		return 3;
		
	}
	private boolean isSquare(int n) {
		int k = (int)(Math.sqrt(n));
		return n == k*k;
	}
	
	// 宽度优先 bfs
	public int numSquares3(int n) {
		List<Integer> perfectSquares = new ArrayList<>();
		int[] count = new int[n];
		for(int i = 1; i * i <= n; i++) {
			perfectSquares.add(i*i);
			count[i*i-1] = 1;
		}
		if(count[n-1] == 1) return 1;
		Queue<Integer> q = new LinkedList<>();
		for(int num : perfectSquares)
			q.add(num);
		int curCnt = 1;
		while(!q.isEmpty()) {
			curCnt++;
			int curSz = q.size();
			for(int i = 0; i < curSz; i++) {
				int tmp = q.peek();
				for(int num : perfectSquares) {
					if(tmp + num == n) {
						return curCnt;
					} else if(tmp + num < n && count[tmp + num - 1] == 0) {
						count[tmp+num-1] = curCnt;
						q.add(tmp+num);
					} else if(tmp +num > n)
						break;
				}
				q.poll();
			}
		}
		return 0;
	}
	
    public static void main(String[] args) {
		System.out.println(new S_279_PerfectSquares().numSquares2(12));
	}
}
