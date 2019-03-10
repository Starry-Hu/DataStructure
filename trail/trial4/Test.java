package trial4;

public class Test {

	public static void main(String[] args) {
//		System.out.println("------------邻接矩阵存储字符信息(无向图、无权重)----------");
//		GraphMatrix graphMatrix = new GraphMatrix();
//		graphMatrix.createGraph();
//		graphMatrix.show();
		
//		System.out.println("------------邻接矩阵存储整数信息(有向图、有权重)----------");
//		GraphMatrix graphMatrix2 = new GraphMatrix();
//		graphMatrix2.bulidGraph();
//		graphMatrix2.show();

//		System.out.println("------------邻接表存储整数信息----------");
//		GraphList graphList = new GraphList();
//		graphList.createGraph();
//		graphList.show();
//		System.out.println("------------深度优先遍历----------");
//		graphList.dfsAll(0);
//		System.out.println();
//		System.out.println("------------广度优先遍历----------");
//		graphList.bfsAll(0);
		
		
		System.out.println("------------邻接表存储整数信息----------");
		GraphList2 graphList = new GraphList2();
		graphList.createGraph();
//		graphList.show();
		System.out.println("------------深度优先遍历----------");
		graphList.dfsAll(0);
		System.out.println();
		System.out.println("------------广度优先遍历----------");
		graphList.bfsAll(0);
		
	}

}
