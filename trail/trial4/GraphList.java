package trial4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 使用邻接表存储图信息
 * 
 * @author 葫芦胡
 *
 */
public class GraphList {
	private GNode[] datas;

	/*
	 * GNode为邻接表表头数组类型 其中data为该顶点的数据信息 link为指向第一条依附该节点的弧
	 */

	private class GNode {
		private int data;
		private EdgeNode link;

		@Override
		public String toString() {
			return "GNode [data=" + data + ", link=" + link + "]";
		}

	}

	/*
	 * EdgeNode为邻接表表结点类型 adjvex 用以指示与该顶点邻接的顶点序号位置 next 用以指向下一条有邻接关系的边
	 */
	private class EdgeNode {
		// 顶点域 用以指示与该顶点邻接的顶点序号位置
		// 链域 用以指向下一条有邻接关系的边
		private int adjvex;
		private EdgeNode next;

		@Override
		public String toString() {
			return "GNode [adjvex=" + adjvex + ", next=" + next + "]";
		}

	}

	/**
	 * 用邻接表存储图
	 */
	public void createGraph() {
		Scanner scanner = new Scanner(System.in);

		// 输入点个数和边个数
		System.out.println("------------请输入顶点数和边数----------");
		int pointNum = scanner.nextInt();
		int sideNum = scanner.nextInt();

		// 初始化表头结点(数据类型为int整型);初始化访问变量
		datas = new GNode[pointNum];

		for (int i = 0; i < pointNum; i++) {
			datas[i] = new GNode();
			datas[i].data = i;
		}

		// 输入边信息
		System.out.println("------------请输入(vi,vj)边的下标i,j----------");
		for (int k = 0; k < sideNum; k++) {
			int i = scanner.nextInt();
			int j = scanner.nextInt();

			// 倒序建立邻接表;从后往前插入
			EdgeNode pNode = new EdgeNode();
			pNode.adjvex = j;
			pNode.next = datas[i].link;
			datas[i].link = pNode;
		}

		scanner.close();
	}

	/**
	 * 显示邻接表信息
	 */
	public void show() {
		for (int i = 0; i < datas.length; i++) {
			System.out.println(datas[i]);
		}
	}

	/**
	 * 深度优先 从任意节点出发递归访问每个节点信息 根据index下标来确定信息
	 * 
	 * @param index
	 */
	private void dfs(int index, int[] visited) {
		System.out.print(datas[index].data + " ");
		visited[index] = 1;// 已访问

		EdgeNode pNode = datas[index].link;
		while (pNode != null) {
			if (visited[pNode.adjvex] != 1) {
				// 递归遍历下一个节点的信息
				dfs(pNode.adjvex, visited);
			}
			pNode = pNode.next;
		}
	}

	/**
	 * 深度优先遍历所有节点（考虑了多连通分图的情况）
	 * 
	 * @param index
	 */
	public void dfsAll(int index) {
		int[] visited = new int[datas.length];
		dfs(index, visited);

		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == 0) {
				dfs(i, visited);
			}
		}
	}

	private void bfs(int index, int[] visited) {
		// 借助队列实现广度优先（类似树的层次遍历）
		Queue<Integer> queue = new LinkedList<>();
		queue.add(index);

		// 将链表的下面节点的值都存入队列
		while (!queue.isEmpty()) {
			
			int index2 = queue.poll();
			if (visited[index2] == 1) {
				continue;
			}
			System.out.print(datas[index2].data + " ");
			visited[index2] = 1;
			EdgeNode pNode = datas[index2].link;
			
			
			// 把下面的链表节点都放进去
			while (pNode != null) {
				queue.add(pNode.adjvex);
				pNode = pNode.next;
			}
			
		}
	}
	
	/**
	 * 广度优先遍历所有节点
	 * 
	 * @param index
	 */
	public void bfsAll(int index) {
		int[] visited = new int[datas.length];
		bfs(index, visited);
		
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == 0) {
				bfs(i, visited);
			}
		}
	}
}
