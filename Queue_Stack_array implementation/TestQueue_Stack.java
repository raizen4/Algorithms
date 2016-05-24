
public class TestQueue_Stack {

	public static void main(String[] args) {
		MyStack<Integer> stack=new MyStack<>(3);
		stack.add(5);
		stack.add(10);
		stack.remove();
		stack.add(20);
		stack.add(30);
		stack.add(40);
		stack.seeStack();
		System.out.println("--------------------Stack test done-----------");
		MyQueue<Integer> queue=new MyQueue<>(4);
		queue.add(5);
		queue.add(6);
		queue.seeQueue();
		queue.remove();
		queue.seeQueue();
                          
	}

}
