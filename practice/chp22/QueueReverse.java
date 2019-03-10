package chp22;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 实现队列元素逆置（使用栈）
 * 
 * @author 葫芦胡
 *
 */
public class QueueReverse {
	/**
	 * 初始化一个队列
	 * @param queue
	 * @param n
	 * @param scanner
	 */
	public void init(Queue<Integer> queue, int n, Scanner scanner) {
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			queue.offer(x);
		}
	}

	/**
	 * 将队列的元素取出来放入栈中
	 * @param queue
	 * @param stack
	 */
	public void addStack(Queue<Integer> queue, Stack<Integer> stack) {
		while (queue.size() != 0) {
			int item = queue.poll();
			stack.push(item);
		}
	}
	
	/**
	 * 将栈中的元素取出来放入队列中
	 * @param queue
	 * @param stack
	 */
	public void addQueue(Queue<Integer> queue, Stack<Integer> stack) {
		while (stack.size() != 0 ) {
			int item = stack.pop();
			queue.offer(item);
		}
	}
	
	public static void main(String[] args) {
		QueueReverse qReverse = new QueueReverse();
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		
		qReverse.init(queue, n, scanner);
		qReverse.addStack(queue, stack);
		qReverse.addQueue(queue, stack);
		
		Queue<Integer> queue2 = new LinkedList<>();
		queue2 = queue;
		for (int i = 0; i < n; i++) {
			if (i == n-1) {
				System.out.print( queue2.poll() );
			}
			else {
				System.out.print( queue2.poll() + " ");
			}
		}
	}
}
