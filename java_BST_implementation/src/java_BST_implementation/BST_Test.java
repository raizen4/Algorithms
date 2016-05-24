package java_BST_implementation;

public class BST_Test {
	public static void main(String[] args){
		BST tree=new BST();
		tree.add(5);
		tree.add(19);
		tree.add(-2);
        tree.add(-4);
        tree.add(10);
        tree.add(-8);
        tree.add(-7);
        tree.add(-10);
        tree.add(-3);
       tree.add(3);
       tree.add(0);
       tree.add(4);
       tree.remove(-2);
        tree.showTree();
	}

}
