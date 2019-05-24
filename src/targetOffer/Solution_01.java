package targetOffer;

public class Solution_01 {

	public boolean Find(int target, int [][] array) {
	        if (array.length > 0){
	        	int rows = array.length;
	        	int columns = array[0].length;
	        	int column = columns - 1;
	        	int row = 0;
	        	while (row < rows && column >= 0){
	        		if (array[row][column] == target){
	        			return true;
	        		}
	        		else if (array[row][column] > target){
	        			column --;
	        		}
	        		else {
	        			row ++;
	        		}
	        	}
	        }
	        return false;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
