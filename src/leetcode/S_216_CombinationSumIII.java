package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S_216_CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();    
        int maxn = 0, minn = 0;
        for(int i = 0; i < k; maxn += 9-i, i++, minn += i);
        if(n > maxn || n < minn) return ret;
        ArrayList<Integer> l = new ArrayList<>();
        if(k == 1) {l.add(n);ret.add(l);return ret;}
        combination(ret, l, 1, k, n);
        return ret;
    }

	private void combination(List<List<Integer>> ret, ArrayList<Integer> l, int start, int k, int n) {
		if(l.size()==k-2) {
			for(int i = start; i < n-i; i++) {
				if(n-i <= 9) {
					List<Integer> nl = new ArrayList<>(l);
					nl.add(i);
					nl.add(n-i);
					ret.add(nl);
				}
			}
			return;
		}
		for(int i = start; i < 10; i++ ) {
			l.add(i);
			combination(ret, l, i+1, k, n-i);
			l.remove(l.size()-1);
		}
	}
	
    public static void main(String[] args) {
		System.out.println(new S_216_CombinationSumIII().combinationSum3(1,10));
	}
}
