package demo;

/**
 * 实现一个链栈 （只对首元元素操作） 不带头结点（不方便）
 * 
 * @author 葫芦胡
 *
 */
public class ChainStack {
	private SNode head;

	private class SNode {
		private int data;
		private SNode next;

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public SNode getNext() {
			return next;
		}

		public void setNext(SNode next) {
			this.next = next;
		}
	}

	public SNode getHead() {
		return head;
	}

	public void setHead(SNode head) {
		this.head = head;
	}

	/**
	 * 初始化一个链栈
	 */
	public void initial() {
		head = null;
	}

	/**
	 * 加入一个节点 作为新的首元节点 （改变head的值）
	 * 
	 * @param x
	 */
	public void push(int x) {
		SNode p = new SNode();
		p.data = x;
		p.next = head;
		head = p;
	}

	/**
	 * 删除并返回首元元素
	 * 
	 * @return
	 */
	public int pop() {
		if (head == null) {
			throw new RuntimeException("空栈  删除失败");
		} else {
			int value = head.data;
			head = head.next;
			return value;
		}
	}
	
	/**
	 * 查找某个特定值的节点
	 * @param x
	 * @return
	 */
	public SNode find(int x) {
		SNode p = head;
		while(p != null) {
			if (p.data == x) {
				return p;
			}
		}
		return null;
	}
	
	
}
