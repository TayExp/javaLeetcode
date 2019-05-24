package leetcode;

public class S_033_SearchRotatedSortedArray {
    
	public int search1(int[] nums, int target) {
		if (nums.length == 0)
			return -1;
		int middle, start = 0, end = nums.length - 1;
		while(start+1<end){
			middle = (start + end)/2;
			if(nums[middle] > nums[0])
				if (target > nums[middle] || target < nums[0])
					start = middle + 1;
				else
					end = middle;
			else if (target > nums[end] || target < nums[middle] )
				end = middle - 1;
			else
				start = middle;
		}
		if (nums[start] == target)
			return start;
		else if(nums[end] == target)
			return end;
		else
			return -1;
    }
	
	
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = start + (end-start) / 2;
            if (nums[mid] == target)  return true;
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) //turn to right side
                    start = mid + 1;
                else 
                    end = mid - 1;
            //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) 
                    end = mid - 1;
                else 
                    start = mid + 1;
            } else {// end-- but left++ works too
                end--;
            }
        }
        return false;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new S_033_SearchRotatedSortedArray().search(new int[]{4,5,6,7,0,1,2}, 4));
	}

}
