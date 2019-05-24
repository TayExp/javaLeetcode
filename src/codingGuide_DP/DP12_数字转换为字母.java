package codingGuide_DP;

public class DP12_数字转换为字母 {
	// N层递归 时间O（2^N) 空间O(N)
	public int numDecoding1(String s) {
		if(s == null || s.equals("")) return 0;
		char[] chs = s.toCharArray();
		return process(chs, 0);
	}

	private int process(char[] chs, int i) {
		if(i == chs.length) return 1;
		if(chs[i] == '0') return 0;
		int res = process(chs, i+1);
		if(i+1 < chs.length && ((chs[i]-'0') * 10 + chs[i+1] - '0') < 27)
			res += process(chs,i+2);
		return res;
	}
	
	// 从后往前计算 时间O(N) 空间O(1)
	// 类似Fabonacci数列计算
	public int numDecoding2(String s) {
		if(s == null || s.equals("")) return 0;
		char[] chs = s.toCharArray();
		int cur = chs[chs.length-1] == '0' ? 0 : 1;
		int next = 1; // 注意初始值要设为1
		int tmp = 0;
		for(int i = chs.length-2; i >= 0; i--) { // key如何滚动更新
			if(chs[i] == '0') {
				next = cur;
				cur = 0;
			} else {
				tmp = cur;
				if(((chs[i] - '0') * 10 + chs[i+1] - '0') <27)
					cur += next;
				next = tmp;
			}
		}
		return cur;
	}
	
}
