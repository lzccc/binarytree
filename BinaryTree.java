package binarytree;

public class BinaryTree {
	public Node root = null;
	BinaryTree(int value){
		root = new Node(value);
		root.leftchild = null;
		root.rightchild = null;
	}
	
	public Node searchKey(int value) {
		Node current = root;
		while(true) {
			if(current.value == value) {
				return current;
			}else if(current.value < value) {
				current = current.rightchild;
			}else {
				current = current.leftchild;
			}
			if(current == null) {
				return null;
			}
		}
	}
	
	public String insert(int value) {
		if (root == null) {  
		    root = new Node(value);  
		    root.leftchild  = null;  
		    root.rightchild = null;  
		    return null;
		}
		Node current = root;
		if(current.value == value) {
			return "Already exist!";
		}
		while(true) {
			Node parent = current;
			if(current.value == value) {
				return "Already exist!";
			}
			if(current.value > value) {
				current = current.leftchild;
				if(current == null) {
					parent.leftchild = new Node(value);
					return null;
				}
			}else if(current.value < value) {
				current = current.rightchild;
				if(current == null) {
					parent.rightchild = new Node(value);
					return null;
				}
			}
		}
	}  //插入
	
	public void inOrderTraverse(Node node) {
		if (node == null) {
			return ;
		}     
	    inOrderTraverse(node.leftchild);  
	    node.display();  
	    inOrderTraverse(node.rightchild);  
	}    //中序遍历递归操作  
	public void inOrderByStack() {}     //中序遍历非递归操作      
    public void preOrderTraverse(Node node) {
    	if(node == null) {
    		return ;
    	}
    	node.display();
    	preOrderTraverse(node.leftchild);
    	preOrderTraverse(node.rightchild);
    	
    }  //前序遍历  
    public void preOrderByStack() {}   //前序遍历非递归操作  
    public void postOrderTraverse(Node node) {
    	if(node == null) {
    		return;
    	}
    	postOrderTraverse(node.rightchild);
    	node.display();
    	postOrderTraverse(node.leftchild);
    } //后序遍历  
    public void postOrderByStack() {}  //后序遍历非递归操作  
    public int getMinValue() {
    	Node current = root;
    	while(true) {
    		if(current.leftchild != null) {
    			current = current.leftchild;
    		}else {
    			return current.value;
    		}
    	}
	} //得到最小(大)值  
    public int getMaxValue() {
    	Node current = root;
    	while(true) {
    		if(current.rightchild != null) {
    			current = current.rightchild;
    		}else {
    			return current.value;
    		}
    	}
	} //得到最小(大)值  
    public boolean delete(int value) {
    	Node current = root;
    	Node parent = null;
    	Boolean isLeftChild = false;
    	
    	while(true) {
    		if(current.value == value) {
    			break;
    		}
    		if(current.value > value) {
    			parent = current;
    			current = current.leftchild;
    			isLeftChild = true;
    		}else {
    			parent = current;
    			current = current.rightchild;
    			isLeftChild = false;
    		}
    		if (current == null) {
    			return false;
    		}
    	}
    	
    	if (current.leftchild == null && current.rightchild == null) {
    		if(current == root) {
    			root = null;
    		}else {
    			if (isLeftChild) {  
                    parent.leftchild  = null;  
                } else { //如果该叶节点是父节点的右子节点，将父节点的右子节点置为null  
                    parent.rightchild = null;  
                }  
    		}
    		return true;
    	}
    	else if(current.rightchild == null) {
    		if (current == root) {  
                root = current.leftchild;  
            }
    		else {  
                //如果该节点是父节点的左子节点，将该节点的左子节点变为父节点的左子节点  
                if (isLeftChild) {  
                    parent.leftchild = current.leftchild;  
                } else {  //如果该节点是父节点的右子节点，将该节点的左子节点变为父节点的右子节点  
                    parent.rightchild = current.leftchild;  
                }
    		}
    		return true;
    	}
    	else if(current.leftchild == null) {
    		if (current == root) {  
                root = current.rightchild;  
            }
    		else {  
                //如果该节点是父节点的左子节点，将该节点的左子节点变为父节点的左子节点  
                if (isLeftChild) {  
                    parent.leftchild = current.rightchild;  
                } else {  //如果该节点是父节点的右子节点，将该节点的左子节点变为父节点的右子节点  
                    parent.rightchild = current.rightchild;  
                }
    		}
    		return true;
    	}
    	else {
    		Node target = current.leftchild;
        	while(true) {
        		if(target.rightchild != null) {
        			target = target.rightchild;
        		}else {
        			delete(target.value);
        			if (isLeftChild) {  
                        parent.leftchild = target;  
                    } else {  //如果该节点是父节点的右子节点，将该节点的左子节点变为父节点的右子节点  
                        parent.rightchild = target;  
                    }
        			break;
        		}
        	}
        	return true;
    	}   	
	} //删除 

}
