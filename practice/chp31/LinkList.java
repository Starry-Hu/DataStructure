package chp31;

public class LinkList {
	private LNode head;

	private class LNode {
		private int data;
		private LNode next;

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public LNode getNext() {
			return next;
		}

		public void setNext(LNode next) {
			this.next = next;
		}
	}

	public LNode getHead() {
		return head;
	}

	public void setHead(LNode head) {
		this.head = head;
	}

	/**
	 * 初始化一个带头结点的链表
	 */
	public void initial() {
		LNode lNode = new LNode();
		lNode.next = null;
		head = lNode;
	}

	/**
	 * 在值为x的节点后插入值为y的节点
	 * 
	 * @param x
	 * @param y
	 */
	public void insert(int x, int y) {
		LNode pNode = head.next;
		while (pNode != null) {
			if (pNode.data == x) {
				break;
			}
			pNode = pNode.next;
		}
		if (pNode == null) {
			throw new RuntimeException("没有找到指定值的节点");
		} else {
			LNode qNode = new LNode();
			qNode.data = y;
			qNode.next = pNode.next;
			pNode.next = qNode;
		}
	}

	public boolean remove(int x) {
		LNode pNode = head; // 当前节点的前驱节点
		LNode qNode = head.next; // 当前节点

		while (qNode != null) {
			if (qNode.data == x) {
				pNode.next = qNode.next; // 前驱节点直接指向当前的下一个节点
				return true;
			}
			pNode = qNode;
			qNode = qNode.next;
		}
		return false; // 没有找到指定值节点
	}

	/**
	 * 查指定值的节点
	 * 
	 * @param x
	 * @return
	 */
	public LNode find(int x) {
		LNode pNode = head.next;
		while (pNode != null) {
			if (pNode.data == x) {
				return pNode;
			}
			pNode = pNode.next;
		}
		return null;
	}

	/**
	 * 返回最后一个节点
	 * 
	 * @return
	 */
	public LNode findTail() {
		LNode pNode = head;
		while (pNode.next != null) {
			pNode = pNode.next;
		}
		return pNode;
	}

	/**
	 * 在最后添加一个元素
	 * 
	 * @param x
	 */
	public void push(int x) {
		LNode pNode = new LNode();
		pNode.data = x;
		pNode.next = null;

		LNode tail = findTail();
		tail.next = pNode;
	}

	public void traversal() {
		LNode pNode = head;
		while (pNode.next != null) {
			pNode = pNode.next;
			System.out.println(pNode.data + " ");
		}
	}

	/**
	 * 获取现有链表的长度
	 * 
	 * @return
	 */
	public int getLength() {
		int length = 0;
		LNode pNode = head;
		while (pNode.next != null) {
			length++;
			pNode = pNode.next;
		}
		return length;
	}

	/**
	 * 查找倒数第k个节点并返回
	 * 
	 * @param k
	 * @return
	 */
	public LNode findReverseK(int k) {
		LNode pNode = head;
		int length = getLength();
		if (k > length || k < 1) {
			System.out.println("输入k值不合法");
			return null;
		}
		
		//循环  找到length-k+1这个位置的节点  即对应的倒数第k个节点
		for (int i = 0; i <= length - k; i++) {
			pNode = pNode.next;
		}
		System.out.println(pNode.data);
		return pNode;
	}
}
