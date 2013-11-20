package leetcode;

import java.util.HashMap;

public class LRUCache {
	
	private int capacity;
	private int size;
	private Node head;
	private Node current = head;
	
	private HashMap<Integer, Node> cacheRoom;
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        cacheRoom = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
    	
    	if(cacheRoom.containsKey(key)){
    		Node temp = cacheRoom.get(key);
    		if(temp.next!=null&&temp.previous!=null){
    			temp.previous.next = temp.next;
    			temp.previous = null;
    			temp.next = head;
    			head = temp;
    		}else if(temp.previous!=null && temp.next == null){
    			
    			temp.previous.next = null;
    			temp.next = head;
    			temp.previous = null;
    			head = temp;
    		}
    		return cacheRoom.get(key).value;
    	}else{
    		return -1;
    	}
    	
        
    }
    
    public void set(int key, int value) {
        if(size>=capacity){
        	removeOldest();
        	addElement(key, value);
        	
        }else{
        	
        	addElement(key,value);
        	
        }
    }
    
    private void removeOldest(){
    	
    	int key = current.key;
    	cacheRoom.remove(key);
    	
    	if(current.previous!=null&&current.next==null){
    		current = current.previous;
    		current.next = null;
    	}else{
    		current = null;
    	}
    	size--;
    	
    }
    private void addElement(int key, int value){

    	if(!cacheRoom.containsKey(key)){

    		size++;
    		Node temp = addToDoublyLinkedList(key, value);
        	cacheRoom.put(key, temp);
    	}else{
    		

        	cacheRoom.get(key).value= value;
    		
    	}
    	
    	
    }
    
    private Node addToDoublyLinkedList(int key, int value){
    	Node newNode = new Node(key, value);
    	if(head==null){
    		head = newNode;
    		current = newNode;
    	}else{
    		newNode.next = null;
    		newNode.previous = current;
    		current.next = newNode;
    		current = current.next;
    		
    	}
    	
    	return newNode;
    }
    
    
    class Node{
    	int key;
    	int value;
    	Node previous;
    	Node next;
    	Node(int key, int value){
    		this.key = key;
    		this.value = value;
    	}
    }

}
