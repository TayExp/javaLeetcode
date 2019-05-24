package leetcode;

public class S_327_CountRangeSum {
	public int countRangeSum(int[] nums, int lower, int upper) {
		int n = nums.length;
		long[] sums = new long[n+1];
		for(int i = 1; i <= n; i++)
			sums[i] = sums[i-1] + nums[i-1];
		return merge(sums, 0, n+1, lower, upper);
	}

	private int merge(long[] sums, int start, int end, int lower, int upper) {
		// sums[0] = 0 
		if(end - start <= 1) return 0;
		int mid = start + (end - start)/2;
		int count = merge(sums,start,mid,lower,upper) + merge(sums,mid,end,lower,upper);
		int t = mid, j = mid, k = mid;
		long[] cache = new long[end-start];
		//  we have already sorted the left half [start, mid)
		for(int i = start, r = 0; i < mid; i++, r++) {
			while(k < end && sums[k]-sums[i] < lower) k++;
			while(j < end && sums[j]-sums[i] <= upper) j++;
			// use another index t to copy the elements satisfy sums[t] < sums[i]
			// to a cache in order to complete the merge sort
			while(t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
			cache[r] = sums[i];
			count += j - k;
		}
		System.arraycopy(cache, 0, sums, start, t-start);
//		System.out.println("start " + start + "  end "+end + " mid "+ mid);
//		System.out.println("cache:");
//		for(long n : cache)
//			System.out.print(n+" ");
//		System.out.println("\nsums:");
		for(long n : sums)
			System.out.print(n+" ");
		System.out.println("\n");
//		System.out.println("-------------------");
		return count;
	}
	
	public static void main(String[] args) {
//		System.out.println(new S_327_CountRangeSum().countRangeSum(new int[]{-2,5,-1},-2,2));
		System.out.println(new S_327_CountRangeSum().countRangeSum(new int[]{-1,1},0,0));
	}
}
