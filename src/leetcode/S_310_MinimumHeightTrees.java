package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S_310_MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if(n == 0) return new ArrayList<>();
		if(n == 1) return Collections.singletonList(0);
		// 创建邻接图
		List<Set<Integer>> adj = new ArrayList<>();
		for(int i = 0; i < n; i++) 
			adj.add(new HashSet<>());
		for(int[] e:edges) {
			adj.get(e[0]).add(e[1]);
			adj.get(e[1]).add(e[0]);
		}
		// 度数为1 为叶节点
		List<Integer> leaves = new ArrayList<>();
		for(int i = 0; i < n; i++)
			if(adj.get(i).size() == 1) leaves.add(i); 
		// 消叶节点，更新度数
		while(n > 2) {
			n -= leaves.size();
			List<Integer> newleaves = new ArrayList<>();
			for(int i : leaves) {
				int j = adj.get(i).iterator().next();//该叶节点的唯一邻接点
				adj.get(j).remove(i); 
				if(adj.get(j).size() == 1) newleaves.add(j);
			}
			leaves = newleaves;
		}
		return leaves;//大小为1或2
    }
}
