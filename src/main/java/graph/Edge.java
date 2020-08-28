package graph;

import java.util.Objects;

import static java.util.Objects.hash;

public class Edge<Integer> implements Comparable<Edge> {

	private int vertex;
	private int adjvertex;
	private int weight;

	public Edge(int vertex, int adjvertex) {
		this.vertex = vertex;
		this.adjvertex = adjvertex;
		this.weight = 0;
	}

	public Edge(int vertex, int adjvertex, int weight) {
		this.vertex = vertex;
		this.adjvertex = adjvertex;
		this.weight = weight;

	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge otherEdge) { //간선 가중치를 기준으로 정렬 오름차순
		return this.getWeight() - otherEdge.getWeight();
	}

	public int getVertex() {
		return vertex;
	}

	public int getAdjvertex() {
		return adjvertex;
	}

	public void setVertex(int vertex1) {
		this.vertex = vertex1;
	}

	public void setAdjvertex(int vertex2) {
		this.adjvertex = vertex2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Edge<?> edge = (Edge<?>) o;
		return vertex == edge.vertex &&
				adjvertex == edge.adjvertex &&
				weight == edge.weight;
	}

	@Override
	public int hashCode() {
		return hash(vertex, adjvertex, weight);
	}

	@Override
	public String toString() {
		return "(" + vertex + "," + adjvertex + "), weight=" + weight;
	}

}
