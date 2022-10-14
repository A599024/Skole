package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import List.LinkedListWithIterator;
import exceptions.NoSuchElementException;

public class Vertex<T> implements VertexInterface<T> {
	
	private T label;
	private LinkedListWithIterator<Edge> edgeList;
	private boolean visited;
	private VertexInterface<T> previousVertex;
	private double cost;
	
	
	public Vertex(T vertexLabel) {
		this.label = vertexLabel;
		edgeList = new LinkedListWithIterator<>();
		visited = false;
		previousVertex = null;
		cost = 0;
	}
	
	@Override
	public T getLabel() {
		return label;
	}

	@Override
	public void visit() {
		visited = true;
	}

	@Override
	public boolean isVisited() {
		return visited;
	}

	@Override
	public boolean connect(VertexInterface<T> endVertex, double edgeWeight) {
		boolean result = false;
		if(!this.equals(endVertex)) {	// Vertices are distinct
			
			Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
			boolean duplicateEdge = false;
			
			while(!duplicateEdge && neighbors.hasNext()) {	// Looks for duplicates
				
				VertexInterface<T> nextNeighbor = neighbors.next();
				
				if(endVertex.equals(nextNeighbor))
					duplicateEdge = true;	
			}
			if(!duplicateEdge) {	// Connects this and end vertex if not duplicate edges
				
				edgeList.add(new Edge(endVertex, edgeWeight));
				result = true;
				
			}
		}
		return result;
	}

	@Override
	public boolean connect(VertexInterface<T> endVertex) {
		return connect(endVertex, 0);
	}

	@Override
	public Iterator<VertexInterface<T>> getNeighborIterator() {
		return new NeighborIterator();
	}

	@Override
	public Iterator<Double> getWeightIterator() {
		return (Iterator<Double>) new WeightIterator();
	}

	@Override
	public boolean hasNeightbor() {
		return !edgeList.isEmpty();
	}

	@Override
	public VertexInterface<T> getUnvisitedNeighbor() {
		VertexInterface<T> result = null;
		Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
		
		while(neighbors.hasNext() && (result == null)) {
			
			VertexInterface<T> nextNeighbor = neighbors.next();
			if(!nextNeighbor.isVisited()) {
				result = nextNeighbor; 
			}
		}
		return result;
	}

	@Override
	public void setPredecessor(VertexInterface<T> predecessor) {
		previousVertex = predecessor;
	}

	@Override
	public VertexInterface<T> getPredecessor() {
		return previousVertex;
	}

	@Override
	public boolean hasPredecessor() {
		return previousVertex != null;
	}

	@Override
	public void setCost(double newCost) {
		cost = newCost;
	}

	@Override
	public double getCost() {
		return cost;
	}
	
	@Override
	public void unVisit() {
		visited = false;
	}
	
	@Override
	public boolean equals(Object other) {
		boolean result;
		
		if((other == null) || (getClass() != other.getClass()))
			result = false;
		else {
			
			@SuppressWarnings("unchecked")
			Vertex<T> otherVertex = (Vertex<T>) other;
			result = label.equals(otherVertex.label);
		}
		return result;
	}
	
	
	/*------------------------------------*/
	/*			EDGE INNER CLASS		  */
	/*------------------------------------*/
	private class Edge {
		
		private VertexInterface<T> vertex;
		private double weight;
		
		
		protected Edge(VertexInterface<T> endVertex, double weight) {
			this.vertex = endVertex;
			this.weight = weight;
		}
		
		protected VertexInterface<T> getEndVertex() {
			return vertex;
		}
		
		protected double getWeight() {
			return weight;
		}
		
	}
	
	/*------------------------------------*/
	/* 	  NEIGHBORITERATOR INNER CLASS    */
	/*------------------------------------*/
	private class NeighborIterator implements Iterator<VertexInterface<T>> {

		private Iterator<Edge> edges;
		
		
		private NeighborIterator() {
			edges = edgeList.getIterator();
		}
		
		@Override
		public boolean hasNext() {
			return edges.hasNext();
		}

		@Override
		public VertexInterface<T> next() {
			VertexInterface<T> nextNeighbor = null;
			
			if(edges.hasNext()) {
				Edge edgeToNextNeighbor = edges.next();
				nextNeighbor = edgeToNextNeighbor.getEndVertex();
			} else {
				throw new NoSuchElementException();
			}
			return nextNeighbor;
		}
	}
	
	/*------------------------------------*/
	/* 	   WEIGHTITERATOR INNER CLASS     */
	/*------------------------------------*/
	private class WeightIterator implements Iterator<T> {
		
		private Iterator<Double> weights;
		private Iterator<Edge> edges;
		List<Double> weightList;
		
		
		public WeightIterator() {
			edges = edgeList.getIterator();
			weightList = new ArrayList<>();
			
			while(edges.hasNext()) {
				Edge next = edges.next();
				weightList.add(next.getWeight());
			}
			
			weights = weightList.iterator();
		}
		
		@Override
		public boolean hasNext() {
			return weights.hasNext();
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			Double weight = null;
			
			if(weights.hasNext()) {
				Double nextW = weights.next();
				weight = nextW;
			} else {
				throw new NoSuchElementException();
			}
			return (T) weight;
		}
		
	}
	

}
