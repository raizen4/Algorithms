package java_BST_implementation;

public class BST {
	Node root;
	int size;
	private static int min=33333;

	private class Node {
		private int data;
		private Node leftc;
		private Node rightc;
		private Node parent;

		public Node(int data) {
			this.data = data;

		}
	}

	public BST() {
		this.root = null;
		this.size = size;
	}

	public void add(int data) {/*
								 * casses: 1)node to add is the root 2)node to
								 * add is not the root
								 */
		Node nodetoadd = new Node(data);
		if (root == null) {
			root = nodetoadd;
			root.leftc = null;
			root.rightc = null;
			root.parent = null;
		} else {
			insert(root, nodetoadd);

		}
	}

	private void insert(Node root, Node node) {

		if (root.leftc == null && root.data > node.data) {
			root.leftc = node;
			node.parent = root;
			size++;
		} else if (root.rightc == null && root.data < node.data) {
			root.rightc = node;
			node.parent = root;
			size++;
		} else {
			if (node.data > root.data) {
				insert(root.rightc, node);
			} else if (node.data < root.data) {
				insert(root.leftc, node);
			}
		}

	}

	private void inordertraversal(Node root) { // using in_order_traversal
												// method;
		if (root != null) {
			inordertraversal(root.leftc);
			System.out.println(root.data);
			if (root.parent == null) {
				System.out.println("this is the root of the tree");

			} else {
				boolean left = false;
				boolean right = false;
				if (root.parent.leftc != null && root.parent.rightc != null) {
					left = (root.parent.leftc.data == root.data);
					right = (root.parent.rightc.data == root.data);
				} else if (root.parent.leftc == null) {
					left = false;
					right = (root.parent.rightc.data == root.data);
				} else if (root.parent.rightc == null) {
					left = (root.parent.leftc.data == root.data);
					right = false;
				} else if (root.parent.leftc == null && root.parent.rightc == null) {
					left = false;
					right = false;
				}

				if (left == true) {
					System.out.println("this node has parent " + root.parent.data + " and it is its left child");
				} else if (right == true) {
					System.out.println("this node has parent " + root.parent.data + " and it is its right child");
				} else if (right == false && left == false) {
					System.out.println("this is a leaf");
				}

			}
			inordertraversal(root.rightc);
		}

	}

	public void showTree() {
		inordertraversal(root);
	}

	public int getSize() {
		return size;
	}

	public void search_value(int data) {

		Node traversenode = new Node(data);
		Node found = find(root, traversenode);
		if (found != null) {
			System.out.println("The element " + found.data + " has been found in the tree");
		} else {
			System.out.println("Element " + found.data + " not found");
		}
	}

	private Node find(Node root, Node nodetofind) {
		/*
		 * casses: 1)node is the root 2)node is somewhere in the tree 3)node is
		 * not in the tree
		 */
		if (root == null) {
			return null;
		} else if (root.data == nodetofind.data) {
			return root;
		} else {
			if (nodetofind.data > root.data) {
				return find(root.rightc, nodetofind);
			} else if (nodetofind.data < root.data) {
				return find(root.leftc, nodetofind);
			}
		}
		return null;
	}

	public void remove(int data)
	{
		/*casses:
		 * 1)data to be removed is the root
		 * 2)Data to be deleted is in the tree(it can have 1 or two childs or no childs(it is a leaf))
		 * 3)data to be deleted is not in the tree
		 */
		Node nodetoremove=new Node(data);
		Node found=find(root,nodetoremove);
		if (found!=null)
		{ //checking if the nodetoremove is a leaf(it doesn t have childs)
		  if (found.leftc==null && found.rightc==null)
		  {
			  boolean isRight=false;
			  boolean isLeft=false;
			  if(found.parent.leftc !=null && found.parent.leftc.data==found.data)
			  {
				  isLeft=true;
			  }
			  else{
				  isRight=true;
			  }
			  if (isRight==true)
			  {   System.out.println("element"+ found.data+" has been deleted");
				 found.parent.rightc=null;
				  
			  }
			  else{
				  System.out.println("element"+ found.data+" has been deleted");
				  found.parent.leftc=null;
			  }
		  }
		  else if((found.leftc !=null && found.rightc==null) || (found.leftc ==null && found.rightc!=null))
		  {  //checking to see what child the nodetoremove has so we can link the parent of the node
			 // to remove to it
             Node isRight=found.rightc;
             if (isRight!=null)
             { //checking on which side the nodetoremove is for the parent              
                 if(found.parent.leftc!= null && found.parent.leftc.data==found.data){
                	 found.parent.leftc=found.rightc;
                	 found.rightc.parent=found.parent;
                	 found.rightc=null;
                 }
                 else if(found.parent.rightc!=null && found.parent.rightc.data==found.data){
                	 found.parent.rightc=found.rightc;//found.left
                	 found.rightc.parent=found.parent;               	
                	 found.rightc=null;//found.left
                 }
             }
              else{
                	 if(found.parent.leftc!= null && found.parent.leftc.data==found.data){
                    	 found.parent.leftc=found.leftc;
                    	 found.leftc.parent=found.parent;
                    	 found.leftc=null;
                     }
                     else if(found.parent.rightc!=null && found.parent.rightc.data==found.data){
                    	 found.parent.rightc=found.leftc;
                    	 found.leftc.parent=found.parent;
                    	 found.leftc=null;
                 }
                 
                 }
            	 
             }
		  else if ((found.leftc !=null && found.rightc!=null))
			{   System.out.println("da");
				int minvaluefound=findmin(found.rightc);
				remove(minvaluefound);
				found.data=minvaluefound;
			}
             
             }
		
		else{
			System.out.println("element to be deleted not found");
		}
		
	}
	private int findmin(Node root)
	{
	if (root==null)
	{
		return min;
	}
	if (root.data<min)
	{
		min=root.data;
	}
	   return findmin(root.leftc);
		
	}
	
}

