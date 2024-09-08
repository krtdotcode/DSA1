
public class DynamicArray {
	private int size;
	private int capacity = 10;
	
	private Object[] array;
	
	//constructors
	public DynamicArray() {
		array = new Object[capacity];
	}
	
	public DynamicArray(int capacity) {
		this.capacity = capacity;
		array = new Object[capacity];
	}
	
	//methods
	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}
	
	public void add(Object data) {
		if(size >= capacity) expand();
		
		array[size] = data;
		size++;
	}
	
	public void delete(Object data) {
		for(int i = 0; i < size; i++) {
			if(array[i] == data) {
				for(int j = i; j < size - 1; j++) {
					array[j] = array[j + 1];
				}
				array[size-- - 1] = null;
				break;
			}
		}
		
		if(size + 10 == capacity) shrink();
	}
	
	public void insert(int index, Object data) {
		if(size >= capacity) expand();
		
		size++;
		for(int i = size; i > index; i--)
			array[i] = array[i - 1];
		
		array[index] = data;
	}
	
	public int search(Object data) {
		for(int i = 0; i < size; i++) {
			if(array[i] == data)
				return i;
		}
		return -1;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private void expand() {
		capacity += 10;
		Object[] newArray = new Object[capacity];
		
		for(int i = 0; i < size; i++)
			newArray[i] = array[i];
		
		array = newArray;
	}
	
	private void shrink() {
		capacity -= 10;
		Object[] newArray = new Object[capacity];
		
		for(int i = 0; i < size; i++)
			newArray[i] = array[i];
		
		array = newArray;
	}
	
	public String toString() {
		String arrayStr = "";
		
		if(size == 0) return "[]";
		
		for(int i = 0; i < size; i++) {
			if(i != size - 1) 
				arrayStr += array[i] + ", ";
			else
				arrayStr += array[i];
		}
		
		return "[" + arrayStr + "]";
	}
}
