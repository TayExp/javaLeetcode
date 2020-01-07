package targetOffer;

public class 表示数值的字符串 {
	public boolean isNumeric(char[] str) {
        int p = 0, end = str.length;
        if (p == end) return true;
        if(p < end && (str[0] == '+' || str[0] == '-')){
            if(++p == end) return false;
        }
        if(!Character.isDigit(str[p]) && str[p]!='.') return false;
        while(p <end && Character.isDigit(str[p])){
            p++;
        }
        if(p < end && str[p] == '.'){
            p++;
            while(p <end && Character.isDigit(str[p])){
                p++;
            }
        }
        if(p == end) return true;
        if(str[p] == 'e' || str[p] == 'E'){
            if( ++p == end ) return false;
            if(str[p] == '+' || str[p] == '-'){
                if(++p == end) return false;
            }
            while(Character.isDigit(str[p])){
                if(++p == end) return true;
            }
        }
        return false;
	}
	public static void main(String[] args) {
		System.out.println(new 表示数值的字符串().isNumeric(".e2".toCharArray()));
		System.out.println(new 表示数值的字符串().isNumeric("e2".toCharArray()));
	}
}
