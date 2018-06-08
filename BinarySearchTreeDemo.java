package binarytree;

public class BinarySearchTreeDemo {

	public static void main(String[] args) {
		 BinaryTree bt = new BinaryTree(52);  
	     bt.insert(580);  
	     bt.insert(12);  
	     bt.insert(50);  
	     bt.insert(58);  
	     bt.insert(9);  
	     bt.insert(888);  
	     bt.insert(248);  
	     bt.insert(32);  
	     bt.insert(666);  
	     bt.insert(455);  
	     bt.insert(777);  
	     bt.insert(999);  
	     bt.inOrderTraverse(bt.root);
	     System.out.println(bt.insert(666));
	     System.out.println(bt.delete(999));
	     
	}

}
