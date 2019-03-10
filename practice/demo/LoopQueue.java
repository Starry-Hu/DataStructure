package demo;

/**
 * 实现循环队列 采用损失一个位置来实现判断队满
 * 
 * @author 葫芦胡
 *
 */
public class LoopQueue {
	private int[] data;
	private int maxSize;
	private int front; // 指向队头元素的前一个
	private int rear; // 指向队尾元素

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

	public LoopQueue() {
		super();
	}

	/**
	 * 初始化循环队列
	 * 
	 * @param initialSize
	 */
	public void initialLoopQueue(int initialSize) {
		this.maxSize = initialSize;
		this.data = new int[maxSize];
		front = rear = 0;
	}

	/**
	 * 获取循环队列的容量
	 * 
	 * @return
	 */
	public int getCapacity() {
		return (rear - front + maxSize) % maxSize;
	}

	public boolean isEmpty() {
		if (front == rear) { // 依然用来判空
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 队尾添加元素
	 * 
	 * @param x
	 * @return
	 */
	public boolean add(int x) {
		//损失一个空间来判断队列是否已满
		if ((rear + 1) % maxSize == front) {
			System.out.println("队列已满，无法插入新元素");
			return false;
		} else {
			rear = (rear + 1) % maxSize;
			data[rear] = x;
			return true;
		}
	}

	/**
	 * 删除并返回队头元素
	 * 
	 * @return
	 */
	public int pop() {
		if (front == rear) {
			throw new RuntimeException("空队列！没有元素");
		} else {
			front = (front + 1) % maxSize; // 移到下一个 （即原本的第一个，现在的队头的前一个元素
			int value = data[front];
			return value;
		}
	}

	/**
	 * 返回队头元素
	 * 
	 * @return
	 */
	public int getHead() {
		if (isEmpty()) {
			throw new RuntimeException("空队列！");
		} else {
			return data[(front + 1) % maxSize];
		}
	}

	/**
	 * 查找指定元素  存在则返回下标  否则返回-1
	 * @param x
	 * @return
	 */
	public int find(int x) {
		if (isEmpty()) {
			throw new RuntimeException("空队列！ 查找失败");
		}
		else {
			// 下标从front+1 开始
			for (int i = 0,p = front+1 ; i < getCapacity(); i++) {
				if (data[p] == x) {
					return p;
				}
			}
			return -1;
		}
	}
	
	

}
