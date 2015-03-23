import java.util.TreeSet;


public class TestTreeSet {
	public static void main(String[] args) {
		//new a obj of TreeSet
		TreeSet<Err> ts = new TreeSet<Err>();
		ts.add(new Err());
		ts.add(new Err());//as you see, we must implements interface of Comparable
	}

}

class Err implements Comparable<Err> {

	@Override
	public int compareTo(Err o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
