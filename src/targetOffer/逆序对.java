package targetOffer;

public class 逆序对 {
	// 归并排序
    public int InversePairs(int [] array) {
        if(array.length == 0) return 0;
        return InversePairsCore(array,array.clone(), 0 ,array.length-1);
    }
    public int InversePairsCore(int [] array, int[] copy, int start, int end) {
        if(start == end) {
        	copy[start] = array[start];
        	return 0;
        }
        int mid = start + (end-start)/2;
        int left = InversePairsCore(copy, array, start, mid);
        int right = InversePairsCore(copy, array, mid+1, end);
        int count = 0, i = mid, j = end, k = end;
        // array里的数复制到copy里
        while(i >= start && j > mid) {
        	if(array[i] > array[j]) {
        		count += j-mid;
        		copy[k--] = array[i--];
                if(count >= 1000000007) count %= 1000000007;
        	} else {
        		// array[i] < array[j]
        		copy[k--] = array[j--];
        	}
        }
        while(i >= start) {
        	copy[k--] = array[i--];
        }
        while(j > mid) {
        	copy[k--] = array[j--];
        }
        return (left + right + count)%1000000007;
    }
}
