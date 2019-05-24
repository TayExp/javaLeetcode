package targetOffer;

public class Solution_12 {

/*
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方
 */
	 public double Power1(double base, int exponent) {
		 if (Math.abs(base)<1e-9 && exponent < 0)
			 return 0;
		 int absExponent = Math.abs(exponent);
		 double result = 1;
		 for (int i = 0; i < absExponent; i++)
			 result *= base;
		 if (exponent < 0){
			 result = 1.0/result;
		 }
		 return result;
	 }
	 public double Power(double base, int exponent) {
		 if (Math.abs(base)<1e-9 && exponent < 0)
			 return 0;
		 int absExponent = Math.abs(exponent);
		 double result;
		 result = PowerCore(base,absExponent);
		 if (exponent < 0){
			 result = 1.0/result;
		 }
		 return result;
	 }
	 
	private double PowerCore(double base, int absExponent) {
		if (absExponent == 0)
			return 1;
		else if (absExponent == 1)
			return base;
		double semiResult = PowerCore(base, absExponent>>1);
		double result = semiResult * semiResult;
		if ((absExponent & 1) == 1)
			result *= base;
		return result;
	}
	public static void main(String[] args) {
		Solution_12 s = new Solution_12();
		System.out.println(s.Power(2.1, -3));


	}

}
