package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class S_406_QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        int[][] ret = new int[n][2];
        
        Arrays.sort(people,(a,b)->(a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]));
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++){
            list.add(i);
        }
        for (int[] p : people){
            ret[list.get(p[1])][0] = p[0];
            ret[list.get(p[1])][1] = p[1];
            list.remove(p[1]);
        }
        return ret;
    }
    public static void main(String[] args) {
		int[][] input = new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		System.out.println(new S_406_QueueReconstructionByHeight().reconstructQueue(input));
	}
}