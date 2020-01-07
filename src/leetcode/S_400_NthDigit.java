package leetcode;

public class S_400_NthDigit {
    public int findNthDigit(int n) {
        // 1000-10000-1  * 3
        int count = 1, tens = 1;;
        while((n-1)/count+tens > tens*10-1){
            n -= count * (tens*10 - tens);
            tens *= 10;
            count++;
        }
        int pop = (n-1) % count;
        n = (n-1) / count;
        //return String.valueOf(tens+n).charAt(pop)-'0';
        return Integer.toString(tens+n).charAt(pop)-'0';
    }
    public static void main(String[] args) {
		System.out.println(new S_400_NthDigit().findNthDigit(2147483647));
	}
}
