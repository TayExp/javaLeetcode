package leetcode;

public class S_004_MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		if (m > n) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
			int tmp = m;
			m = n;
			n = tmp;
		}
		int iMin = 0, iMax = m;
		while (iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = (m + n + 1) / 2 - i;
			if (i > iMin && nums1[i - 1] > nums2[j]) {
				iMax = i - 1;
			} else if (i < iMax && nums2[j - 1] > nums1[i]) {
				iMin = i + 1;
			} else { // i is perfect
				int maxLeft = 0;
				if (j == 0)
					maxLeft = nums1[i - 1];
				else if (i == 0)
					maxLeft = nums2[j - 1];
				else
					maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
				if ((m + n) % 2 == 1)
					return maxLeft;
				int minRight = 0;
				if (j == n)
					minRight = nums1[i];
				else if (i == m)
					minRight = nums2[j];
				else
					minRight = Math.min(nums1[i], nums2[j]);
				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[] { 1, 2 };
		int[] nums2 = new int[] { 3, 4, 5 };
		System.out.println(new S_004_MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
	}

}
