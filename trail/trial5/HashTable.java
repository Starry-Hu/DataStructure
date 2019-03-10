package trial5;


/**
 * 
 * 电话号码查询系统;哈希表实现
 * 
 * @author 葫芦胡
 *
 */
public class HashTable {

	// 哈希表
	private TNode[] hst = new TNode[8];

	/**
	 * @author 葫芦胡
	 *
	 */
	private class TNode {
		private String telephone;
		private String username;
		private String address;

		private TNode next;

		@Override
		public String toString() {
			return "TNode [telephone=" + telephone + ", username=" + username + ", address=" + address + ", next="
					+ next + "]";
		}
		
		
	}

	public TNode[] getHst() {
		return hst;
	}

	public void setHst(TNode[] hst) {
		this.hst = hst;
	}

	
	public void show2() {
		for (int i = 0; i < hst.length; i++) {
			System.out.println(hst[i]);

		}
	}

	/**
	 * 初始化哈希表
	 */
	public void initial() {
		for (int i = 0; i < hst.length; i++) {
			hst[i] = new TNode();
		}
	}

	/**
	 * 
	 * 添加数据进入哈希表
	 * 
	 * @param username
	 * @param telephone
	 * @param address
	 */
	public void add(String username, String telephone, String address) {
		TNode tNode = new TNode();
		tNode.username = username;
		tNode.telephone = telephone;
		tNode.address = address;
		int index = hashByPhone(telephone);

		if (index == -1) {
			System.out.println("------" + telephone + "电话信息添加失败------");
			return;
		}

		// 指向这个位置的链表头结点
		TNode pNode = hst[index];

		while (pNode.next != null) {
			pNode = pNode.next;
		}
		pNode.next = tNode;
	}

	/**
	 * 
	 * 根据主关键字删除某条信息
	 * 
	 * @param telephone
	 * @return
	 */
	public void delete(String telephone) {
		int index = hashByPhone(telephone);
		// 创建两个引用 为后续的遍历和删除做准备
		TNode pNodeBefore = hst[index];
		TNode pNode = pNodeBefore.next;

		while (pNode != null) {
			// 如果主关键字对应上了 则删除链表中这个节点
			if (pNode.telephone.equals(telephone)) {
				pNodeBefore.next = pNode.next;
				pNode = null;
				System.out.println("------电话号码"+telephone  +"删除成功------");
				return;
			}
			
			pNodeBefore = pNodeBefore.next;
			pNode = pNode.next;
		}
		System.out.println("------电话号码"+telephone  +"删除失败------");

	}

	/**
	 * 
	 * 查找信息记录
	 * 
	 * @param telephone
	 */
	public void find(String telephone) {
		int index = hashByPhone(telephone);

		TNode pNode = hst[index].next;
		while (pNode != null) {
			if (pNode.telephone.equals(telephone)) {
				System.out.println("------查找成功------");
				System.out.println(
						"------用户名:" + pNode.username + ",电话号码:" + pNode.telephone + ",地址:" + pNode.address + "------");
				return;
			}
			pNode = pNode.next;
		}
		System.out.println("------查找失败------");
	}

	/**
	 * 
	 * 通过电话号码计算哈希值
	 * 
	 * @param tNode
	 * @return
	 */
	public int hashByPhone(String telephone) {
		int sum = 0;
		if (telephone.length() != 11) {
			System.out.println("输入电话号码不合法");
			return -1;
		}
		char[] teleChar = telephone.toCharArray();
		for (int i = 0; i < 11; i++) {
			sum += teleChar[i] - '0';
		}

		return sum % 7;
	}

	/**
	 * 显示所有的信息
	 */
	public void show() {
		for (int i = 0; i < hst.length; i++) {
			TNode pNode = hst[i].next;
			while (pNode != null) {
				System.out.println(
						"------用户名:" + pNode.username + ",电话号码:" + pNode.telephone + ",地址:" + pNode.address + "------");
				pNode = pNode.next;
			}

		}
	}
}
