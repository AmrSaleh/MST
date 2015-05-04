import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimAlgorithm {

	static int insertions = 0;
	static int deletions = 0;
	static int insertions2 = 0;
	public static void run() throws IOException {

		Comparator<Vertix> comparator = new VertixComparator();
		PriorityQueue<Vertix> queueOfVertices = new PriorityQueue<Vertix>(11, comparator);

		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

		int numOfVertices = Integer.parseInt(br.readLine());
		int numOfEdges = Integer.parseInt(br.readLine());

		Vertix[] vertices = new Vertix[numOfVertices + 1];

		for (int i = 1; i <= numOfVertices; i++) {
			vertices[i] = new Vertix();
			vertices[i].number = i;
			vertices[i].group = 2;
			vertices[i].rank = Integer.MAX_VALUE;
			// System.out.println("vertix "+vertices[i].number +
			// " has set = "+vertices[i].subset.parent);
		}

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

			tempEdge = new Edge(vertices[secondNode], vertices[firstNode], edgeWeight);
			tempEdge.key = i;
			vertices[secondNode].edges.add(tempEdge);

		}

		// System.out.println("lowest "+ edgesArray[0].getWeight());

		new ArrayList<Edge>();
		 long startTime = System.currentTimeMillis();
//		System.out.println("num =" + numOfVertices);
		for (int i = 1; i <= numOfVertices; i++) {
			queueOfVertices.add(vertices[i]);
			insertions2++;
		}

		vertices[1].rank = 0;
		vertices[1].group = 1;
		

		// System.out.println(queueOfVertices.remove().rank);
		// System.out.println(queueOfVertices.remove().rank);
		// System.out.println(queueOfVertices.remove().rank);
		// System.out.println(queueOfVertices.remove().rank);
		// System.out.println(queueOfVertices.remove().rank);
		// System.out.println(queueOfVertices.remove().rank);
		// System.out.println(queueOfVertices.remove().rank);
		//

		Vertix tempVertix;
		while (!queueOfVertices.isEmpty()) {
			tempVertix = queueOfVertices.remove();
			deletions++;

			tempVertix.group = 1;
			for (int i = 0; i < tempVertix.edges.size(); i++) {
				if (tempVertix.edges.get(i).getWeight() < tempVertix.edges.get(i).getSecondVertix().rank && tempVertix.edges.get(i).getSecondVertix().group == 2) {
					tempVertix.edges.get(i).getSecondVertix().parentNumber = tempVertix.number;

					tempVertix.edges.get(i).getSecondVertix().rank = tempVertix.edges.get(i).getWeight();
					// System.out.println("afa");
					queueOfVertices.remove(tempVertix.edges.get(i).getSecondVertix());
					queueOfVertices.add(tempVertix.edges.get(i).getSecondVertix());
					
					insertions++;
				}

			}

		}
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		
		Comparator<Edge> comparator2 = new EdgeComparator();
		PriorityQueue<Edge> Edges = new PriorityQueue<Edge>(11, comparator2);

		System.out.println("Resulting Prim’s MST Edges");
		System.out.println("===============================");
		for (int i = 2; i < vertices.length; i++) {

			Edge tempEdge = null;
			for (int j = 0; j < vertices[i].edges.size(); j++) {
				if (vertices[i].edges.get(j).getSecondVertix().number == vertices[i].parentNumber) {
					tempEdge = vertices[i].edges.get(j);
					Edges.add(tempEdge);
				}

			}

			// System.out.println(i + ") " +tempEdge.getFirstVertix().number +
			// ", " +tempEdge.getSecondVertix().number + ", " +
			// tempEdge.getWeight());

		}
		
		int i=0;
	while(!Edges.isEmpty()) {
			 System.out.println(i + ") " +Edges.peek().getFirstVertix().number +
						 ", " +Edges.peek().getSecondVertix().number + ", " +
						 Edges.peek().getWeight());
			 
			 
			 Edges.poll();
			 i++;
		}

		System.out.println();
		System.out.println("Analysis for n Vertices = " + numOfVertices + " and m Edges = " + numOfEdges);
		System.out.println("=============================================");
		// System.out.println("n Vertices = "+numOfVertices+" and m Edges = "+numOfEdges);
		// System.out.println("----------------------------------------------");
		System.out.println("build the priority queue (BUILD-MIN-HEAP procedure) in order O(n)");
		System.out.println("DECREASE-KEY " + insertions + " and EXTRACT MIN " + deletions + " from priority queue of order O(m+n) times");
		System.out.println("the priority queue insertion or deletion costs O(Lg(n)) each");
		// System.out.println("number of operations done updating union find is O(nlg(n)) = "
		// + numOfOperations);
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Final total order is O(m+n)*O(Lg(n)) =  O((m+n)*Lg(n)) = O(m Lg(n)) [For a connected graph, n = O(m)]");
		System.out.println("Algorithm running time = "+totalTime);
	}

}
