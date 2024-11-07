/* Stack implementation using an array */
public class Stack {
	private int[] array;
	private int size;
	
	//Constructor to pass size when creating stack object
	public Stack(int size) {
		array = new int[size];
	}
	
	//Adds an item to the stack
	public void push(int data) {
		if(isFull()) {
			System.out.println("Stack is Full!");
			return;
		}
		
		array[size] = data;
		size++;
	}
	
	//Removes an item from the stack
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty!");
			return 0;
		}
		size--;
		
		int data = array[size];
		array[size] = 0;
		
		return data;
	}
	
	//Returns the top (last) element of the stack
	public int peek() {
		if(isEmpty()) {
			System.out.println("Stack is Empty!");
			return 0;
		}
		
		return array[size - 1];
	}
	
	//Returns true if the stack is empty; otherwise, it is false
	public boolean isEmpty() {
		return size == 0;
	}
	
	//Returns true if the stack is full, else false
	public boolean isFull() {
		return size == array.length;
	}
	
	//Displays the stack
	public void display() {
		for(int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
