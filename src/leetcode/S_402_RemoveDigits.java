package leetcode;

import java.util.LinkedList;

public class S_402_RemoveDigits {
    public String removeKdigits(String num, int k) {
        int i = 0, n = num.length();
        LinkedList<Character> ll = new LinkedList<>();
        while(i < n){
            char c = num.charAt(i++);
        	while(!ll.isEmpty() && k > 0 && c < ll.getLast()){
        		ll.removeLast();
            	k--;
        	}
            ll.offer(c);
        }
        while(k-- > 0) {
        	ll.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        while(!ll.isEmpty()) {
        	char c = ll.poll();
            if(sb.length() > 0 || c != '0'){
                sb.append(c);
            }
        }
        return sb.length() == 0 ? "0":sb.toString();
    }
    public static void main(String[] args) {
		System.out.println(new S_402_RemoveDigits().removeKdigits("1432219", 3));
		System.out.println(new S_402_RemoveDigits().removeKdigits("119", 2));
	}
}
