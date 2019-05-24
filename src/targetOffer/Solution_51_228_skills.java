package targetOffer;

/*
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
 * 
 * 方法：分前和后
 * 前：b(0) = 1 ；b(i) = b(i-1)*a(i-1)
 * 后： temp = 1, temp = temp * a(i+1) , b(i) = temp*b(i) 
 */
public class Solution_51_228_skills {
	public int[] multiply(int[] A) {
		
		int[] B = new int[A.length];
		if(A.length > 0){
			B[0] = 1;
			for (int i = 1; i < A.length; i++)
				B[i] = A[i - 1] * B[i - 1];
			int temp = 1;
			for (int i = A.length - 2; i >= 0; i--) {
				temp *= A[i + 1];
				B[i] *= temp;
			}
		}
		return B;
	}
}
