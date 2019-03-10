package trial3;

public class Test {
	public static void main(String[] args) {
		BinaryTree bTree = new BinaryTree();
		System.out.println("=========先序建立二叉树输入数据========");
		bTree.preCreateBiTree(bTree.getRoot());
		System.out.println("=========先序遍历========");
		bTree.preOrder(bTree.getRoot());
		System.out.println("\n=========中序遍历========");
		bTree.inOrder(bTree.getRoot());
		System.out.println("\n=========后序遍历========");
		bTree.postOrder(bTree.getRoot());
		System.out.println("\n=========层次遍历========");
		bTree.levelOrder(bTree.getRoot());

		
		
		System.out.println("\n=========计算所有节点数目========");
		int allNumber = bTree.countAllNode(bTree.getRoot());
		System.out.println(allNumber);
		System.out.println("=========计算叶子节点数目========");
		int leafNum = bTree.countLeaf(bTree.getRoot());
		System.out.println(leafNum);
		System.out.println("=========计算二叉树深度========");
		int depth = bTree.getBiTreeDepth(bTree.getRoot());
		System.out.println(depth);
		System.out.println("=========释放树中所有节点========");
		bTree.dspAllNodes();
		bTree.levelOrder(bTree.getRoot());
//
//		System.out.println("\n\n=========层次建立完全二叉树 输入数据========");
//		BinaryTree bTree2 = new BinaryTree();
//		bTree2.levelCreateBiTree();
//		System.out.println("=========先序遍历========");
//		bTree2.preOrder(bTree2.getRoot());
//		System.out.println("\n=========中序遍历========");
//		bTree2.inOrder(bTree2.getRoot());
//		System.out.println("\n=========后序遍历========");
//		bTree2.postOrder(bTree2.getRoot());
//		System.out.println("\n=========层次遍历========");
//		bTree2.levelOrder(bTree2.getRoot());
	}
}
