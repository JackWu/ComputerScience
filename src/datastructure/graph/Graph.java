package datastructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import datastructure.VertexState;
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
	
	public void dfs(){
		int vertexCount = 20;
		VertexState state[] = new VertexState[vertexCount];
		for(int i = 0; i < vertexCount; i++){
			state[i] = VertexState.WHITE;
			runDFS(0, state);
		}
	}
	
	public void runDFS(int u, VertexState[] state){
		state[u] = VertexState.GRAY;
		
//		for(int v = 0; v < vertexCount; v++){
//			if(isEdge(u,v)&&state[v]==VertexState.WHITE)
//				runDFS(V, )
//		}
		
	}
	
	

}
