package list;

public class LinkedList {
	private Node head;
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	public void addNode(Node node) {
		if(head == null) {
			head = node;
		} else {
			Node currentNode = getHead();
			
			while(currentNode.getNext() != null)
				currentNode = currentNode.getNext();
			currentNode.setNext(node);
		}
	}
	
	public void displayList() {
		Node currentNode = head;
		int nodeCount = 1;
		while(currentNode != null) {
			System.out.println("Node " + nodeCount + ": " + currentNode.getData());
			currentNode = currentNode.getNext();
			nodeCount++;
		}
	}

	public void insert(int index, Node node) {
		Node currentNode = head;
		
		if(index == 0) {
			node.setNext(currentNode);
			head = node;
		}
		
		for(int i = 0; i < index - 1; i++) {
			currentNode = currentNode.getNext();
		}
		
		node.setNext(currentNode.getNext());
		currentNode.setNext(node);
		
	}

	public void delete(int data) {
		Node currentNode = head;
		
		if(head == null) {
			return;
		} else if(currentNode.getData() == data) {
			head = head.getNext();
			return;
		}
		
		Node deletedNode = null;
		while(currentNode != null) {
			if(currentNode.getNext().getData() == data) {
				deletedNode = currentNode.getNext();
				break;
			}
			currentNode = currentNode.getNext();
		}
		
		while(currentNode != null) {
			if(currentNode.getNext() == deletedNode) {
				currentNode.setNext(deletedNode.getNext());
				break;
			}
			currentNode = currentNode.getNext();
		}
	}
}
