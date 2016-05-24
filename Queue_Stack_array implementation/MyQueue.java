
public class MyQueue<T> {
	private int rear;
	private int front;
	private T[] array;
	private int size;

	public MyQueue(int sizeof){
		this.size=sizeof;
		this.array=(T[]) new Object[this.size];
		this.front=0;
		this.rear=0;
	}
		
	public void remove(){
		if (front==rear)
		{
			System.out.println("the queue is empty,nothing to remove");
		}
		else
		{
		  for(int i=front-1;i>0;i--)
			  array[i-1]=array[i];
		  array[front]=null;
		  front--;
		}
	}
	public void add(T element){
		if (front+1>size)
		{
			System.out.println("no more space to add things");
			
		}
		else
		{
		array[front]=element;
		front++;
		}
	}
  
	public void seeQueue()
	{
		for(int i=0;i<front;i++)
		{
			System.out.println(array[i]);
		}
	}
}
