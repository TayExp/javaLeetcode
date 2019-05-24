package leetcode;

import java.util.HashMap;

public class S_166_FractiontoRecurringDecimal {
    public String fractionToDecimal(int num, int den) {
        StringBuilder sb = new StringBuilder();
        String sign = "";
        if(num>0&&den<0 || num<0&&den >0) sign = "-";
        if(num == 0|| den == 0) return "0";
        long numerator = Math.abs((long)num);
        long denominator = Math.abs((long)den);
        long remainder = numerator % denominator;
        int count = 0;
        sb.append(sign).append(numerator/denominator);
        if(remainder == 0) return sb.toString();
        sb.append(".");
        HashMap<Long,Integer> map = new HashMap<>();
        while(!map.containsKey(remainder)){
        	map.put(remainder, count++);
        	sb.append(remainder*10/denominator);
        	remainder = remainder*10 % denominator;
        	if(remainder == 0) return sb.toString();
        }
        sb.insert(sb.length()+map.get(remainder)-count, "(");
        sb.append(")");
        return sb.toString();
    }
    public static void main(String[] args) {
		//System.out.println(new S_166_FractiontoRecurringDecimal().fractionToDecimal(-65,7));
		//System.out.println(new S_166_FractiontoRecurringDecimal().fractionToDecimal(65,10));
		System.out.println(new S_166_FractiontoRecurringDecimal().fractionToDecimal(-1,-2147483648));
	}
}
