public class PrelimAct2 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 1, 4, 5};
		
		int num = 1;
		
		display(arr);
		
		System.out.printf("Element %d occurred %d time/s\n", num, occurrences(arr, num));
		
		System.out.printf("Array without the occurrence of %d: ", num);
		display(removeOccurrences(arr, num));
		
		int element = 16, index = 3;
		System.out.printf("Inserted %d at index[%d]: ", element, index);
		display(insert(element, arr, index));
		
		System.out.println("Second Highest is: " + secondHighest(arr));

	}
	
	// Method to display array elements
	private static void display(int[] arr) {
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	// No.1 : Method that counts the number of times a number appears in an array
	private static int occurrences(int[] arr, int num) {
		int occurrences = 0;
		
		for(int i : arr) {
			if(i == num) {
				occurrences++;
			}
		}
		
		return occurrences;
	}
	
	// No.2 : Method that removes all occurrences of a specific value from an array
	private static int[] removeOccurrences(int[] arr, int num) {
		/*
		 * The new array's length is the length of the array minus the occurrences of the num to be removed
		 * Use the method in No.1 to get the occurrences of the num
		*/
		int[] newArr = new int[arr.length - occurrences(arr, num)];
		
		int index = 0;
		for(int i : arr) {
			if(i != num) {
				newArr[index++] = i;
			}
		}
		
		return newArr;
	}
	
	// No.3 : Method that inserts an element into an array at a specific position
	private static int[] insert(int num, int[] arr, int index) {
		int[] newArr = new int[arr.length + 1];
		
		for(int i = 0; i < index; i++) {
			newArr[i] = arr[i];
		}
		
		newArr[index] = num;
		
		for(int i = index; i < arr.length; i++) {
			newArr[i + 1] = arr[i];
		}
		
		return newArr;
	}
	
	// No.4 : Method that finds the second highest element in an array 
	private static int secondHighest(int[] arr) {
		int highest = arr[0], secondHighest = arr[0];
		
		for(int i : arr) {
			if(highest < i) {
				secondHighest = highest;
				highest = i;
			} else if(highest > i && secondHighest < i) {
				secondHighest = i;
			}
		}
		
		return secondHighest;
	}

}
