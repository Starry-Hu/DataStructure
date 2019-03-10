package trial1;

import java.util.Arrays;

/**
 * 使用顺序表实现约瑟夫环
 * 
 * @author 葫芦胡
 *
 */
public class YueSeqList {
	private int maxSize;
	private int[] data;
	private int length;
	private int startNum;
	private int cycleNum;

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getCycleNum() {
		return cycleNum;
	}

	public void setCycleNum(int cycleNum) {
		this.cycleNum = cycleNum;
	}

	@Override
	public String toString() {
		return "YueSeqList [maxSize=" + maxSize + ", data=" + Arrays.toString(data) + ", length=" + length
				+ ", startNum=" + startNum + ", cycleNum=" + cycleNum + "]";
	}

	public YueSeqList(int maxSize) {
		this.maxSize = maxSize;
	}

	public YueSeqList() {
		super();
	}

	/**
	 * 初始化顺序表
	 */
	public void initial(int startNum, int cyclyNum, int maxSize) {
		if (maxSize == 0) {
			System.out.println("请确保输入最大数值");
			return;
		}
		this.startNum = startNum;
		this.cycleNum = cyclyNum;
		this.maxSize = maxSize;
		data = new int[maxSize];
		// 初始化数组
		for (int i = 0; i < maxSize; i++) {
			data[i] = i + 1;
		}
		length = maxSize;
	}

	/**
	 * 判断是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	/**
	 * 删除第i个位置的节点 （注意从i=1 开始一直到 i=length 才是数据）
	 * 
	 * @param i
	 */
	public void remove(int i) {
		if (length == 0 || i < 0 || i > length - 1) {
			System.out.println("删除位置不合法");
			return;
		}
		// 当要删除的是最后一个节点时  不存在元素的偏移  只要改变长度即可
		for (int j = i; j < length - 1; j++) {
			data[j] = data[j + 1];
		}
		length--;
	}

	public void tranversal() {
		for (int i = 0; i < length; i++) {
			System.out.print(data[i]);
		}
	}

	/**
	 * 利用数组 顺序实现
	 */
	public void achieve() {
		// 开始的位置下标 注意从0 开始
		int i = this.startNum - 1;
		while (!isEmpty()) {
			i = (i + cycleNum - 1) % length;
			System.out.print(data[i]);
			remove(i);
		}
	}
}
