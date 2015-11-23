package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {

	private List<Edge<T>> allEdges;
	private Map<Long, Vertex<T>> allVertex;
	private boolean isDirected;

	public Graph(boolean isDirected) {
		this.allEdges = new ArrayList<Edge<T>>();
		this.allVertex = new HashMap<Long, Vertex<T>>();
		this.isDirected = isDirected;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public List<Edge<T>> getAllEdges() {
		return allEdges;
	}

	public Map<Long, Vertex<T>> getAllVertex() {
		return allVertex;
	}

	public void addEdge(long id1, long id2) {
		addEdge(id1, id2, 0);
	}

	public void addEdge(long id1, long id2, int weight) {
		Vertex<T> vertex1 = null;
		if (allVertex.containsKey(id1)) {
			vertex1 = allVertex.get(id1);
		} else {
			vertex1 = new Vertex<>(id1);
			allVertex.put(id1, vertex1);
		}
		Vertex<T> vertex2 = null;
		if (allVertex.containsKey(id2)) {
			vertex2 = allVertex.get(id2);
		} else {
			vertex2 = new Vertex<T>(id2);
			allVertex.put(id2, vertex2);
		}
		Edge<T> edge = new Edge<>(vertex1, vertex2, weight, isDirected);
		allEdges.add(edge);
		vertex1.addAdjacentVertex(vertex2, edge);
		if(!isDirected)
			vertex2.addAdjacentVertex(vertex1, edge);
	}

	class Vertex<T> {
		private long id;
		private T data;
		private List<Edge<T>> allEdges = new ArrayList<Edge<T>>();
		private List<Vertex<T>> adjacentVertex = new ArrayList<Vertex<T>>();

		public Vertex(long id) {
			this.id = id;
		}

		public long getId() {
			return id;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public List<Edge<T>> getAllEdges() {
			return allEdges;
		}

		public List<Vertex<T>> getAdjacentVertex() {
			return adjacentVertex;
		}

		@Override
		public String toString() {
			return String.valueOf(id);
		}

		public int getDegree() {
			return allEdges.size();
		}

		public void addAdjacentVertex(Vertex<T> vertex, Edge<T> edge) {
			allEdges.add(edge);
			adjacentVertex.add(vertex);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = result * prime + (int) (id ^ (id >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this != obj)
				return false;
			if (getClass() != obj.getClass())
				return false;
			if (obj == null)
				return false;
			Vertex other = (Vertex) obj;
			if (this.id != other.id)
				return false;
			return true;
		}
	}

	class Edge<T> {
		private int weight;
		private Vertex<T> vertex1;
		private Vertex<T> vertex2;
		private boolean isDirected;

		public Edge(Vertex<T> vertex1, Vertex<T> vertex2, int weight, boolean isDirected) {
			this.vertex1 = vertex1;
			this.vertex2 = vertex2;
			this.weight = weight;
			this.isDirected = isDirected;
		}

		public Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
			this.vertex1 = vertex1;
			this.vertex2 = vertex2;
		}

		public Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected) {
			this.vertex1 = vertex1;
			this.vertex2 = vertex2;
			this.isDirected = isDirected;
		}

		public int getWeight() {
			return weight;
		}

		public Vertex<T> getVertex1() {
			return vertex1;
		}

		public Vertex<T> getVertex2() {
			return vertex2;
		}

		public boolean isDirected() {
			return isDirected;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Edge other = (Edge) obj;
			if (this.weight != other.weight)
				return false;
			if (vertex1 == null) {
				if (other.vertex1 != null)
					return false;
			} else if (!vertex1.equals(other)) {
				return false;
			}
			if (vertex2 == null) {
				if (other.vertex2 != null)
					return false;
			} else if (!vertex2.equals(other.vertex2)) {
				return false;
			}
			return true;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
			result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
			return result;
		}
	}
}
