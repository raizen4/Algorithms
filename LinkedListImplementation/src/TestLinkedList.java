
public class TestLinkedList {

	public static void test1() 
	{
		MyLinkedList<Integer> list=new MyLinkedList<>();
		list.add(4);
		list.add(5);
		list.add(1);
		System.out.println(list.size);
		list.returnlist();
		System.out.println("------------------finished test 1------------------");
	}
	
	public static void test2(){
		MyLinkedList<Integer> list=new MyLinkedList<>();
		list.add(4);
		list.add(5);
		list.add(1);
		list.remove(5);
		list.add(10);
		list.returnlist();
		System.out.println("------------------finished test 2------------------");
	}
	public static void test3(){
		MyLinkedList<Integer> list=new MyLinkedList<>();
		list.add(4);
		list.add(2);
		list.add(1);
		list.remove(5);
		list.remove(1);
		list.add(10);
		list.remove(10);
		list.returnlist();
		System.out.println("------------------finished test 3------------------");
	}
	public static void test4(){
		MyLinkedList<String> list=new MyLinkedList<>();
		list.add("I");
		list.add("Am" );
		list.add("a");
		list.add("BAD");
		list.add("Good");
		list.add("Programmer");
		list.remove("BAD");
		list.returnlist();
		System.out.println("------------------finished test 4------------------");
		
	}
	public static void main(String[] args){
		test1();
		test2();
		test3();
		test4();
	}

}
