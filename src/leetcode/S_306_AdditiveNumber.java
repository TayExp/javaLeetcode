package leetcode;

import java.math.BigInteger;

public class S_306_AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
    	int n = num.length();
        for(int i = 1; i <= n/2; i++) {//0-i
        	if(num.charAt(0) == '0' && i > 1) return false;
        	 BigInteger a = new BigInteger(num.substring(0, i));
        	for(int j = 1; Math.max(i, j) <= n-i-j; j++) {  //i+1-j
        		if(num.charAt(i) == '0' && j > 1) break;
        		BigInteger b = new BigInteger(num.substring(i, i+j));
        		if(isValid(a, b, j+i, num)) return true;
           	}
        }
        return false;
    }

	private boolean isValid(BigInteger a, BigInteger b, int start, String num) {
		if(start == num.length()) return true;
		b = b.add(a); //c = a+b
		a = b.subtract(a); //a=b
		String c = b.toString();
		return num.startsWith(c,start) && isValid(a, b, start+c.length(), num);
	}

    public boolean isAdditiveNumber1(String num) {
    	int n = num.length();
        for(int i = 1; i <= n/2; i++) {//0-i
        	for(int j = 1; Math.max(i, j) <= n-i-j; j++) {  //i+1-j
        		if(isValid1(i, j, num)) return true;
           	}
        }
        return false;
    }

	private boolean isValid1(int i, int j, String num) {
		if(num.charAt(0) == '0' && i > 1) return false;
		if(num.charAt(i) == '0' && j > 1) return false;
	   	BigInteger a = new BigInteger(num.substring(0, i));
		BigInteger b = new BigInteger(num.substring(i, i+j));
		String sum;
		for(int start = i + j; start != num.length(); start += sum.length()) {
			b = b.add(a);
			a = b.subtract(a);
			sum = b.toString();
			if(num.startsWith(sum, start)) return false;
		}
		return true;
	}
}
