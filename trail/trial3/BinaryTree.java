package trial3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 二叉链表存储树 先序建立时0代表空树，此时节点不为空 层次建立时，节点为空即为空树
 * 
 * @author 葫芦胡
 *
 */
public class BinaryTree {
	private BNode root;

	// 输入
	private Scanner scanner = new Scanner(System.in);

	private class BNode {
		private int data;
		private BNode Lchild;
		private BNode Rchild;

		public BNode() {
			data = 0;
			Lchild = null;
			Rchild = null;
		}

	}

	public BNode getRoot() {
		return root;
	}

	public void setRoot(BNode root) {
		this.root = root;
	}

	public BinaryTree() {
		// 初始化树
		root = new BNode();
	}

	/**
	 * 实现前序创建树; 0 的时候为空
	 * 
	 * @param root
	 */
	public void preCreateBiTree(BNode root) {
		// 注意不能够新建scanner然后传数据 会出现不停的创建错误
		int data = scanner.nextInt();
		if (data == 0) {
			return;
		} else {
			// 分别递归创建左右子树
			/*
			 * 注意不用再次创建子树对象 再通过子树来调用该方法 传参中就代表其是一棵子树了 且所有的创建都是在大树底下 （不用创建小树） 直接调用即可 同时注意
			 * 按需分配节点空间 (不能一开始分配好之后再去改成null 这样只是断了引用连接) 内存分配了，你只能改内存中的数据，而不能删除内存
			 * 这块内存只有被回收了这个对象才被删除
			 * 
			 * 确认非空树后要给左右节点初始化 否则空指针错误
			 */
			root.data = data;
			root.Lchild = new BNode();
			root.Rchild = new BNode();

			preCreateBiTree(root.Lchild);
			preCreateBiTree(root.Rchild);
		}
	}

	/**
	 * 实现前序遍历树
	 * 
	 * @param root
	 */
	public void preOrder(BNode root) {
		if (root == null || root.data == 0) {
			return;
		} else {
			// 调用传参实现遍历 （传入的参数为子树的根）
			System.out.print(root.data + " ");
			preOrder(root.Lchild);
			preOrder(root.Rchild);
		}
	}

	/**
	 * 中序遍历树
	 * 
	 * @param root
	 */
	public void inOrder(BNode root) {
		if (root == null || root.data == 0) {
			return;
		} else {
			inOrder(root.Lchild);
			System.out.print(root.data + " ");
			inOrder(root.Rchild);
		}
	}

	/**
	 * 后序遍历树
	 * 
	 * @param root
	 */
	public void postOrder(BNode root) {
		if (root == null || root.data == 0) {
			return;
		} else {
			postOrder(root.Lchild);
			postOrder(root.Rchild);
			System.out.print(root.data + " ");
		}
	}

	/**
	 * 二叉链表存储的层次遍历 依赖队列 以0代替空树
	 * 
	 * @param root
	 *            参数可传可不传 反正是树的根（不用递归）
	 */
	public void levelOrder(BNode root) {
		// 使用队列保存地址信息
		Queue<BNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			// 取出队头元素且删除
			// 并将其左右孩子入队

			BNode head = queue.poll();

			/*
			 * null针对层次建立完全二叉树的情况（此时0不是空树标志） data==0 针对前序建立二叉树（此时0是空树标志）
			 * 考虑到层次遍历要将0所代表的空树体现出来
			 */
			if (head == null) {
				// 若队头元素为空 结束此次循环 去取下一个队头元素分析
				continue;
			} else if (head.data == 0) {
				System.out.print(0 + " ");
				continue;
			}
			System.out.print(head.data + " ");
			queue.offer(head.Lchild);
			queue.offer(head.Rchild);
		}
	}

	/**
	 * 导入层次建立完全二叉树的数据
	 * 
	 * @return
	 */
	public ArrayList<Integer> addData() {
		ArrayList<Integer> data = new ArrayList<>();
		while (scanner.hasNextInt()) {
			int x = scanner.nextInt();
			data.add(x);
		}
		scanner.close();
		return data;
	}

	/**
	 * 层次建立完全二叉树 此时0不再是结束符（空树）
	 * 
	 * @param data
	 */
	public void levelCreateBiTree() {
		ArrayList<Integer> data = addData();
		// 使用队列保存地址信息
		Queue<BNode> queue = new LinkedList<>();
		int i = 0;
		root.data = data.get(i++);
		queue.offer(root);

		/*
		 * 弹出第一个元素 但不删除 
		 * 在数据充足的条件下 为其左右孩子分配空间 否则默认左右孩子为null
		 * 每次处理一个
		 */

		while (i < data.size()) {
			BNode head = queue.peek();

			if (head.Lchild == null) {
				BNode node = new BNode();
				node.data = data.get(i++);
				head.Lchild = node;
				queue.offer(node);
			} else if (head.Rchild == null) {
				BNode node = new BNode();
				node.data = data.get(i++);
				head.Rchild = node;
				queue.offer(node);
			} else {
				// 删除该队头元素节点 为之后的腾出空间
				queue.poll();
			}
		}
	}

	/**
	 * 采用前序遍历的方法递归计算所有的节点数, 在自己1的基础上加上左右两个
	 * 
	 * @param root
	 *            (不使用传int参数直接加的方法/不能改变值)
	 * @return
	 */
	public int countAllNode(BNode root) {
		if (root == null || root.data == 0) {
			return 0;
		} else {
			int left = countAllNode(root.Lchild);
			int right = countAllNode(root.Rchild);
			return 1 + left + right;
		}
	}

	/**
	 * 采用前序遍历的方法递归累加计算叶子节点个数
	 * 
	 * @param root
	 * @return
	 */
	public int countLeaf(BNode root) {
		if (root == null || root.data == 0) {
			return 0;
		} else {
			Boolean leftBool = root.Lchild == null || root.Lchild.data == 0;
			Boolean RightBool = root.Rchild == null || root.Rchild.data == 0;

			if (leftBool && RightBool) {
				return 1;
			} else {
				return countLeaf(root.Lchild) + countLeaf(root.Rchild);
			}

		}
	}

	/**
	 * 获取二叉树的深度 （使用层次累加和深度比较）
	 * 
	 * @param root
	 * @param level
	 * @param depth
	 * @return
	 */
	public int getBiTreeDepth(BNode root) {
		if (root == null || root.data == 0) {
			return 0;
		} else {
			int leftDepth = getBiTreeDepth(root.Lchild);
			int rightDepth = getBiTreeDepth(root.Rchild);
			int countDepth =  (leftDepth > rightDepth) ? leftDepth : rightDepth;
			return countDepth + 1;

		}
		// 一步步递归，进行level的累计。
		// 此时传的level仍是当前层的，内部level （但每一层不一样）
		// 最终有效的结果都是depth 与一层一层的level值比较得来的最大值
		// int level = 1;
		// int depth = 1;
		// level++; // 当前节点的层次
		// if (level > depth) {
		// depth = level;
		// }
	}

	/**
	 * 释放root为根节点的树下的所有节点
	 * 
	 * @param root
	 */
	public void dspNode(BNode root) {
		if (root == null || root.data == 0) {
			return;
		} else {
			dspNode(root.Lchild);
			root.Lchild = null;
			dspNode(root.Rchild);
			root.Rchild = null;
		}
	}
	
	/**
	 * 释放整棵树节点
	 * @param root
	 */
	public void dspAllNodes() {
		// 整棵树下的所有节点都释放了
		dspNode(root);
		// 将root本身置null
		setRoot(null);
	}
}
