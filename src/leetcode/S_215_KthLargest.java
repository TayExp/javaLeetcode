package leetcode;

public class S_215_KthLargest {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int p = quickSelect(nums, 0, n-1, n-k+1);
        return nums[p];
    }

	private int quickSelect(int[] nums, int lo, int hi, int k) {
		// put nums that are <= pivot to the left
	    // put nums that are  > pivot to the right
		// return the index of the kth smallest number
		int i = lo, j = hi,  pivot = nums[hi];
		while(i < j) {
			if(nums[i] > pivot) {
				j--;
				swap(nums, i, j);
			}else {
				i++;
			}
		}
		swap(nums,i,hi);
		int m = i - lo + 1;
		if (m == k)     return i;
	    else if (m > k) return quickSelect(nums, lo, i - 1, k);
	    else            return quickSelect(nums, i+1, hi, k - m);
	}
	
	void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	
	int findKthLargest1(int[] nums, int k) {
		return quickSelect(nums, 0, nums.length-1, nums.length-k);
	}

	   
	private int quickSelect1(int[] nums, int lo, int hi, int k /* index we're looking for */) {
		int i=lo, j = hi, pivot = nums[hi];
		
		while(i < j) 
		    if (nums[i++] > pivot) swap(nums, --i, --j);
		swap(nums, i, hi);
		if(i == k)
		    return nums[i];
		else if(i > k)
		    return quickSelect(nums, lo, i-1, k);
		else
		    return quickSelect(nums, i+1, hi, k);
	    }
	
	
	public static void main(String[] args) {
		System.out.println(new S_215_KthLargest().findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
	}
	
}
