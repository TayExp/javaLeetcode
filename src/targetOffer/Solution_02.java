package targetOffer;

public class Solution_02 {

	public String replaceSpace(StringBuffer str){
		if (str.length() == 0){
			return "";
		}
		int numberOfBlank = 0;
		int originalLength = str.length();
		for (int i = 0; i < originalLength; i++){
			if (str.charAt(i) == ' '){
				numberOfBlank ++;
			}
		}
		int index = originalLength - 1;
		int indexOfNew = originalLength + 2* numberOfBlank - 1;
		str.setLength(indexOfNew+1);
		while (index >= 0 && index != indexOfNew){
			char ch = str.charAt(index);
			if (ch != ' '){
				str.setCharAt(indexOfNew--, str.charAt(index--));
			} else{
				index--;
				str.setCharAt(indexOfNew--, '0');
				str.setCharAt(indexOfNew--, '2');
				str.setCharAt(indexOfNew--, '%');
			}
			
		}
		return str.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer str = new StringBuffer("  ");
		Solution_02 s = new Solution_02();
		System.out.println(s.replaceSpace(str));

	}

}
