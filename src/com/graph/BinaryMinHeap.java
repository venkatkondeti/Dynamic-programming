package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryMinHeap<T> {
	private List<Node> allNodes = new ArrayList<>();
	private Map<T, Integer> nodePosition = new HashMap<>();

	public class Node {
		T data;
		int weight;
	}

	public void add(int weight, T t) {
		Node node = new Node();
		node.data = t;
		node.weight = weight;
		allNodes.add(node);
		int position = allNodes.size() - 1;
		nodePosition.put(t, position);

		int parent = (position - 1) / 2;
		while (parent >= 0) {
			if (allNodes.get(parent).weight > allNodes.get(position).weight) {
				swap(allNodes.get(parent), allNodes.get(position));
				updateNodePosition(allNodes.get(parent).data, allNodes.get(position).data,parent,position);
				position=parent;
				parent=(parent-1)/2;
			} else {
				break;
			}
		}
	}

	public void decrease(T data, int weight){
		Integer position = nodePosition.get(data);
		allNodes.get(position).weight=weight;
		int parent =(position-1)/2;
		while (parent >= 0) {
			if (allNodes.get(parent).weight > allNodes.get(position).weight) {
				swap(allNodes.get(parent), allNodes.get(position));
				updateNodePosition(allNodes.get(parent).data, allNodes.get(position).data,parent,position);
				position=parent;
				parent=(parent-1)/2;
			} else {
				break;
			}
		}
	}
	
	public Node extractMinNode(){
		int size=allNodes.size()-1;
		Node minNode=new Node();
		minNode.data=allNodes.get(0).data;
		minNode.weight=allNodes.get(0).weight;
		
		allNodes.get(0).data=allNodes.get(size).data;
		allNodes.get(0).weight=allNodes.get(size).weight;
		allNodes.remove(size);
		nodePosition.remove(minNode.data);
		nodePosition.remove(allNodes.get(0));
		nodePosition.put(allNodes.get(0).data, 0);
		
		int current=0;
		size--;
		while(true){
			int left=2*current+1;
			int right=2*current+2;
			if(left>size){
				break;
			}
			if(right>size){
				right=left;
			}
			int smallWeightIndex=allNodes.get(left).weight<=allNodes.get(right).weight?left:right;
			if(allNodes.get(current).weight>allNodes.get(smallWeightIndex).weight){
				swap(allNodes.get(current), allNodes.get(smallWeightIndex));
				updateNodePosition(allNodes.get(current).data, allNodes.get(smallWeightIndex).data, current, smallWeightIndex);
				current=smallWeightIndex;
			}else{
				break;
			}
			
		}
		
		return minNode;
	}
	
	public void printHeap(){
		for(Node node:allNodes){
			System.out.println(node.data+" "+node.weight);
		}
	}
	
	public void printPositionMap(){
		System.out.println(nodePosition);
	}
	
	private void updateNodePosition(T data, T data2, int parent, int position) {
		nodePosition.remove(data);
		nodePosition.remove(data2);
		nodePosition.put(data, parent);
		nodePosition.put(data2, position);
	}

	private void swap(Node node, Node node2) {
		T t = node.data;
		int weight = node.weight;
		node.data = node2.data;
		node.weight = node2.weight;
		node2.data = t;
		node2.weight = weight;
	}
	
	public static void main(String args[]){
        BinaryMinHeap<String> heap = new BinaryMinHeap<String>();
        heap.add(3, "Tushar");
        heap.add(4, "Ani");
        heap.add(8, "Vijay");
        heap.add(10, "Pramila");
        heap.add(5, "Roy");
        heap.add(6, "NTF");
        heap.add(2,"AFR");
        heap.decrease("Pramila", 1);
        heap.printHeap();
        heap.printPositionMap();
    }
}