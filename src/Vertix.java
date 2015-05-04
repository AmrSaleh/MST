import java.util.LinkedList;


public class Vertix {
	
	int number;
	Subset subset;

	
	int group;
	int rank=Integer.MAX_VALUE;
	int parentNumber=-1;
	LinkedList<Edge> edges = new LinkedList<Edge>();
}
