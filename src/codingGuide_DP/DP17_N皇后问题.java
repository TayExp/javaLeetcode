package codingGuide_DP;

public class DP17_N皇后问题 {
	public int num1(int n) {
		if(n <1) return 0;
		int[] record = new int[n];
		return process1(0, record, n);
	}

	private int process1(int row, int[] record, int n) {
		if(row == n) return 1;
		int res = 0;
		for(int col = 0; col < n; col++) {
			if(isValid(record, row, col)) {
				record[row] = col;
				res += process1(row+1,record,n);
			}
		}
		return res;
	}

	private boolean isValid(int[] record, int row, int col) {
		for(int k = 0; k < row; k ++)
			if(record[k] == col || Math.abs(record[k]- col) == Math.abs(k - row))
				return false;
		return true;
	}
	
	// 使用位运算来加速
	public int num2(int n) {
		if(n < 1 || n > 32)  return 0;
		int upperLim = n == 32? -1 : (1<<n)-1;
		return process2(upperLim, 0, 0, 0);
	}

	// upperLim : 当前行哪些位置还没放可以放（1，始终不变，11111111
	// colLim : 到上一行，哪些列已经放了不能再放（1
	// leftDigLim : 左下线的影响，当前行不能放（1
	// rightDigLim : 右下线的影响，当前行不能放（1
	// mostRightOne : 最右边的1，从右到左递归
	private int process2(int upperLim, int colLim, int leftDiaLim, int rightDiaLim) {
		if(upperLim == colLim) return 1;
		int res = 0, mostRightOne = 0;
		int pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
		while(pos != 0) {
			mostRightOne = pos & (~pos+1); // -pos == ~pos+1
			pos = pos - mostRightOne;
			res += process2(upperLim, colLim|mostRightOne, 
					(leftDiaLim|mostRightOne) << 1, (rightDiaLim|mostRightOne)>>>1);
		}
		return res;
	}
}
