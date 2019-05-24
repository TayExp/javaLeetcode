package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S_018_4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		int len = nums.length,continueflag_i = 0,continueflag_j = 0;
		int i, j;
		for (i = 0; i < len; i++) {
			if(continueflag_i == 1){
				while (i + 1 < len && nums[i + 1] == nums[i]) {
					i++;
				}
				continueflag_i = 0;
				continue;
			}

			for (j = i + 1; j < len; j++) {
				if (continueflag_j == 1) {
					while (j + 1 < len && nums[j] == nums[j + 1]) {
						j++;
					}
					continueflag_j = 0;
					continue;
				}
				int p = j+1;
				int q = len-1;
				int sum2 = target- nums[i]-nums[j];
				while(p<q){
					if(nums[p]+nums[q] == sum2){
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[p]);
						list.add(nums[q]);
						if (j + 1 < len && nums[j + 1] == nums[j])
							continueflag_j = 1;
						if (i + 1 < len && nums[i + 1] == nums[i])
							continueflag_i = 1;
						result.add(list);
						do {
							p++;
						} while (p + 1 < len && nums[p + 1] != nums[p]);

					}
					else if (nums[p] + nums[q] < sum2)
						p++;
					else
						q--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new S_018_4Sum().fourSum(new int[] { -3, -2, -1, 0, 0, 1, 2, 3 }, 0));
		System.out.println(new S_018_4Sum().fourSum(new int[] { 0, 0, 0, 0 }, 0));
		System.out.println(new S_018_4Sum().fourSum(new int[] { -1, -5, -5, -3, 2, 5, 0, 4 }, -7));
		System.out.println(new S_018_4Sum().fourSum(new int[] { 0, 0, 4, -2, -3, -2, -2, -3 }, -1));

	}
}
