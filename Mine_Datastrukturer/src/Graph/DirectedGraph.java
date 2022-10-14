package Graph;

import DictionaryADT.DictionaryADTInterface;
import QueueADT.QueueADTInterface;
import StackADT.StackADTInterface;

public class DirectedGraph<T> implements GraphADTInterface<T> {

	private DictionaryADTInterface<T, VertexInterface<T>> vertices;
	private int edgeCount;
	
	
	public DirectedGraph() {
		verticles = new LinkedDictionary();
		count = 0;
	}

	@Override
	public boolean addNewVertex(T vertexLabel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addNewEdge(T begin, T end, double edgeWeight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEdge(T begin, T end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasEdge(T begin, T end) {
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
	public boolean hasVertex(T vertex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public QueueADTInterface<T> getBreathFirstTraversal(T orgin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueueADTInterface<T> getDepthFirstTraversal(T orgin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StackADTInterface<T> getTopologicalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getShortestPath(T begin, T end, StackADTInterface<T> path) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCheapestPath(T begin, T end, StackADTInterface<T> path) {
		// TODO Auto-generated method stub
		return 0;
	}

}
