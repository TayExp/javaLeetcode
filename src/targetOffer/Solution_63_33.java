package targetOffer;

/*
 * 数据总数目是偶数时插入最小堆(后面)，否则插入最大堆
 * 更新：数据直接插入最小堆，
 * 		不能的话先插入到最大堆，再把最大堆中的最大数字拿出插入最小堆
 */
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_63_33 {
	private Queue<Integer> maxQ = new PriorityQueue<>(new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return -o1.compareTo(o2);
		}
	});
	private Queue<Integer> minQ = new PriorityQueue<>();
	int count = 0;

	public void Insert(Integer num) {
		if ((count & 1) == 0) {
			if (maxQ.size() > 0 && num < maxQ.peek()) {
				maxQ.add(num);
				minQ.add(maxQ.poll());
			} else
				minQ.add(num);
		} else {
			if (minQ.size() > 0 && minQ.peek() < num) {
				minQ.add(num);
				maxQ.add(minQ.poll());
			} else
				maxQ.add(num);
		}

		count++;
	}

	public Double GetMedian() {
		if ((count & 1) == 1)
			return (double) minQ.peek();
		else
			return (minQ.peek() + maxQ.peek()) / 2.0;
	}

	public static void main(String[] args) {
		Solution_63_33 s = new Solution_63_33();
		s.Insert(10);
		s.Insert(2);
		s.Insert(5);
		System.out.println(s.GetMedian());
		s.Insert(4);
		System.out.println(s.GetMedian());
		s.Insert(7);
		s.Insert(6);
		s.Insert(8);
		s.Insert(3);
		s.Insert(9);
		s.Insert(1);
		System.out.println(s.GetMedian());
	}
}
