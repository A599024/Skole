package Graph;

import QueueADT.QueueADTInterface;
import StackADT.StackADTInterface;

public interface GraphAlgorithmsInterface<T> {

	/**
	 * Performs a breadth-first traversal trough the graph.
	 * 
	 * @param orgin vertex of the traversal
	 * @return A queue of the traversal, with the orgin vertex at front, and so on
	 */
	QueueADTInterface<T> getBreathFirstTraversal(T orgin);
	
	/**
	 * Performs a depth-first traversal trough the graph.
	 * 
	 * @param orgin vertex of the traversal
	 * @return A queue of the traversal, with the orgin vertex at front, and so on
	 */
	QueueADTInterface<T> getDepthFirstTraversal(T orgin);
	
	/**
	 * Performs a topological sort of the vertices in a graph without cycles.
	 * 
	 * @return	a stack of vertex labels in topological order, beginning with the stacks top.
	 */
	StackADTInterface<T> getTopologicalOrder();
	
	/**
	 * Finds the path between two given vertices that has the shortest length.
	 * 
	 * @param begin	An object that labels the paths origin vertex
	 * @param end	An object that labels the paths destination vertex
	 * @param path	A stack of labels that is empty initially;
	 * 				at the completion of this method this stack contains
	 * 				the labels of the vertices along the shortest path;
	 * 				the label of the origin vertex is at the top, and
	 * 				the label of the destination vertex is at the bottom.
	 * 
	 * @return	the length of the shortest path.
	 */
	int getShortestPath(T begin, T end, StackADTInterface<T> path);
	
	/**
	 * Finds the least-cost path between two given vertices.
	 * 
	 * @param begin	An object that labels the paths origin vertex.
	 * @param end	An objekt that labels the paths destination vertex.
	 * @param path	A stack of labels that is empty initially;
	 * 				at the completion of this method this stack contains
	 * 				the labels of the vertices along the shortest path;
	 * 				the label of the origin vertex is at the top, and
	 * 				the label of the destination vertex is at the bottom.
	 * 				
	 * @return	The cost of the cheapest path. 
	 */
	double getCheapestPath(T begin, T end, StackADTInterface<T> path);
	
	
	
	
}
