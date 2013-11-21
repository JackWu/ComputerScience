package leetcode;

import java.util.HashMap;

public class LRUCache {
	
	private int capacity;
	
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	
	private Node head = new Node(-1, -1);
	private Node tail = new Node(-2, -2);
	
	public LRUCache(int capacity){
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}
	
	public int get(int key){
		if(!map.containsKey(key))
			return -1;
		
		Node cur = map.get(key);
		cur.prev.next = cur.next;
		cur.next.prev = cur.prev;
		attach(cur);
		
		return cur.value;
		
		
	}
	
	public void set(int key, int value){
		if(map.containsKey(key)){
			Node cur = map.get(key);
			cur.value = value;
			cur.prev.next = cur.next;
			cur.next.prev = cur.prev;
			attach(cur);
		}else{
			if(map.size() == capacity)
				dettach();
			Node cur = new Node(key, value);
			attach(cur);
			map.put(key, cur);
		}
		
	}
	
	
	private void attach(Node cur){
		cur.next = head.next;
		cur.next.prev = cur;
		cur.prev = head;
		head.next = cur;
	}
	
	private void dettach(){
		Node last = tail.prev;
		last.prev.next = last.next;
		last.next.prev = last.prev;
		
		map.remove(last.key);
	}
	
	
	
	
	
	
	
	
	private class Node{
		int key;
		int value;
		Node next = null;
		Node prev = null;
		
		Node(int key, int value){
			this.key = key;
			this.value = value;
		}
	}

}
