import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimVariationAlgorithm {

	static int insertions = 0;
	static int deletions = 0;

	public static void run() throws IOException {

		Comparator<Edge> comparator = new EdgeComparator();
		PriorityQueue<Edge> Edges = new PriorityQueue<Edge>(11, comparator);

		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

		int numOfVertices = Integer.parseInt(br.readLine());
		int numOfEdges = Integer.parseInt(br.readLine());

		Vertix[] vertices = new Vertix[numOfVertices + 1];

		for (int i = 1; i <= numOfVertices; i++) {
			vertices[i] = new Vertix();
			vertices[i].number = i;
			vertices[i].group = 2;

			// System.out.println("vertix "+vertices[i].number +
			// " has set = "+vertices[i].subset.parent);
		}

		 boolean[] edgesVisited = new boolean[numOfEdges];

		int firstNode, secondNode, edgeWeight;

		for (int i = 0; i < numOfEdges; i++) {
			String[] tokens = br.readLine().split(",");

			firstNode = Integer.parseInt(tokens[0]);
			edgeWeight = Integer.parseInt(tokens[2]);
			secondNode = Integer.parseInt(tokens[1]);

			// System.out.println("Hey I got "+firstNode +" "+secondNode
			// +" "+edgeWeight);

			Edge tempEdge = new Edge(vertices[firstNode], vertices[secondNode], edgeWeight);
			tempEdge.key = i;
			vertices[firstNode].edges.add(tempEdge);
			
			 tempEdge = new Edge( vertices[secondNode], vertices[firstNode], edgeWeight);
			tempEdge.key = i;
			vertices[secondNode].edges.add(tempEdge);

		}

		

		// System.out.println("lowest "+ edgesArray[0].getWeight());

		ArrayList<Edge> MST = new ArrayList<Edge>();
		
		int verticesAdded = 0;
		vertices[1].group=1;
		for (int i = 0; i < vertices[1].edges.size(); i++) {
			if ( vertices[1].edges.get(i).getSecondVertix().group==2 && edgesVisited[ vertices[1].edges.get(i).key]==false) {
				 edgesVisited[ vertices[1].edges.get(i).key]=true;
				
				Edges.add(vertices[1].edges.get(i));
				insertions++;
			}
			
		}
		
		verticesAdded=1;
		Edge tempEdge;
		while (verticesAdded<numOfVertices ) {
			tempEdge=Edges.remove();
			deletions++;
			if ( tempEdge.getSecondVertix().group==2 ) {
				System.out.println("picked "+tempEdge.getFirstVertix().number +", "+tempEdge.getSecondVertix().number +", "+tempEdge.getWeight());
				MST.add(tempEdge); 
//				edgesVisited[ tempEdge.key]=true;
				 tempEdge.getSecondVertix().group=1;
				 verticesAdded++;
				
				for (int i = 0; i < tempEdge.getSecondVertix().edges.size(); i++) {
					if ( tempEdge.getSecondVertix().edges.get(i).getSecondVertix().group==2 && edgesVisited[tempEdge.getSecondVertix().edges.get(i).key]==false) {
						 edgesVisited[tempEdge.getSecondVertix().edges.get(i).key]=true;
						
						Edges.add(tempEdge.getSecondVertix().edges.get(i));
						insertions++;
					}

				}
			}else{
				System.out.println("****passed "+tempEdge.getFirstVertix().number +", "+tempEdge.getSecondVertix().number +", "+tempEdge.getWeight());
			}
			
		}
		
		System.out.println("Resulting Prim’s variation MST Edges");
		for (int i = 0; i < MST.size(); i++) {
			System.out.println(i + ") " + MST.get(i).getFirstVertix().number + ", " + MST.get(i).getSecondVertix().number + ", " + MST.get(i).getWeight());
		}

		System.out.println();
		System.out.println("Analysis for n Vertices = " + numOfVertices + " and m Edges = " + numOfEdges);
		System.out.println("=============================================");
		// System.out.println("n Vertices = "+numOfVertices+" and m Edges = "+numOfEdges);
		// System.out.println("----------------------------------------------");
		System.out.println("insertions "+insertions+" and deletions "+deletions+" from priority queue of order O(m+m) times");
		System.out.println("the priority queue insertion or deletion costs O(Lg(m)) each");
//		System.out.println("number of operations done updating union find is O(nlg(n)) = " + numOfOperations);
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Final total order is O(m+m)*O(Lg(m)) =  O((m+m)*Lg(m)) = O(m Lg(m)) [For a connected graph, n = O(m)]");
	}

	
}
