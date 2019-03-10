package chp33;

public class LinkList {
	private LNode head;

	private class LNode {
		private int num;
		private int score;
		private LNode next;

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
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
	 * 初始化一个链表
	 */
	public void initial() {
		LNode pNode = new LNode();
		pNode.next = null;
		head = pNode;
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
	 * 在尾部添加一个节点
	 * 
	 * @param num
	 * @param score
	 */
	public void push(int num, int score) {
		LNode pNode = new LNode();
		pNode.num = num;
		pNode.score = score;
		pNode.next = null;

		LNode tail = findTail();
		tail.next = pNode;
	}

	/**
	 * 输出遍历链表
	 */
	public void traversal() {
		LNode pNode = head;
		while (pNode.next != null) {
			pNode = pNode.next;
			String out = "[num=" + pNode.num + ",score=" + pNode.score + "]";
			System.out.println(out);
		}
	}
}
