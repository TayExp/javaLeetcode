package codingGuide_DP;
/*
 * 打印汉诺塔的最优移动轨迹
 */
public class DP06_汉诺塔 {

	
	public void hanoi(int n) {
		if(n > 0) {
			func(n, "left", "mid", "right");
		}
	}
	
	// 递归
	private void func(int n, String from, String mid, String to) {
		if( n == 1 )
			System.out.println("move from "+from+" to "+to);
		else {
			func(n-1, from, to, mid);
			func(1, from, mid, to);
			func(n-1, mid, from, to);
		}
		
	}
	/*
	 * 进阶题目：arr[i] 代表第i+1个圆盘的位置
	 * 1：左 2： 中 3：右
	 * 如果是最优移动轨迹来的状态，返回状态数；否则返回-1
	 */
	// 递归
	// n在左，考察n-1即可；n在右，起码完成了2^(n-1)-1  +  1步
	// n在中，不可能
	public int step1(int[] arr) {
		if(arr == null || arr.length == 0) return -1;
		return process(arr, arr.length-1,1,2,3);
	}
	
	private int process(int[] arr, int i, int from, int mid, int to) {
		if(i == -1) return 0;
		if(arr[i] != from && arr[i] != to) return -1;
		if(arr[i] == from) {
			return process(arr,i-1, from, to, mid);
		} else {
			int rest = process(arr, i - 1, mid, from ,to);
			if(rest == -1)
				return -1;
			return rest + 1 << i;
		}
	}
	
	// 非递归
	public int step2(int[] arr) {
		if(arr == null || arr.length == 0) return -1;
		int from = 1, mid = 2, to = 3, i = arr.length-1, res = 0, tmp =0;
		while(i>=0) {
			if(arr[i] != from && arr[i] != to)
				return -1;
			if(arr[i] == to) {
				res += 1 << i;
				tmp = from;
				from = mid;
			} else {
				tmp = to;
				to = mid;
			}
			mid = tmp;
			i--;
		}
		return res;
	}
	public static void main(String[] args) {
		new DP06_汉诺塔().hanoi(3);
	}
}
