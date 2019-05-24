package leetcode;

public class S_065_Valid_TargetOffer {
	//没有通过“.”和“ ”和“E9”和“1.”和“.1”和“.e1”  "46.e3"
	public boolean isNumber(String s) {
		 char[] num = s.trim().toCharArray();
		 int i = 0, end = num.length;
		 boolean flag = false;
		 if(i<end && (num[i] == '+' || num[0] == '-'))
			 i++;
		 if(i == end) return false;
		 while(i <end &&  num[i] >= '0' && num[i] <= '9'){
			 flag = true;
			 i++;
            if(i == end)  return true;
		 }

		 if(num[i] == '.' || num[i] == 'E' || num[i] == 'e'){
			 if(num[i] == '.'){
				 i++;
				 while(i <end &&  num[i] >= '0' && num[i] <= '9'){
					 flag = true;
					 i++;
				}
               if(flag && i == end) return true;
			}
			if( flag && i<end && (num[i] == 'E' || num[i] == 'e')){
				 i++;
				 if(i<end && (num[i] == '+' || num[i] == '-'))
					 i++;
				 while(i<end && num[i] >= '0' && num[i] <= '9'){
					 i++;
					 if(i == end)
						 return true;
				}
			}
		 }
		 return false;
	 }
	 private boolean isDigit(char c){
		 return c >= '0' && c <= '9';
	 }
}
