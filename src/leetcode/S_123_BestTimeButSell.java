package leetcode;

public class S_123_BestTimeButSell {
	//卖一次或两次
	public int maxProfit(int[] prices) {
		if(prices.length < 2) return 0;
		int bought1 = -prices[0], bought2 = -prices[0];
		int sold1 = 0, sold2 = 0;
		for(int i = 1; i< prices.length;i++){
			int num = prices[i];
			if(bought2+num > sold2) sold2 = Math.max(sold2, bought2+num);
			if(sold1-num > bought2) bought2 =  sold1-num;
			if(bought1+num > sold1) sold1 = bought1+num;
			if(-num > bought1) bought1 = -num;
		}
		return sold2;
	}
	
	// 卖两次
	public int maxProfit2(int[] prices) {
		if(prices.length < 4) return 0;
		int bought1 = -prices[0], bought2 = -prices[2];
		int sold1 = prices[1]-prices[0], sold2 = prices[3]-prices[2];
		for(int i = 4; i< prices.length;i++){
			int num = prices[i];
			if(bought2+num > sold2)
				sold2 = Math.max(sold2, bought2+num);
			else if(sold1-num > bought2)
				bought2 =  sold1-num;
			else if(bought1+num > sold1)
				sold1 = bought1+num;
			else if(-num > bought1)
				bought1 = -num;
		}
		return sold2;
	}
	
	
	
	//在一次的基础上，粗暴 麻烦
	public int maxProfit1(int[] prices) {
        int ret = maxProfitOnce(prices, 0, prices.length-1);
        for(int i = 1; i <= prices.length-3; i++){
        	ret = Math.max(ret, maxProfitOnce(prices,0,i) + maxProfitOnce(prices, i+1, prices.length-1)); 
        }
        return ret;
    }
	public int maxProfitOnce(int[] prices, int start, int end) {
        if(end <= start)
            return 0;
        int[] minnums = new int[end - start];
        minnums[0] = prices[start];
        for(int i = start+1; i < end; i++)
        	minnums[i-start] = Math.min(prices[i], minnums[i-1-start]);
        int ret = 0;
        for(int i = end; i > start; i--)
        	ret = Math.max(ret, prices[i]-minnums[i-1-start]);
        return ret;
    }
	public static void main(String[] args){
		System.out.println(new S_123_BestTimeButSell().maxProfit(new int[]{3,3,5,0,0,3,1,4}));
	}
}
