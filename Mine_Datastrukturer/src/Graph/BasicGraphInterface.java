package Graph;

public interface BasicGraphInterface<T> {
	
	
	/**
	 * @param s, new element to be added
	 * @return true if added, false if not
	 */
	boolean addNewVertex(T vertexLabel);
	
	/**
	 * Adds a weighted edge between two given distinct vertices that are
	 * currently int the graph. The desired edge must not be in the graph.
	 * In a directed graph, the edge points toward the second vertex given.
	 * 
	 * @param begin, the vertex that the edge goes from
	 * @param end, the vertex that the edge goes to
	 * @param edgeWeight, the weight of the edge
	 * @return	True if added, false if not
	 */
	boolean addNewEdge(T begin, T end, double edgeWeight);
	
	/**
	 * Adds a unweighted edge between two vertices that are currently in
	 * the graph. The desired edge cannot allready be in the graph. 
	 * 
	 * @param begin, vertex to start
	 * @param end, vertex to end
	 * @return true if added, false if not
	 */
	boolean addEdge(T begin, T end);
	
	/**
	 * Sees whether an edge exists between two vertices.
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	boolean hasEdge(T begin, T end);
	
	/**
	 * @return true if empty, false if else
	 */
	boolean isEmpty();
	
	/**
	 * @return number of vertices
	 */
	int getNumberOfVertices();
	
	/**
	 * @return number of edges in the graph
	 */
	int getNumberOfEdges();
	
	/**
	 * @return Number of Vertex
	 */
	boolean hasVertex(T vertex);
	
	/**
	 * clears the whole graph
	 */
	void clear();
	
	/**
	 * @return String representation
	 */
	String toString();
	
	
	
	

}
