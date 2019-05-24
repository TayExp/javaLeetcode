package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S_077_Combinations_排序回溯 {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();   
        combineCore(ret, new ArrayList<Integer>(), 1, n, k);
        return ret;
    }

	private void combineCore(List<List<Integer>> ret, List<Integer> list, int start, int n, int k) {
		if(k == 0){
			ret.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i = start; i<=n; i++){
			list.add(i);
			combineCore(ret, list, i+1, n, k-1);//i+1
			list.remove(list.size()-1);
		}
	}
}
