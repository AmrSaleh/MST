import java.lang.reflect.Array;
import java.util.LinkedList;


public class Graph {

	private LinkedList<Edge>[] adjacencyList;
	
	
	@SuppressWarnings("unchecked")
	public Graph(int numOfVertices) {
	
		setAdjacencyList((LinkedList<Edge>[]) Array.newInstance(new LinkedList<Edge>().getClass(), numOfVertices));
		for (int i = 0; i < adjacencyList.length; i++) {
		
		}
		
	}
	
	
	public void addEdge(int vertixNum , Edge newEdge){
		
		adjacencyList[vertixNum].add(newEdge);
	}


	public LinkedList<Edge>[] getAdjacencyList() {
		return adjacencyList;
	}


	public void setAdjacencyList(LinkedList<Edge>[] adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
}
