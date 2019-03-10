package chp33;

public class Node {
	private int num;
	private int score;
	private Node next;

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

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
	public void initial(Node head) {
		Node pNode = new Node();
		pNode.next = null;
	}
}
