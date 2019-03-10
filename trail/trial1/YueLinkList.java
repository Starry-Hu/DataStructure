package trial1;

/**
 * 用循环链表实现约瑟夫环
 * 
 * @author 葫芦胡
 *
 */
public class YueLinkList {
	// 头指针
	private Ynode head;
	// 开始报数的编号
	private int startNum;
	// 循环到 报该数 的出局
	private int cycleNum;

	public Ynode getHead() {
		return head;
	}

	public void setHead(Ynode head) {
		this.head = head;
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

	private class Ynode {
		private int data;
		private Ynode next;

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Ynode getNext() {
			return next;
		}

		public void setNext(Ynode next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "Ynode [data=" + data + ", next=" + next + "]";
		}

	}

	@Override
	public String toString() {
		return "YueLinkList [head=" + head + ", startNum=" + startNum + ", cycleNum=" + cycleNum + "]";
	}

	/**
	 * 初始化
	 * 
	 * @param startNum
	 * @param cycleNum
	 */
	public void initial(int startNum, int cycleNum) {
		// 指向头结点
		Ynode ynode = new Ynode();
		head = ynode;
		ynode.next = head;

		this.startNum = startNum;
		this.cycleNum = cycleNum;
	}

	/**
	 * 在尾部添加节点
	 * 
	 * @param data
	 */
	public void push(int data) {
		Ynode s = new Ynode();
		s.data = data;
		s.next = head;

		Ynode oldTail = getTailNode();
		oldTail.next = s;
	}

	/**
	 * 获取尾节点（最后一个节点 之后循环回去）
	 * 
	 * @return
	 */
	public Ynode getTailNode() {
		Ynode s = head;
		while (s.next != head) {
			s = s.next;
		}
		return s;
	}

	/**
	 * 返回该循环链表的长度
	 * 
	 * @return
	 */
	public int getLength() {
		int length = 0;
		Ynode s = head;
		while (s.next != head) {
			s = s.next;
			length++;
		}
		return length;
	}

	/**
	 * 删除节点
	 * 
	 * @param ynode
	 *            参数为前一个节点
	 */
	public void remove(Ynode ynode) {
//		if (ynode == getTailNode()) {
//
//		}
		Ynode deNode = ynode.next;
		ynode.next = deNode.next;
	}

	/**
	 * 从第一个元素开始报数
	 * 即下面的 achieve2() //startNum = 1
	 */
	public void achieve1() {
		// 第0个节点(头结点);要删除的前驱
		Ynode s = head;
		// 链表不为空的时候 一直循环下去
		while (head.next != head) {
			// 报到cycleNum-1就行;得到其前驱节点来删除
			for (int i = 1; i < cycleNum; i++) {
				s = s.next;
				// 如果指向的是头结点  进行修正
				if (s == head) {
					s = head.next;
				}
			}
			// 删除节点的值
			// 如果头结点位于删除的编号  则将他后面的删除
			if (s.next == head) {
				s = s.next;
			}

			System.out.println(s.next.data);
			remove(s);
		}
	}

	/**
	 * 找到循环链表的第k个节点
	 * 
	 * @param k
	 * @return
	 */
	public Ynode find(int k) {
		if (k < 0 || k > getLength()) {
			System.out.println("输入k值不合法");
			return null;
		}
		Ynode s = head;
		for (int i = 1; i <= k; i++) {
			s = s.next;
		}
		return s;
	}

	/**
	 * 实现从指定下标开始循环
	 */
	public void achieve2() {
		// 第0个节点(头结点);要删除的前驱
		Ynode s = find(startNum - 1);
		if (s == null) {
			System.out.println("不存在相应开始节点");
			return;
		}

		// 链表不为空的时候 一直循环下去
		while (head.next != head) {
			// 报到cycleNum-1就行;得到其前驱节点来删除
			for (int i = 1; i < cycleNum; i++) {
				s = s.next;
				// 如果指向的是头结点  进行修正
				// 头结点自己不参与报数循环
				if (s == head) {
					s = head.next;
				}
			}
			// 删除节点的值
			// 如果头结点位于删除的编号  则将他后面的删除
			if (s.next == head) {
				s = s.next;
			}

			System.out.print(s.next.data);
			remove(s);
		}
	}

	/**
	 * 遍历节点
	 */
	public void traversal() {
		Ynode s = head;
		while (s.next != head) {
			s = s.next;
			System.out.print(s.data);

		}
	}
}
