package targetOffer;

/*
 * 数组中只有两个数出现了奇数次，找出这两数
 * 将所有数作 异或
 * 结果中首次为1的数位（a)
 * 再次遍历数组，该数位为1 与a做异或；否则，与b作异或。最后剩下求的两个数
 */
public class Solution_40_225_skills {
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		int exclusiveOr = 0;
		for (int num : array) {
			exclusiveOr^=num;
		}
		int index = findFirstBit1(exclusiveOr);
		num1[0] = 0;
		num2[0] = 0;
		for (int num : array) {
			if (isBit1(num, index))
				num1[0] ^= num;
			else
				num2[0] ^= num;
		}
	}

	int findFirstBit1(int num) {
		int index = 0;
		while ((num & 1) == 0) {
			num = num >> 1;
			index++;
		}
		return index;
	}

	boolean isBit1(int num, int index) {
		num = num>>index;
		return (num & 1) == 1;
	}
}
