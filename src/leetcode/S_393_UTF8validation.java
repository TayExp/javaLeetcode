package leetcode;

public class S_393_UTF8validation {
	public boolean validUtf8(int[] data) {
		for(int i = 0; i < data.length; i++) {
			int numberofbytes = 0;
			if((data[i] & 128) == 0) {
				numberofbytes = 1;
			} else if((data[i] & 224) == 192) {
				numberofbytes = 2;
			} else if((data[i] & 240) == 224) {
				numberofbytes = 3;
			} else if((data[i] & 248) == 240) {
				numberofbytes = 4;
			} else {
				return false;
			}
			for(int j = 1; j < numberofbytes; j++) {
				i++;
				if(i == data.length || (data[i] & 192) != 128)
					return false;
			}
		}
		return true;
	}
	public boolean validUtf81(int[] data) {
        int cur = 0, n = data.length;
        while(cur < n){
            if((data[cur]&255) > 127) {
            	if(++cur == n) return false;
                if((data[cur-1] & 64) == 64){
                    if((data[cur] & 255) < 128 || (data[cur] & 255) > 191 )
                        return false;
                    if((data[cur-1] & 32) == 32){
                        if(++cur == n || (data[cur] & 255) < 128 || (data[cur] & 255) > 191 )
                            return false;
                        if((data[cur-2] & 16) == 16){
                            if(++cur == n || (data[cur] & 255) < 128 || (data[cur] & 255) > 191 )
                                return false;
                            if((data[(cur++)-3] & 8) != 0)
                            	return false;
                            continue;
                        }
                        if((data[(cur++)-2] & 16) != 0)
                        	return false;
                        continue;
                    }
                    if((data[(cur++)-1] & 32) != 0)
                    	return false;
                    continue;
                }
            }
            cur++;
        }
		return true;
    }
	public static void main(String[] args) {
		System.out.println(new S_393_UTF8validation().validUtf8(new int[] {235,140,135}));
	}
}
