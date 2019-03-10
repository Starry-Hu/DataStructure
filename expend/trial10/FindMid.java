package trial10;

/**
 * 求两个递增数组的中位数 要求时间复杂度为 O(log(m + n))
 * 
 * @author 葫芦胡
 *
 */
public class FindMid {
	private int[] arr1;
	private int[] arr2;

	public void initial(int[] arr1, int[] arr2) {
		this.arr1 = arr1;
		this.arr2 = arr2;
	}

	public double achieve() {
		int length = arr1.length + arr2.length;
		// 偶数长度时
		if (length % 2 == 0) {
			return (midSearch(arr1, 0, arr2, 0, length / 2) + midSearch(arr1, 0, arr2, 0, length / 2 + 1)) / 2.0;
		} else {
			// 奇数长度
			return midSearch(arr1, 0, arr2, 0, (length + 1) / 2);
		}
	}

	/**
	 * 
	 * 查找中位数的辅助递归函数
	 * 
	 * @param num1
	 *            第一个数组
	 * @param n1
	 *            第一个数组的起始查找位置下标
	 * @param num2
	 *            第二个数组
	 * @param n2
	 *            第二个数组的起始查找下标
	 * @param k
	 *            搜索总共合并的第k个数
	 * @return
	 * 
	 */
	private int midSearch(int[] num1, int n1, int[] num2, int n2, int k) {
		// 当num1开始的下标大于他的最大上限时，要找的数直接在num2里面找.注意-1的操作
		if (n1 >= num1.length) {
			// System.out.println(num2[n2 + k - 1]);
			return num2[n2 + k - 1];
		}
		// 当num2开始的下标大于他的最大上限时，要找的数直接在num1里面找
		if (n2 >= num2.length) {
			// System.out.println(num1[n1 + k - 1]);
			return num1[n1 + k - 1];
		}

		// 当k=1,此时只需再找一个数即可,即两者当前的最小值
		if (k == 1) {
			// System.out.println(Math.min(num1[n1], num2[n2]));
			return Math.min(num1[n1], num2[n2]);
		}

		// 对应不同开始下标的其数组的中位数下标
		int p1 = n1 + k / 2 - 1;
		int p2 = n2 + k / 2 - 1;

		// 在范围内则取p1,p2对应的值;否则视为无穷大
		int mid1 = p1 < num1.length ? num1[p1] : Integer.MAX_VALUE;
		int mid2 = p2 < num2.length ? num2[p2] : Integer.MAX_VALUE;

		// 二分法进行处理,将要查找的第k大数缩小一半
		// 如果mid1小,则舍弃num1数组前面那一半(下标后移一位). p1+1为新的起始下标
		// 反之亦如此
		if (mid1 < mid2) {
			return midSearch(num1, n1 + k / 2, num2, n2, k - k / 2);
		} else {
			return midSearch(num1, n1, num2, n2 + k / 2, k - k / 2);
		}
	}
}
