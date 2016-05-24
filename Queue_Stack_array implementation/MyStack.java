
public class MyStack<T> {
	private int size;
	private T[] array;
	private int front;
	private int rear;

	@SuppressWarnings("unchecked")
	public MyStack(int sizeof) {
		this.size = sizeof;
		this.array = (T[]) new Object[size];
		this.front = 0;
		this.rear = 0;
	}

	public void remove() {
		if (front == rear) {
			System.out.println("the queue is already empty");

		} else {
			front--;
			array[front] = null;

		}
	}

	public void add(T element) {
		if (front + 1 > size) {
			System.out.println("The queue is already full,you can t add any items to it");
		} else {

			if (array[0] == null) {
				array[0] = element;
				front++;
			} else {
				array[front] = element;
				front++;
			}
		}

	}

	public void seeStack() {
		if (front == 0 && array[front] == null) {
			System.out.println("Nothing to see,it is empty");
		} else {
			for (int i = 0; i < front; i++)
				System.out.println(array[i]);
		}
	}

	public int Queuelenght() {
		return array.length;
	}

}
