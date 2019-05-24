package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S_040_CombinationSum2 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		if(candidates.length > 0){
			Arrays.sort(candidates);
			combination(candidates, 0, target, ret, new ArrayList<Integer>());
		}
		return ret;
    }
	
	private void combination(int[] candidates, int start, int target, List<List<Integer>> ret, List<Integer> list) {
		if(target > 0){
			for(int i = start; i < candidates.length && candidates[i]<=target; i++){
				if(i > start && candidates[i] == candidates[i-1])
					continue;
				list.add(candidates[i]);
				combination(candidates, i+1, target-candidates[i], ret, list);
				list.remove(list.size()-1);
			}
			
		}else if(target == 0){
			ret.add(new ArrayList<Integer>(list));
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(new S_040_CombinationSum2().combinationSum2(new int[]{2,3,6,7}, 7));
		
	}

}
