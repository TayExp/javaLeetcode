package leetcode;
import java.util.ArrayList;
import java.util.List;
public class S_207_CourseSchedule {
	public boolean canFinish(int n, int[][] prerequisites) {
		int[] indegree = new int[n];
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<Integer>());
        int zero = -1;
        for(int[] edge : prerequisites){
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        for(int i = 0; i < n; i++ ){
            if(indegree[i]==0){
                indegree[i] = zero;
                zero = i;
               }
        }
        if (zero == -1) return false;
        for(int i = 0;i < n; i++){
            if(zero == -1) return false;
            int vi = zero;
            zero = indegree[zero];
            for(int j : graph.get(vi)){
                indegree[j]--;
                if(indegree[j] == 0){
                    indegree[j]=zero;
                    zero=j;
                }
            }
        }
        return true;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new S_207_CourseSchedule().canFinish(2, new int[][]{{1,0},{0,1}}));
	}

}
