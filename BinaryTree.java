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
	}  //����
	
	public void inOrderTraverse(Node node) {
		if (node == null) {
			return ;
		}     
	    inOrderTraverse(node.leftchild);  
	    node.display();  
	    inOrderTraverse(node.rightchild);  
	}    //��������ݹ����  
	public void inOrderByStack() {}     //��������ǵݹ����      
    public void preOrderTraverse(Node node) {
    	if(node == null) {
    		return ;
    	}
    	node.display();
    	preOrderTraverse(node.leftchild);
    	preOrderTraverse(node.rightchild);
    	
    }  //ǰ�����  
    public void preOrderByStack() {}   //ǰ������ǵݹ����  
    public void postOrderTraverse(Node node) {
    	if(node == null) {
    		return;
    	}
    	postOrderTraverse(node.rightchild);
    	node.display();
    	postOrderTraverse(node.leftchild);
    } //�������  
    public void postOrderByStack() {}  //��������ǵݹ����  
    public int getMinValue() {
    	Node current = root;
    	while(true) {
    		if(current.leftchild != null) {
    			current = current.leftchild;
    		}else {
    			return current.value;
    		}
    	}
	} //�õ���С(��)ֵ  
    public int getMaxValue() {
    	Node current = root;
    	while(true) {
    		if(current.rightchild != null) {
    			current = current.rightchild;
    		}else {
    			return current.value;
    		}
    	}
	} //�õ���С(��)ֵ  
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
                } else { //�����Ҷ�ڵ��Ǹ��ڵ�����ӽڵ㣬�����ڵ�����ӽڵ���Ϊnull  
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
                //����ýڵ��Ǹ��ڵ�����ӽڵ㣬���ýڵ�����ӽڵ��Ϊ���ڵ�����ӽڵ�  
                if (isLeftChild) {  
                    parent.leftchild = current.leftchild;  
                } else {  //����ýڵ��Ǹ��ڵ�����ӽڵ㣬���ýڵ�����ӽڵ��Ϊ���ڵ�����ӽڵ�  
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
                //����ýڵ��Ǹ��ڵ�����ӽڵ㣬���ýڵ�����ӽڵ��Ϊ���ڵ�����ӽڵ�  
                if (isLeftChild) {  
                    parent.leftchild = current.rightchild;  
                } else {  //����ýڵ��Ǹ��ڵ�����ӽڵ㣬���ýڵ�����ӽڵ��Ϊ���ڵ�����ӽڵ�  
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
                    } else {  //����ýڵ��Ǹ��ڵ�����ӽڵ㣬���ýڵ�����ӽڵ��Ϊ���ڵ�����ӽڵ�  
                        parent.rightchild = target;  
                    }
        			break;
        		}
        	}
        	return true;
    	}   	
	} //ɾ�� 

}
