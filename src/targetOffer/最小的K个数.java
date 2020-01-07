package targetOffer;

import java.util.ArrayList;
import java.util.Collections;

public class 最小的K个数 {
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
		ArrayList<Integer> result = new ArrayList<>();
        if(k < nums.length){
            int start = 0, end = nums.length-1;
            int index = Partition(nums, start, end);
            while(k != index && k != index-1){
                if(index > k){
                    index = Partition(nums, start, end = index-1);
                } else{
                    index = Partition(nums,start = index, end);
                }
            }
        }else if( k > nums.length) {
        	return result;
        }

        for(int i = 0; i < k; i++){
            result.add(nums[i]);
        }
        Collections.sort(result);
		return result;
	}

	public int Partition(int[] nums, int start, int end) {
		swap(nums, start, start+(end-start)/2);
        int pivot = start;
        start++;
        while(start < end){
            while(start < end && nums[start] <= nums[pivot]) start++;
            while(start < end && nums[end] >= nums[pivot]) end--;
            if(start < end) swap(nums, start, end);
        }
        if(nums[start] <= nums[pivot]){
            start++;
        } 
        swap(nums, start-1, pivot);
        return start;
	}

	public void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
	public static void main(String[] args) {
		System.out.println(new 最小的K个数().GetLeastNumbers_Solution(new int[] {1,1,1,1,1},3));
	}

}
