package datastructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import datastructure.Vertx;


public class Graph {
	

	
	public void bfs(Vertx root){
		if(root == null){
			return;
			
		}
		

		Queue<Vertx> queue = new LinkedList<Vertx>();
		
		queue.add(root);
		
		while(queue.peek()!=null){
			
			Vertx node = queue.poll();
			
			queue.add(node.left);
			queue.add(node.right);
		}
		
	}
	

}
