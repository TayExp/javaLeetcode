package targetOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 数组排序连接 {
   	public String PrintMinNumber(int[] numbers) {
   		List<String> nums = new ArrayList<>();
   		for(int i = 0; i < numbers.length; i++) {
   			nums.add(String.valueOf(numbers[i]));
   		}
   		Collections.sort(nums, (a, b) -> ((a+b).compareTo(b+a)));
//   		Collections.sort(nums, new Comparator<String>() {
//			public int compare(String o1, String o2) {
//				return (o1+o2).compareTo(o2+o1);
//			}
//		});
   		return String.join("", nums);
	}
}
