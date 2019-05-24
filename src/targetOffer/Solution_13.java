package targetOffer;
/*输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 思路：遇见奇数就往前插,插在所有偶数前面
 */
public class Solution_13 {
	public void reOrderArray(int [] array) {
		int k = 0; // 插好的奇数
        for (int i = 0; i < array.length; i++)
        	if(! isEven(array[i])){
        		for(int j = i; j > k; j--){
        			int temp = array[j];
        			array[j] = array[j-1]; 
        			array[j-1] = temp;
        		}
        		k++;
        	}
    }
	
	public boolean isEven(int num){
		return (num & 1)==0;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {};
		new Solution_13().reOrderArray(a);
		for (int num : a)
			System.out.println(num);
	}

}
