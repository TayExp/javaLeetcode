package codingGuide_DP;

public class DP14_排成一条线的纸牌博弈 {
	//返回最高分数
	// 暴力递归
	public int win1(int[] arr) {
		if(arr == null || arr.length == 0) return 0;
		return Math.max(firstTake(arr, 0, arr.length-1), secondTake(arr, 0, arr.length-1));
	}

	private int firstTake(int[] arr, int i, int j) {
		if(i == j)  return arr[i];
		// 自己先做决定
		return Math.max(arr[i] + secondTake(arr, i+1, j), arr[j] + secondTake(arr, i, j-1));
	}
	
	private int secondTake(int[] arr, int i, int j) {
		if(i == j) return 0;
		// 对手会给你留少的
		return Math.min(firstTake(arr, i+1, j), firstTake(arr, i, j-1));
	}

	//动态规划 O(N^2) O(N^2)
	public int win2(int[] arr) {
		if(arr == null || arr.length == 0) return 0;
		int[][] first = new int[arr.length][arr.length];
		int[][] second = new int[arr.length][arr.length];
		for(int j = 0; j < arr.length; j++) {
			first[j][j] = arr[j];
			//second[j][j] = 0;
			for(int i = j - 1; i >= 0; i--) {
				first[i][j] = Math.max(arr[i] + second[i+1][j], arr[j] + second[i][j-1]);
				second[i][j] = Math.min(first[i+1][j], first[i][j-1]);
			}
		}
		return Math.max(first[0][arr.length-1], second[0][arr.length-1]);
	}
}
