package leetcode;

public class S_307_RangeSumQuery_Multable {

	private int[] tree;
	private int n;
    public S_307_RangeSumQuery_Multable(int[] nums) {
        n = nums.length;
    	tree = new int[2*n];
    	for(int i = 0; i < n; i++) 
    		tree[i+n] = nums[i];
    	for(int i = n-1; i > 0; --i)
    		tree[i] = tree[2*i] + tree[2*i+1];
    }
    
    public void update(int i, int val) {
    	i += n;
    	tree[i] = val;
        while(i > 0) {
        	 int l = i, r = i;
        	 if((i & 1) == 0)
        		 r++;
        	 else
        		 l--;
        	i /= 2;
        	tree[i] = tree[l] + tree[r];
        } 
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        i += n;
        j += n;
        while(i <= j) {
        	if((i&1) == 1) {
        		sum += tree[i];
        		i++;
        	}
        	if((j&1) == 0) {
        		sum += tree[j];
        		j--;
        	}
        	i /= 2;
        	j /= 2;
        }
        return sum;
    }

}
