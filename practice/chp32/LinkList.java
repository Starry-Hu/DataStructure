package chp32;


public class LinkList {
	private LNode head;

	private class LNode {
		private int data;
		private LNode link;

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public LNode getLink() {
			return link;
		}

		public void setLink(LNode link) {
			this.link = link;
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
		lNode.link = null;
		head = lNode;
	}

	/**
	 * 将数据值最大的点移到链表的最后面
	 * 
	 * 思路：	利用两对指针
	 * 		一对指向当前节点及其前驱节点
	 * 		另一对指向最大值节点及其前驱节点
	 * 		当 当前节点不为空时  比较其值大小与最大值
	 * 		若大于 则将最大值指针指向当前节点  否则继续遍历移动
	 * 		知道当前节点为空  此时当前节点的前驱为尾节点  
	 * 		将尾节点的link指向最大值节点  同时最大值的前驱的link指向最大值的link 并将最大值的link置为空（变为尾节点）
	 */
	public void removeMaxToTail() {
		LNode pNode = head.link; // 当前节点
		LNode tNode = head; // 当前节点的前驱节点
		LNode qNode = head.link; // 指向最大值节点
		LNode sNode = head; // 最大值节点的前驱节点

		while (pNode != null) {
			if (pNode.data > qNode.data) {
				// 移动最大值指针和其前驱指针
				qNode = pNode;
				sNode = tNode;
			}

			// 向后移动
			pNode = pNode.link;
			tNode = tNode.link;
		}

		/*
		 * 将最大值所指节点移到最后 此时pNode为空 tNode为尾节点
		 */

		sNode.link = qNode.link;
		qNode.link = null;
		tNode.link = qNode;

	}
	
	/**
	 * 返回最后一个节点
	 * 
	 * @return
	 */
	public LNode findTail() {
		LNode pNode = head;
		while (pNode.link != null) {
			pNode = pNode.link;
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
		pNode.link = null;

		LNode tail = findTail();
		tail.link = pNode;
	}

	/**
	 * 遍历节点  最后一个节点不输出空格
	 */
	public void traversal() {
		LNode pNode = head;
		while (pNode.link != null) {
			pNode = pNode.link;
			if (pNode.link == null) {
				System.out.print(pNode.data);
			} else {
				System.out.print(pNode.data + " ");
			}
		}
	}
}
