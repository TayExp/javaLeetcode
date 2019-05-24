package leetcode;

public class S_043_StringMulti2 {
	  public String multiply(String num1, String num2) {
		  int m = num1.length(), n = num2.length();
		  int[] pos = new int[m+n];
		  for(int i = m-1; i >= 0; i--)
			  for(int j = n-1; j>=0; j-- ){
				  int sum = (num1.charAt(i)-'0')*(num2.charAt(j)-'0')+pos[i+j+1];
				  pos[i+j+1] = sum%10;;
				  pos[i+j] += sum/10;
			  }
		 StringBuilder sb = new StringBuilder();
		 for (int p : pos) if(p!=0 || sb.length()>0) sb.append(p);
		 return sb.length()>0?sb.toString():"0";
	  }
	
	  public static void main(String[] args) {
			System.out.println(new S_043_StringMulti2().multiply("123", "456"));
			System.out.println(new S_043_StringMulti2().multiply("0", "456"));
			System.out.println(new S_043_StringMulti2().multiply("123", "0"));
			System.out.println(new S_043_StringMulti2().multiply("2", "3"));
			

		}
}
