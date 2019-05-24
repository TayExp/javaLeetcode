package leetcode;

public class S_034_FindFirstLastOfElement {
	
	public int[] searchRange(int[] nums, int target) {
		int[] ret = new int[] {-1,-1};
		int middle, i = 0, j = nums.length - 1;
		while(i <= j){
			middle = (i + j)/2;
			if(nums[middle] == target){
				ret[0] = middle;
				ret[1] = middle;
				while(ret[0] >=0 && nums[ret[0]] == target)
					ret[0]--;
				ret[0]++;
				while(ret[1] < nums.length && nums[ret[1]] == target)
					ret[1]++;
				ret[1]--;
				return ret;
			}
			else if(nums[middle]<target)
				i = middle + 1;
			else
				j = middle - 1;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new S_034_FindFirstLastOfElement().searchRange(new int[]{5,7,7,8,8,10}, 6)[0]);
		System.out.println(new S_034_FindFirstLastOfElement().searchRange(new int[]{5,7,7,8,8,10}, 6)[1]);
		System.out.println(new S_034_FindFirstLastOfElement().searchRange(new int[]{8,8,8,8,8,8}, 8)[0]);
		System.out.println(new S_034_FindFirstLastOfElement().searchRange(new int[]{8,8,8,8,8,8}, 8)[1]);
		System.out.println(new S_034_FindFirstLastOfElement().searchRange(new int[]{1,4}, 4)[0]);
		System.out.println(new S_034_FindFirstLastOfElement().searchRange(new int[]{1,4}, 4)[1]);
	}

}
