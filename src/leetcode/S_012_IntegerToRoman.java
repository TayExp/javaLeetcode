package leetcode;

public class S_012_IntegerToRoman {
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		String snum = Integer.toString(num);	
		int priority = snum.length();
		for (int i=0;priority>0;i++,priority--){
			sb.append(digToRoman(snum.charAt(i) - '0', priority));
		}
		return sb.toString();
		
	}

	public String digToRoman(int dig, int priority) {
		String high = "", middle = "", low = "";
		switch(priority){
		case 1:
			high = "X";
			middle = "V";
			low = "I";
			break;
		case 2:
			high = "C";
			middle = "L";
			low = "X";
			break;
		case 3:
			high = "M";
			middle = "D";
			low = "C";
			break;
		default:
			low = "M";
		}
		String res = "";
		if (dig <= 3){
			for (int i = 0; i < dig; i++)
				res += low;
		}else if (dig == 9){
			res = low + high;
		} else if (dig == 4) {
			res = low + middle;
		} else {
			res = middle;
			for (int i = 5; i < dig; i++)
				res += low;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new S_012_IntegerToRoman().intToRoman(1994));
		System.out.println(new S_012_IntegerToRoman().intToRoman(58));
		System.out.println(new S_012_IntegerToRoman().intToRoman(9));
		System.out.println(new S_012_IntegerToRoman().intToRoman(0));
	}

}
