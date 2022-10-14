package Graph;

import java.util.Iterator;

public interface VertexInterface<T> {

	/**
	 * Gets this vertex label
	 * 
	 * @return	The objekt that labels the vertex
	 */
	T getLabel();
	
	/**
	 * Removes visited mark
	 */
	void unVisit();
	
	/**
	 * Marks this vertex as visited
	 */
	void visit();
	
	/**
	 * Sees whether this vertex is marked as visited.
	 * 
	 * @return	True if the vertex is visited, false if else
	 */
	boolean isVisited();
	
	/**
	 * Connects this vertex with another with an weighted edge. 
	 * The two vertices cannot be the same, and must not already
	 * have this edge between them. In a directed graph the edge
	 * points toward the given vertex.
	 * 
	 * @param endVertex	that ends the edge
	 * @param edgeWeight	weight to the edge
	 * @return	true if added, false if not
	 */
	boolean connect(VertexInterface<T> endVertex, double edgeWeight);
	
	/**
	 * Connects this vertex with another with an unweighted edge. 
	 * The two vertices cannot be the same, and must not already
	 * have this edge between them. In a directed graph the edge
	 * points toward the given vertex.
	 * 
	 * @param endVertex	
	 * @return	true if added, false if not
	 */
	boolean connect(VertexInterface<T> endVertex);
	
	/**
	 * Creates an iterator of this vertex neighbors by following
	 * all edges that begin this vertex
	 * 
	 * @return	An iterator of the neightboring vertices
	 */
	Iterator<VertexInterface<T>> getNeighborIterator();
	
	/**
	 * Creates an iterator of the weights of the edges to this
	 * vertex neighbors.
	 * 
	 * @return	An iterator of edge weights for edges to neighbors of this vertex.
	 */
	Iterator<Double> getWeightIterator();
	
	/**
	 * @return	True if the vertex has a neighbor
	 */
	boolean hasNeightbor();
	
	/**
	 * Gets an unvisited neighbor, if any, of this vertex
	 * 
	 * @return	vertex that is an unvisited neighbor or null
	 */
	VertexInterface<T> getUnvisitedNeighbor();
	
	/**
	 * Records the previous vertex on a path to this vertex.
	 * 
	 * @param predecessor	The vertex previous to this one along the path
	 */
	void setPredecessor(VertexInterface<T> predecessor);
	
	/** 
	 * @return	The recorded Predecessor of this vertex.
	 */
	VertexInterface<T> getPredecessor();
	
	/**
	 * @return	True if a predecessor was recorded
	 */
	boolean hasPredecessor();
	
	/**
	 * Records the cost of a path to this vertex.
	 * 
	 * @param newCost	the cost of the path.
	 */
	void setCost(double newCost);
	
	/**
	 * @return	the cost of this vertex path. 
	 */
	double getCost();
	
}
