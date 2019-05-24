package leetcode;

public class S_121_BestTimeToButSell {
    public int maxProfitOnce(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int[] minnums = new int[prices.length-1];
        minnums[0] = prices[0];
        for(int i = 1; i < minnums.length; i++)
        	minnums[i] = Math.min(prices[i], minnums[i-1]);
        int ret = 0;
        for(int i = minnums.length; i > 0; i--)
        	ret = Math.max(ret, prices[i]-minnums[i-1]);
        return ret;
    }
    public int maxProfit(int[] prices) {
        int ret = 0;
        for(int i = 1; i < prices.length; i++){
        	if(prices[i] > prices[i-1])
        		ret += prices[i] - prices[i-1];
        }
        return ret;
    }
}
