package demo;

/**
 * 实现顺序存储的栈
 * 
 * @author 葫芦胡
 *
 */
public class Stack {
	private int[] data;
	private int top;
	private int maxSize;
	public int[] getData() {
		return data;
	}
	public void setData(int[] data) {
		this.data = data;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	
	public Stack() {
		super();
	}
	
	/**
	 * 初始化一个栈
	 * @param initialSize
	 * @return
	 */
	public boolean initialStack( int initialSize) {
		if (initialSize == 0 ) {
			System.out.println("大小不能为0   初始化失败");
			return false;
		}
		maxSize = initialSize;
		data = new int[initialSize];
		top = -1;
		return true;
	}
	
	/**
	 * 栈顶添加元素  （先移动  再赋值）
	 * @param x
	 * @return
	 */
	public boolean push(int x) {
		if (top == maxSize-1) {
			throw new RuntimeException("队满 ！添加元素失败");
		}else {
			top++;
			data[top] = x;
			return true;
		}
	}
	
	/**
	 * 删除并返回栈顶元素
	 * @return
	 */
	public int pop() {
		if (top == -1) {
			throw new RuntimeException("队空  没有可删除的元素");
		}else {
			int value = data[top];
			top++;
			return value;
		}
	}
	
	/**
	 * 获取栈顶元素的值
	 * @return
	 */
	public int getTopValue() {
		if (top == -1) {
			throw new RuntimeException("队空 ");
		}else {
			return data[top];
		}
	}
	
	/**
	 * 查找指定大小的值的下标
	 * @param x
	 * @return
	 */
	public int find(int x) {
		if (top == -1) {
			throw new RuntimeException("队空 ");
		}else {
			for (int i = top; i >= 0 ; i--) {
				if (data[i] == x) {
					return i;
				}
			}
			return -1;
		}
	}
}
