
public class MyLinkedList <T>{
	@SuppressWarnings("rawtypes")
	Node head;
	@SuppressWarnings("rawtypes")
	Node tail;
	int size;

	private class Node<T> {
		T data;
		Node nextNode;

		public Node(T data) {
			this.data = data;
		}
		
	}

	public MyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public void add(T data) {
		/*
		 * casses: 1)list empty 2)list not empty
		 */
		Node node = new Node(data);
		if (tail == null && head == null) {
			node.nextNode = null;
			head = node;
			tail = node;
			size++;

		} else {
			Node traversenode = head;
			while (traversenode.nextNode != null) {
				traversenode = traversenode.nextNode;
			}
			traversenode.nextNode = node;
			node.nextNode = null;
			tail = node;
			size++;
		}

	}

	public int find(T data) { /*
								 * casses: 1)element is the head 2)element is in
								 * the fucking list 3)element is not in the list
								 */
		Node traversenode = head;
		if (traversenode.data == data) {
			System.out.println("Element" + data + "has been found in the list");
			return 1;
		} else {
			while (traversenode.nextNode != null) {
				traversenode = traversenode.nextNode;
				if (traversenode.data == data) {
					System.out.println("Element " + data + " has been found in the list");
					return 1;
				}
			}
		}
		return -1;

	}

	public int getsize() {
		return size;
	}

	public void returnlist() {
		/*
		 * cassses: 1)List empty 2)List not empty
		 */
		if (tail == null && head == null) {
			System.out.println("Nothing to show,the list is empty");
		} else {
			Node traversenode = head;
			System.out.println(traversenode.data);
			while (traversenode.nextNode != null) {
				traversenode = traversenode.nextNode;
				System.out.println(traversenode.data);

			}
		}

	}

	public void remove(T data) {
		/*
		 * casses: 1)remove first element 2)remove an random element 3)remove
		 * the last element
		 */
		if (head.data == data) {
			Node temp=head;
			temp=head.nextNode;
			head.nextNode=null;
			head=temp;
			size--;
		} else if (tail.data == data) {
			Node traversenode2 = head;
			while (traversenode2.nextNode != tail) {
				traversenode2 = traversenode2.nextNode;

			}
			traversenode2.nextNode = null;
			size--;
		}
		  else {
			   Node traversenode3=head;
			 
			   while(  traversenode3.nextNode!=null && traversenode3.nextNode.data!=data)
			   {
				   traversenode3=traversenode3.nextNode;
			   }
			   if(traversenode3.nextNode==null)
			   { System.out.println("element "+ data+" not in the list");}
			   else{
				   Node temp=traversenode3.nextNode;			   
				   traversenode3.nextNode=temp.nextNode;
				   temp.nextNode=null;
				   
				   
				   
			   }
          
		}

	}
}
