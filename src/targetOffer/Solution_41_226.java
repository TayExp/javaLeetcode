package targetOffer;

import java.util.ArrayList;

/*
 * small big 保存两头的数
 * sum保存和，初始为small+big
 * 动态规划？是吗：while(big>small){
 * 		if(sum==tsum)存结果，+big+1-small-(small+1);big+1,small+2}
 * 		if(sum>tsum) small+1
 * 		else big+1
 */
public class Solution_41_226 {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int small = 1, big = 2;
		int cur_sum = small + big;
		
		if (cur_sum <= sum) {
			while(small<big){
				if (cur_sum == sum) {
					ArrayList<Integer> list = new ArrayList<>();
					for (int i = small; i <= big; i++)
						list.add(i);
					result.add(list);
					cur_sum += big - small * 2;
					big++;
					small += 2;
				} else if (cur_sum < sum) {
					big++;
					cur_sum += big;
				} else {
					cur_sum -= small;
					small++;
				}
			}
		}
		return result;

	}
	public static void main(String[] args) {
		System.out.println(new Solution_41_226().FindContinuousSequence(9));

	}

}
