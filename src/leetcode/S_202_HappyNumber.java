package leetcode;

import java.util.HashSet;

public class S_202_HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(!set.contains(n))
        	if( n==1 ) return true;
        	else{
        		set.add(n);
        		int tmp = 0;
        		for(char ch : Integer.toString(n).toCharArray())
        			tmp += (ch -'0')*(ch-'0');
        		n = tmp;
        	}
        return false;
    }
}
