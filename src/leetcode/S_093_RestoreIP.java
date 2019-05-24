package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S_093_RestoreIP {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        if(s.length() > 0)
        	restore(ret, s, 4, 0, new ArrayList<String>());
        return ret;
    }

	private void restore(List<String> ret, String s, int left, int start, ArrayList<String> list) {
		if(left==0){
			ret.add(listToString(list));
			return;
		}
		left--;
		if(start + 1 + left <= s.length() && start+1+3*left >= s.length()){
			list.add(s.substring(start, start+1));
			restore(ret, s, left, start+1, list);
			list.remove(list.size()-1);
		}
		if(s.charAt(start)!='0'){
			if(start + 2 + left <= s.length() && start+2+3*left >= s.length()){
				list.add(s.substring(start, start+2));
				restore(ret, s, left, start+2, list);
				list.remove(list.size()-1);
			}
			if(start + 3 + left <= s.length() && start+3+3*left >= s.length()){
				if(s.charAt(start)<'2' || s.charAt(start)=='2'&&
						(s.charAt(start+1)<'5' || s.charAt(start+1)=='5'&&s.charAt(start+2)<='5')){
					list.add(s.substring(start, start+3));
					restore(ret, s, left, start+3, list);
					list.remove(list.size()-1);
				}
			}
		}
	}

	private String listToString(ArrayList<String> list) {
		return list.get(0)+"."+list.get(1)+"."+list.get(2)+"."+list.get(3);
	}
	public static void main(String[] args){
		System.out.println(new S_093_RestoreIP().restoreIpAddresses("25525511135"));
		System.out.println(new S_093_RestoreIP().restoreIpAddresses("010010"));
	}

}
