import java.util.Comparator;


public class VertixComparator implements Comparator<Vertix> {

	@Override
	public int compare(Vertix arg0, Vertix arg1) {
		// TODO Auto-generated method stub
		return arg0.rank - arg1.rank;
	}

}
