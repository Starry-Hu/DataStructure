package chp5;

import java.util.ArrayList;
import java.util.Scanner;

public class HuffTree {
	private HNode root;

	private class HNode {
		private int weight;
		private HNode parent;
		private HNode lchild;
		private HNode rchild;

		public HNode() {
			super();
		}

		@Override
		public String toString() {
			return "HNode [weight=" + weight + ", parent=" + parent + ", lchild=" + lchild + ", rchild=" + rchild + "]";
		}

	}

	public HNode getRoot() {
		return root;
	}

	public void setRoot(HNode root) {
		this.root = root;
	}

	/**
	 * 创建哈夫曼树;同时输出带全路径长度
	 * 
	 * @param nodes
	 */
	public void createTree() {
		// 输入叶子节点的权值
		Scanner scanner = new Scanner(System.in);
		ArrayList<HNode> nodes = new ArrayList<>();
		int num = scanner.nextInt();

		for (int i = 0; i < num; i++) {
			int weight = scanner.nextInt();
			HNode pNode = new HNode();
			pNode.weight = weight;
			nodes.add(pNode);
		}
		scanner.close();

		// 对叶子节点数组进行排序 同时取权值最小的两个构造新的树
		// 观察可得 带全路径长度和为非叶子节点权重和
		int sum = 0;
		while (nodes.size() > 1) {
			sortList(nodes);
			HNode s1 = nodes.get(0);
			HNode s2 = nodes.get(1);
			HNode sNode = new HNode();
			sNode.weight = s1.weight + s2.weight;
			s1.parent = sNode;
			s2.parent = sNode;
			sNode.lchild = s1;
			sNode.rchild = s2;

			sum += sNode.weight;
			nodes.add(sNode);
			nodes.remove(0);
			nodes.remove(0);

		}
		root = nodes.get(0);
		System.out.println(sum);

	}

	/**
	 * 找出数组前两个最小的元素
	 * 
	 * @param nodes
	 */
	public void sortList(ArrayList<HNode> nodes) {
		for (int i = 0; i < 2; i++) {
			for (int j = i + 1; j < nodes.size(); j++) {
				if (nodes.get(j).weight < nodes.get(i).weight) {
					HNode temp = nodes.get(i);
					nodes.set(i, nodes.get(j));
					nodes.set(j, temp);
					temp = null;
				}
			}
		}
	}
}
