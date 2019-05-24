package leetcode;

public class S_165_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");   
        int i = 0;
        for(; i < v2.length && i < v1.length; i++){
        	int cmp = Integer.parseInt(v1[i]) - Integer.parseInt(v2[i]);
        	if(cmp != 0)
        		return cmp>0?1:-1;
        }
        if(v1.length < v2.length){
            for(; i < v2.length; i++)
                if(Integer.parseInt(v2[i]) > 0 ) return -1;
        } else if(v1.length > v2.length){
            for(; i < v1.length; i++)
                if(Integer.parseInt(v1[i]) > 0 ) return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
		System.out.println(new S_165_CompareVersionNumbers().compareVersion("1.1", "0.1"));
    }
}
