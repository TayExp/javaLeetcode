package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class S_179_LargestNumber {
    public String largestNumber(int[] nums) {
    	String[] numbers = new String[nums.length];
    	for(int i = 0; i< nums.length;i++) numbers[i] = Integer.toString(nums[i]);
        Arrays.sort(numbers,new Comparator<String>() {
        	@Override
        	public int compare(String a, String b){
        		 return (b+a).compareTo(a+b);
        	}
		} );
        StringBuilder sb = new StringBuilder();
        for(String s : numbers)
        	sb.append(s);
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}
