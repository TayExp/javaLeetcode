package leetcode;

public class S_043_StringMulti {
	  public String multiply(String num1, String num2) {
		  String sum = "";
		  if(num1.equals("0") || num2.equals("0"))
			  return "0";
		  for(int i = 0; i < num2.length(); i++){
			  sum += "0";
			  sum = add(sum, multiDigit(num1, num2.charAt(i)-'0')); 
		  }
		  return sum;
	  }
	  
	  private String multiDigit(String num, int digit){
		  StringBuilder sb = new StringBuilder();
		  int i = 1, len = num.length(), carry = 0;
		  while(len-i >= 0){
			  int sum = (num.charAt(len-i)-'0') * digit + carry;
			  carry = sum / 10;
			  sb.insert(0, sum%10);
			  i++;
		  }
		  if(carry != 0)
			  sb.insert(0, carry);
		
		  return sb.toString();
	  }
	  
	  private String add(String num1, String num2){
		  StringBuilder sb = new StringBuilder();
		  int i = 1, len1 = num1.length(), len2 = num2.length(), carry = 0;
		  while(len1-i >= 0 && len2-i >= 0){
			  int sum = (num1.charAt(len1-i)-'0') +  (num2.charAt(len2-i)-'0') + carry;
			  carry = sum / 10;
			  sb.insert(0, sum%10);
			  i++;
		  }
		  if( len1 >= len2)
			  while(len1 - i >= 0){
				  int sum = num1.charAt(len1-i)-'0'+carry;
				  carry = sum/10;
				  sb.insert(0, sum%10);
				  i++;
			  }
		  else
			  while(len2 - i >= 0){
				  int sum = num2.charAt(len2-i)-'0'+carry;
				  carry = sum/10;
				  sb.insert(0, sum%10);
				  i++;
			  }
		  if(carry != 0)
			  sb.insert(0, carry);
		  return sb.toString();
	  }
	  public static void main(String[] args) {
			System.out.println(new S_043_StringMulti().multiply("123", "456"));
			System.out.println(new S_043_StringMulti().multiply("0", "456"));
			System.out.println(new S_043_StringMulti().multiply("123", "0"));
			System.out.println(new S_043_StringMulti().multiply("2", "3"));
			

		}
}
