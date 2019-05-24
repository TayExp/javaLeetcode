package targetOffer;

public class Solution_11 {
    public int NumberOf1(int n) {
        int count = 0;
        while(n!=0){
            count ++;
            n = (n-1)&n;
        }
            
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
