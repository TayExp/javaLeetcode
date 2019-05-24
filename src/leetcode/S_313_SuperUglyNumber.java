package leetcode;

public class S_313_SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
    	int curid = 1,p = 0;
    	if(n == 0 || (p=primes.length) == 0) return 0;
        int[] nums = new int[n];
        nums[0] = 1;
        int[] id = new int[p];
        
        while(curid < n) {
        	int curnum = nums[id[0]]*primes[0];
        	for(int i = 1; i < p; i++)
        		curnum = Math.min(curnum, nums[id[i]]*primes[i]);
        	nums[curid]  = curnum;
        	for(int i = 0; i < p; i++)
        		while(nums[id[i]]*primes[i] <= curnum)
        			id[i]++;
        	curid++;
        }
        return nums[n-1];
    }
    public static void main(String[] args) {
		System.out.println(new S_313_SuperUglyNumber().nthSuperUglyNumber(12, new int[] {2,7,13,19}));
	}
}
