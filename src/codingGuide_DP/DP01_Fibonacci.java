package codingGuide_DP;

public class DP01_Fibonacci {
	public int f1(int n) {
		if(n <= 0) return 0;
		if(n <= 2) return 1;
		int ret = 1, minus1 = 1, minus2 = 1;
		for(int i = 3; i <= n; i++) {
			ret = minus1 + minus2;
			minus2 = minus1;
			minus1 = ret;
		}
		return ret;
	}
	
	public int f2(int n) {
		if(n <= 0) return 0;
		if(n <= 2) return 1;
		int[][] base = {{1,1}, {1,0}};
		int[][] ret = matrixPower(base, n-2);
		return ret[0][0] + ret[1][0];
	}
	
	private int[][] matrixPower(int[][] m, int p) {
		int l = m.length; // 方阵
		int[][] ret = new int[l][l];
		// 单位矩阵
		for(int i = 0; i < l; i++)
			ret[i][i] = 1;
		int[][] tmp = m;
		// 指数/2
		for(; p != 0; p >>= 1) {
			if((p&1) != 0)
				ret = multiMatrix(ret, tmp); //遇奇数存一下当前矩阵，变成偶数
			tmp = multiMatrix(tmp, tmp);// 加速矩阵乘法 Ologn
		}
		return ret;
	}

	private int[][] multiMatrix(int[][] m, int[][] n) {
		// 维度合理
		int[][] ret = new int[m.length][n[0].length];
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < n[0].length; j++) 
				for(int k = 0; k < n.length; k++){
					ret[i][j] += m[i][k] * n[k][j]; 
				}
		return ret;
	}
	
	/*
	 * 所有的牛都不会死
	 * 成熟的牛会生出一头新的牛
	 * 动态规划:Cn = Cn-1 + Cn-3:新成熟的都是Cn-3年的牛
	 */

	public int c3(int n) {
		if(n < 1) return 0;
		if(n <= 3) return n; // 1,2,3
		int[][] base = {{1, 1, 0},{0, 0, 1},{1, 0, 1}};
		int[][] res = matrixPower(base, n-3);
		return 3*res[0][0] + 2* res[1][0] + res[2][0]; //1,2,3
	}
	public static void main(String[] args) {
		System.out.println(new DP01_Fibonacci().f2(17));//1597
	}
}
