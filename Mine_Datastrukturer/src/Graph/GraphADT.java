package Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphADT<T extends Comparable<? super T>> implements BasicGraphInterface {

	private Map<T, List<T>> map;
	private int numElements;
	
	
	public GraphADT() {
		map = new HashMap<>();
		numElements = 0;
	}
	
	@Override
	public boolean addNewVertex(Object vertexLabel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addNewEdge(Object begin, Object end, double edgeWeight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEdge(Object begin, Object end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasEdge(Object begin, Object end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNumberOfVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfEdges() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasVertex(Object vertex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}


}
