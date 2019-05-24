package codingGuide_DP;

public class DP13_表达式得到期望结果 {

	// 检查表达式是否有效 合乎题目要求
	public boolean isValid(char[] exp) {
		if((exp.length&1) == 0) 
			return false;
		for(int i = 0; i < exp.length; i += 2) {
			if(exp[i] != '0' && exp[i] != '1')
				return false;
		}
		for(int i = 1; i < exp.length; i += 2) {
			if(exp[i] != '|' && exp[i] != '&' && exp[i] != '^')
				return false;
		}
		return true;
	}
	
	// 暴力递归 O(N!)  O(N)
	public int num1(String express, boolean desired) {
		if(express == null || express.equals("")) return 0;
		char[] exp = express.toCharArray();
		if(!isValid(exp)) return 0;
		return p(exp, desired, 0, exp.length-1);
	}
	private int p(char[] exp, boolean desired, int l, int r) {
		if(l == r) {
			if(exp[l] == '1')
				return desired?1:0;
			else
				return desired?0:1;
		}
		int res = 0;
		if(desired) {
			for(int i = l + 1; i < r; i += 2) {
				switch(exp[i]) {
					case '&':
						res += p(exp, true, l, i-1) * p(exp, true, i+1, r);
						break;
					case '|':
						res += p(exp, true, l, i-1) * p(exp, true, i+1, r) + 
								p(exp, true, l, i-1) * p(exp, false, i+1, r) +
								p(exp, false, l, i-1) * p(exp, true, i+1, r);
						break;
					case '^':
						res += 	p(exp, true, l, i-1) * p(exp, false, i+1, r) +
								p(exp, false, l, i-1) * p(exp, true, i+1, r);
						break;
					
				}
			}
		} else {
			for(int i = l + 1; i < r; i += 2) {
				switch(exp[i]) {
					case '|':
						res += p(exp, false, l, i-1) * p(exp, false, i+1, r);
						break;
					case '&':
						res += p(exp, false, l, i-1) * p(exp, false, i+1, r) + 
								p(exp, true, l, i-1) * p(exp, false, i+1, r) +
								p(exp, false, l, i-1) * p(exp, true, i+1, r);
						break;
					case '^':
						res += 	p(exp, true, l, i-1) * p(exp, true, i+1, r) +
								p(exp, false, l, i-1) * p(exp, false, i+1, r);
						break;
					
				}
			}
		}
		return res;
	} 
	// 动态规划 O(N^3)   O (N^2)
	public int num2(String express, boolean desired) {
		if(express == null || express.equals("")) return 0;
		char[] exp = express.toCharArray();
		if(!isValid(exp))  return 0;
		int[][] t = new int[exp.length][exp.length];
		int[][] f = new int[exp.length][exp.length];
		t[0][0] = exp[0] == '1' ? 1 : 0;
		f[0][0] = exp[0] == '0' ? 1 : 0;
		for(int i = 2; i < exp.length; i+=2) {
			t[i][i] = exp[i] == '1' ? 1 : 0;
			f[i][i] = exp[i] == '0' ? 1 : 0;
			for(int j = i - 2; j >= 0; j -= 2) {
				for(int k = j; k < i; k += 2) {
					if(exp[k+1] == '&') {
						t[j][i] += t[j][k] * t[k+2][i];
						f[j][i] += t[j][k] * f[k+2][i] + f[j][k] * f[k+2][i] + f[j][k] * t[k+2][i];
					} else if(exp[k+1] == '|') {
						t[j][i] += t[j][k] * f[k+2][i] + f[j][k] * t[k+2][i] + t[j][k] * t[k+2][i]; 
						f[j][i] += f[j][k] * f[k+2][i];
					} else {
						t[j][i] += t[j][k] * f[k+2][i] + f[j][k] * t[k+2][i]; 
						f[j][i] += f[j][k] * f[k+2][i] + t[j][k] * t[k+2][i];
					}
				}
			}
		}
		return desired ? t[0][t.length-1] : f[0][f.length-1];
  	}
}
