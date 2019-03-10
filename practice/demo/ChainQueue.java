package demo;


/**
 * 实现链队  链式存储的对
 * 
 * @author 葫芦胡
 *
 */
public class ChainQueue {
	private QNode head; // 头指针（指向头结点）
	private QNode tail; // 尾指针（指向队尾元素）

	/**
	 * 定义链队内部节点类型
	 * 
	 * @author 葫芦胡
	 *
	 */
	private class QNode {
		private int data;
		private QNode next;

		public QNode() {
			super();
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public QNode getNext() {
			return next;
		}

		public void setNext(QNode next) {
			this.next = next;
		}

	}
	public QNode getHead() {
		return head;
	}

	public void setHead(QNode head) {
		this.head = head;
	}

	/**
	 * 初始化一个带头结点的链队
	 */
	public void initial() {
		QNode qNode = new QNode();
		qNode.next = null;
		head = qNode;
	}

	/**
	 * 获取链队的长度
	 * 
	 * @return
	 */
	public int getLength() {
		int length = 0;
		QNode p = head;
		while (p.next != null) {
			p = p.next;
			length++;
		}
		return length;
	}

	/**
	 * 队尾插入元素
	 * 
	 * @param x
	 */
	public void add(int x) {
		QNode p = new QNode();
		p.data = x;
		p.next = null;
		tail.next = p;
		tail = p;
	}

	/**
	 * 获取首元节点
	 * 
	 * @return
	 */
	public QNode getHeadNode() {
		if (head != tail) {
			QNode p = head.next;
			return p;
		}
		return null;
	}

	/**
	 * 队头删除元素 并返回该元素
	 * 
	 * @return
	 */
	public QNode pop() {
		// 也可以采用 head != tail
		if (head.next != null) {
			QNode p = head.next;
			head.next = p.next;
			return p;
		} else {
			System.out.println("空队列！");
			return null;
		}
	}

	/**
	 * 根据要查找的值找节点
	 * 相当于定位运算
	 * @param x
	 * @return
	 */
	public QNode findByValue(int x) {
		// 可以用head.next(已经移到了后面  只要判断自己是不是空就行) 也可以用head(需要判断后面有没有  然后再移过去)
		QNode p = head.next;
		while (p != null) {
			if (p.data == x)
				return p;
			else {
				p = p.next;
			}
		}
		return null;
	}

	/**
	 * 查找第i个节点
	 * @param i
	 * @return
	 */
	public QNode findByIndex(int i) {
		QNode p = head;
		int j = 0;
		while (( p.next != null) && (i<j)) {
			p = p.next;
			j++; //当前为第j个节点
		}
		
		if (i == j) {
			return p;
		}else {
			return null;
		}
	}
}
