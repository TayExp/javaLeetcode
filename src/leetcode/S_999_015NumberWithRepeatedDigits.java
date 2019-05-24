package leetcode;

import java.util.HashSet;

public class S_999_015NumberWithRepeatedDigits {
    HashSet<Integer> set = new HashSet<>();
    boolean hasZero = false;
	public int numDupDigitsAtMostN(int N) {
		if(N<=10) return 0;
		if(N<=100) return 9;
		int predigit = Integer.toString(N).charAt(0)-'0';
        int len = Integer.toString(N).length();
        int remain_sm = 10 - set.size();
        int remain_lg = 10 - set.size() + (hasZero?1:0);
        // 0 - 9999
        int first = (int)Math.pow(10, len-1)-remain_lg; //减去一位数
        int tmp = 1;
        for(int i = 1; i < len-1; i++){
        	tmp *= (remain_lg-i);
        	first -= remain_sm*tmp;
        }
        // 10000-29999
        tmp = remain_lg;
        for(int i = 1; i < len; i++)
        	tmp *= (remain_lg-i);
        int second = (Integer.toString(N).charAt(0)-'1')*(int)(Math.pow(10, len-1)-tmp);
        // 30000-30086->0-0086
        int third = 0;
        if(!set.contains(predigit)){
        	set.add(predigit);
        	hasZero = (predigit == 0);
        	third = numDupDigitsAtMostN(N-first * (int)Math.pow(10, len-1));
        }
        return first + second + third; 
    }
}
