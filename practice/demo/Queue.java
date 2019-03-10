package demo;

/**
 * 队列的实现  顺序存储的队列
 * 其中front指向队头元素前一个  rear指向队尾元素的下标
 * 
 * @author 葫芦胡
 *
 */
public class Queue {
	private int[] data; // 存储数据
	private int maxSize; // 队列容量
	private int front; // 队头的前一个元素
	private int rear; // 队尾、插入

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getFront() {
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public int getRear() {
		return rear;
	}

	public void setRear(int rear) {
		this.rear = rear;
	}

	public Queue() {
		super();
	}

	/**
	 * 初始化队列
	 * 
	 * @param initialSize
	 * @return
	 */
	public boolean initialQueue(int initialSize) {
		if (initialSize >= 0) {
			this.maxSize = initialSize;
			data = new int[initialSize];
			front = rear = -1; // 使得第一个元素的位置在0下标
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断队空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (rear == front) {
			return true;
		} else {
			return false;
		}
		// return rear==front?true:false;
	}

	/**
	 * 添加元素 （队尾入队）
	 * 
	 * @param e
	 * @return
	 */
	public boolean add(int x) {
		if (rear == maxSize-1) {
			System.out.println("队列已满，无法插入新的元素");
			return false;
		} else {
			rear++;
			data[rear] = x;
			return true;
		}
	}

	/**
	 * 删除元素 (队首删除) 并返回该元素
	 * 
	 * @return
	 */
	public int pop() {
		//注意不能用data.length 这个是静态数组  判断不出来
		if (isEmpty()) {
			throw new RuntimeException("空队列异常！");
		} else {
			int value = data[++front]; // 保留front端的后的第一个元素值
			return value;
		}
	}

	/**
	 * 取队头元素
	 * 
	 * @return
	 */
	public int getHead() {
		if (isEmpty()) {
			throw new RuntimeException("空队列  获取队头元素失败");
		} else {
			return data[(front + 1)];
		}
	}

	public int getLength() {
		return rear - front;
	}

	public int find(int x) {
		if (isEmpty()) {
			throw new RuntimeException("空队列  无法查找");
		}
		for (int i = 0; i < data.length; i++) {
			if (data[i] == x) {
				return i;
			}
		}
		return -1;
	}
}
