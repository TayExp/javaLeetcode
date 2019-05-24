package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S_119_Pascal {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> iRow = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            iRow.add(1);
            if(i>0){
                for(int j = 1; j < i; j++)
                    iRow.add( ret.get(i-1).get(j-1) + ret.get(i-1).get(j) );
                iRow.add(1);
            }
            ret.add(new ArrayList<Integer>(iRow));
            iRow.clear();
        }
        return ret;
    }

	public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        ret.add(1);
        for(int i = 1; i <= rowIndex; i++){
        	long tmp = ret.get(i-1);
        	tmp *= rowIndex-i+1;
            ret.add((int) (tmp/i));
        }
        return ret;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new S_119_Pascal().generate(5));
		System.out.println(new S_119_Pascal().getRow(32));
	}
}
