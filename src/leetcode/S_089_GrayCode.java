package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S_089_GrayCode {
	 public List<Integer> grayCode(int n) {
	       List<Integer> gray = new ArrayList<>();
	       gray.add(0);
	       if(n > 0){
	    	   gray.add(1);
	    	   int count = 2, k = 1;
	    	   while(k < n){
	    		   for(int i = gray.size()-1; i>=0; i--)
	    			   gray.add(count+gray.get(i));
	    		   k++;
	    		   count*=2;
	    	   }		   
	       }
	       return gray;    	   
	 }
	 public static void main(String[] args){
		 System.out.println(new S_089_GrayCode().grayCode(1));
	 }
}
