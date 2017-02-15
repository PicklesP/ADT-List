/**
 * An implementation of ADT list using a linked node list
 */

package cs240;

public class ListNodes<T> implements ListInterface{

	private Node firstNode;
	private int numEntries;
	
	public ListNodes(){
		firstNode = null;
		numEntries = 0;
	}
	
	@Override
	public void add(Object item) {
		Node newNode = new Node(item, null);
		
		if(isEmpty())
			firstNode = newNode;
		else{
			Node lastNode = getNodeAt(numEntries);
			lastNode.setNextNode(newNode);
		}
		
		numEntries++;
	}

	@Override
	public void add(Object item, int index) {

		if(index >= 0 && index <= numEntries){
			Node newNode = new Node(item, null);
			if(index == 0){
				newNode .setNextNode(firstNode);
				firstNode = newNode;
			}
			else{
				Node nodeBefore = getNodeAt(index - 1);
				Node nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			}
			
			numEntries++;
		}
	}

	@Override
	public T remove(int index) {
		T result = null;
		
		if((index >= 0) && (index <= numEntries)){
			if(index == 0){
				result = (T) firstNode.getData();
				firstNode = firstNode.getNextNode();
			}
			else{
				Node nodeBefore = getNodeAt(index - 1);
				Node nodeRemove = nodeBefore.getNextNode();
				Node nodeAfter = nodeRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter);
				result = (T) nodeRemove.getData();
			}
			numEntries--;
		}
		
		return result;
	}

	@Override
	public void removeAll() {
		firstNode = null;
	}

	@Override
	public T replace(Object item, int index) {
		T result = null;
		if(index >= 0 && index < numEntries){
			Node replaced = getNodeAt(index);
			result = (T) replaced.getData();
			replaced.setData(item);
		}
		return result;
	}

	@Override
	public T look(int index) {
		Node currentNode = firstNode;
		T result = null;
		if(index >= 0 && index < numEntries){
			for(int i = 0; i < index; i++)
				currentNode = currentNode.getNextNode();
			result = (T) currentNode.getData();
		}
		return result;
	}
	
	public Node getNodeAt(int index){
		Node result = firstNode;
		for(int i = 0; i < index; i++)
			result = result.getNextNode();
		return result;
	}

	@Override
	public void lookAll() {
		Node currentNode = firstNode;
		for(int i = 0; i < numEntries; i++){
			System.out.println(currentNode);
			currentNode = currentNode.getNextNode();
		}
	}

	@Override
	public boolean check(Object item) {
		boolean found = false;
		Node currentNode = firstNode;
		
		while(!found && (currentNode != null)){
			if(item.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		}
		
		return found;
	}

	@Override
	public int length() {
		return numEntries;
	}

	@Override
	public boolean isEmpty() {
		return (firstNode == null);
	}

	
	private class Node<T>{
		private Node next;
		private T data;
		
		private Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
		
		private T getData(){
			return data;
		}
		
		private void setData(T data){
			this.data = data;
		}
		
		private Node getNextNode(){
			return next;
		}
		
		private void setNextNode(Node next){
			this.next = next;
		}
	}
}
