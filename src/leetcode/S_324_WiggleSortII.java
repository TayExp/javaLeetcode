package leetcode;

import java.util.Arrays;

public class S_324_WiggleSortII {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] copy = nums.clone();
        int half = (nums.length+1)/2;
        int j = half, k = nums.length;
        for(int i = 0; i < nums.length; i+=2) 
        	nums[i] = copy[--j];
        for(int i = 1; i < nums.length; i+=2) 
        	nums[i] = copy[--k];
    }
    
    public void wiggleSort2(int[] nums) {
        Arrays.sort(nums);
        int[] copy = nums.clone();
        int half = (nums.length+1)/2;
        int j = half, k = nums.length;
        for(int i = 0; i < nums.length; i+=2) 
        	nums[i] = copy[--j];
        for(int i = 1; i < nums.length; i+=2) 
        	nums[i] = copy[--k];
    }
    
    public static void main(String[] args) {
		new S_324_WiggleSortII().wiggleSort(new int[] {1,5,1,1,6,4});
	}
}
