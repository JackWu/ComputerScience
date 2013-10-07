package datastructure;

public class LinkedList<E> {
	
	private NodeX<E> head = null;
	private NodeX<E> tail = null;
	private NodeX<E> fieldTemp = null;
	
	private int counter = 0;
	public LinkedList(){}
	public int size(){return counter;}
	
	public void add(E elem){
		
		if(head== null){
			head = tail = new NodeX<E>();
			head.elem = elem;
			head.next=tail;
			tail=head;
		}else{
			tail.next = new NodeX<E>();
			tail = tail.next;
			tail.elem = elem;
		}
		
		counter++;
	}
	
	public NodeX<E> getHead(){
		return head;
	}
	
	public void add(int index, E elem){
		
		if(size() == index){
			add(elem);
			return;			
		}else if(index == 0){
			NodeX<E> localTemp = new NodeX<E>();
			localTemp.elem = elem;
			localTemp.next = head;
			head.previous = localTemp;
			head = localTemp;
			counter++;
			return;
		}
		fieldTemp = head;
		for(int i = 0; i < index-1; i ++){
			if(fieldTemp.next != null){
				fieldTemp = fieldTemp.next;
			}else{
				System.err.println("index is out of bound");
				return;
			}
		}
		
//		Node<E> newNode = new Node<E>();
//		newNode.elem = elem;
//		fieldTemp.next.previous = newNode;
//		newNode.next = fieldTemp.next;
//		newNode.previous = fieldTemp;
//		fieldTemp.next = newNode;
		
		NodeX<E> newNode = new NodeX<E>();
		newNode.elem = elem;
		newNode.next = fieldTemp.next;
		fieldTemp.next = newNode;
		counter++;
		
		
	}
	
	
	public void nthToTheLast(NodeX<E> head, int n){
		NodeX ptr1 = head;
		NodeX ptr2 = head;
		int counter = 1;
		while(ptr1.next != null){
			if(n < 0){
				System.err.println("n cannot be negative");
				break;
			}
			
			if(counter >= n){
				ptr2 = ptr2.next;
			}
			ptr1 = ptr1.next;
			counter++;
		}
		
		System.out.println(ptr1.elem);
		System.out.println(ptr2.elem);
	}
	
	public void deleteNode(NodeX<E> head, NodeX<E> toBeDeleted){
		
		NodeX<E> temp = head;
		if(temp.elem.equals(toBeDeleted)){
		}
		while(temp.next!=null){
		}
		
	}
	
	public void removeDuplicatedWithoutBuffer(NodeX<E> head){
		
		
		NodeX<E> ptr1 = head;
		
		while(head.next!=null){
			
		}
		
	}
	public void print(){
		System.out.print("Test: ");
		NodeX<E> temp = head;
		while(temp!=null){
			System.out.print(" " + temp.elem);
			temp = temp.next;
		}
		
		System.out.println();
	}
	



}
