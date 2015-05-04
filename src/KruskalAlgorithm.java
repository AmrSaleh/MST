import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class KruskalAlgorithm {

static int numOfOperations=0;
static int cycleChecks =0;
	public static void run() throws IOException {

		Comparator<Edge> comparator = new EdgeComparator();		

	        @SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
	       
	        int numOfVertices =   Integer.parseInt(br.readLine());
	        int numOfEdges = Integer.parseInt(br.readLine());
	        
	        Vertix[] vertices = new Vertix[numOfVertices+1];

	        
	        for (int i = 1; i <= numOfVertices; i++) {
				vertices[i] = new Vertix();
				vertices[i].number=i;
				vertices[i].subset= new Subset();
				vertices[i].subset.parent=i;
				vertices[i].subset.rank=1;
				vertices[i].subset.children.add(vertices[i]);
				
//				System.out.println("vertix "+vertices[i].number + " has set = "+vertices[i].subset.parent);
			}
	        
	      
	        
	        
	        Edge[] edgesArray = new Edge[numOfEdges];
	        int firstNode , secondNode,  edgeWeight;
	        for (int i = 0; i < numOfEdges; i++) {
				String[] tokens = br.readLine().split(",");
				
				firstNode = Integer.parseInt(tokens[0]);
				edgeWeight = Integer.parseInt(tokens[2]);
				secondNode = Integer.parseInt(tokens[1]);
				
//				System.out.println("Hey I got "+firstNode +" "+secondNode +" "+edgeWeight);
				
				
				edgesArray[i] = new Edge( vertices[firstNode], vertices[secondNode],edgeWeight);
				
			}
	      
	        long startTime = System.currentTimeMillis();
		Arrays.sort(edgesArray, comparator);
		
//		System.out.println("lowest "+ edgesArray[0].getWeight());
		
		
	    ArrayList<Edge> MST = new ArrayList<Edge>();
		
		for (int i = 0; i < edgesArray.length; i++) {
			
			if(mergeSubsets(edgesArray[i].getFirstVertix(),edgesArray[i].getSecondVertix())){
				MST.add(edgesArray[i]);
			}
			
			
		}
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		
		System.out.println("Resulting Kruskal’s MST Edges");
		System.out.println("===============================");
		for (int i = 0; i < MST.size(); i++) {
			System.out.println( i+") "+MST.get(i).getFirstVertix().number+", "+MST.get(i).getSecondVertix().number+", "+MST.get(i).getWeight());
		}
		
		System.out.println();
		System.out.println("Analysis for n Vertices = "+numOfVertices+" and m Edges = "+numOfEdges);
		System.out.println("=============================================");
//		System.out.println("n Vertices = "+numOfVertices+" and m Edges = "+numOfEdges);
//		System.out.println("----------------------------------------------");
		System.out.println("sort of edges in O(m lg(n))");
		System.out.println("number of cycle checks is O(m) = "+cycleChecks);
		System.out.println("number of operations done updating union find is O(nlg(n)) = " +numOfOperations);
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Final total order is O(m lg(n))");
		System.out.println("Algorithm running time = "+totalTime);
	}
	
	
	static boolean  mergeSubsets(Vertix first,Vertix second){
		cycleChecks++;
		// TODO 
		if(first.subset.parent== second.subset.parent){
		
		return false;
		}
				
		Subset firstSubset = first.subset;
		Subset secondSubset = second.subset;
		if(firstSubset.rank<secondSubset.rank){
		secondSubset.rank+=firstSubset.rank;
		
			for (int i = 0; i < firstSubset.children.size(); i++) {
				firstSubset.children.get(i).subset=secondSubset;
				secondSubset.children.add(firstSubset.children.get(i));
				numOfOperations++;
			}
		}else{
			firstSubset.rank+=secondSubset.rank;
			for (int i = 0; i < secondSubset.children.size(); i++) {
				
				secondSubset.children.get(i).subset=firstSubset;
				firstSubset.children.add(secondSubset.children.get(i));
				numOfOperations++;
			}
		}
		
		return true;
	}
}
