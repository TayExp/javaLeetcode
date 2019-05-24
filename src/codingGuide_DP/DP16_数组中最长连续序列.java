package codingGuide_DP;

import java.util.HashMap;

public class DP16_数组中最长连续序列 {
	// 哈希表 
	// key:遍历过的某个数 
	// value：key所在的最长连续序列的长度
	// 一个数是否出现过
	// O(N) O(N)
	public int longestConsecutive(int[] arr) {
		if(arr == null || arr.length == 0) return 0;
		int max = 1;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
				if(map.containsKey(arr[i]-1)) {
					max = Math.max(max, merge(map,arr[i]-1,arr[i]));
				}
				if(map.containsKey(arr[i]+1))
					max = Math.max(max, merge(map, arr[i], arr[i]+1));
			}
		}
		return max;
	}

	private int merge(HashMap<Integer, Integer> map, int less, int more) {
		// 只需要map中有关这个区间最小值和最大值的记录
		int left = less - map.get(less) + 1; 
		int right = more + map.get(more) - 1;
		int len = right - left + 1;
		map.put(left, len);
		map.put(right, len);
		return len;
	}
}
