


public class Edge {

	private Vertix firstVertix;
	private Vertix secondVertix;
	private int weight;
	
	int key;
//	boolean visited =false;
	
	public Edge(Vertix first,Vertix second, int edgeWeight){
		firstVertix = first;
		secondVertix = second;
		weight= edgeWeight;
	}
	
	
	public Edge() {
		// TODO Auto-generated constructor stub
	}


	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}


	public Vertix getFirstVertix() {
		return firstVertix;
	}


	public void setFirstVertix(Vertix firstVertix) {
		this.firstVertix = firstVertix;
	}


	public Vertix getSecondVertix() {
		return secondVertix;
	}


	public void setSecondVertix(Vertix secondVertix) {
		this.secondVertix = secondVertix;
	}


	

	
}
