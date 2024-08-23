import java.util.Scanner;

public class Exercise1 {
	
	private static String str; //Create a string field accessible to all methods of this class
	
	//Main method (program's entry point)
	public static void main(String[] args) {
		
		//Displays a welcome message
		System.out.println("Hello, this program will count each vowels and consonants of a string.");
		System.out.println("Note: maximum 20 characters long.\n");
		
		getUserInput(); //Call this method to ask for user input
		
		displayOutput(countVowels(str), countConsonants(str)); //Call this method to display formatted output
	}

	//This method reads user input of string
	private static void getUserInput() {
		Scanner input = new Scanner(System.in); //Create scanner object called input
		
		//Repeat user input if string is more than 20 characters
		do {
			System.out.print("Enter a string: ");
			str = input.nextLine(); //Ask for user input
			
			if(str.length() > 20) {
				System.err.println("Exceeded 20 characters! Please try again..."); //Displays message if string is more than 20 characters
			}
		} while(str.length() > 20);
		
		str = str.toLowerCase(); //Convert to lowercase to make checking case-insensitive
		
	}
	
	//This method counts each vowel in a string, returns an integer array
	private static int[] countVowels(String str) {
		int[] vowelCounts = new int[5]; //This array corresponds to vowel counts: {a, e, i, o, u}
		
		/*
		 * Iterate through each character in a string,
		 * then check each character if its a vowel
		 * If a character is vowel, increment the count of vowel corresponding to its array index
		*/
		for(int i = 0; i < str.length(); i++) {
			switch(str.charAt(i)) {
			case 'a':
				vowelCounts[0]++;
				break;
			case 'e':
				vowelCounts[1]++;
				break;
			case 'i':
				vowelCounts[2]++;
				break;
			case 'o':
				vowelCounts[3]++;
				break;
			case 'u':
				vowelCounts[4]++;
				break;
			}
		}
		
		return vowelCounts;
	}
	
	//This method counts the number of consonants in a string, returns an integer
	private static int countConsonants(String str) {
		int consonantCount = 0; //Declare a variable for number of consonants, initialize to 0 as default value
			
		/*
		 * Iterate through each character in a string
		 * Use isLetter method of Character class to disregard digits or other special characters
		 * Increment consonant count if not a vowel
		*/
			
		for(int i = 0; i < str.length(); i++) {
			if(Character.isLetter(str.charAt(i))) //Check if character is a letter
			{
				switch(str.charAt(i)) {
				case 'a', 'e', 'i', 'o', 'u': break; //If vowel, then break and go with next iteration
				default:
					consonantCount++; //Since not a vowel, then increment consonant count
					break;
				}
			}
		}
		
		return consonantCount;
	}
	
	//This method displays the formatted output
	private static void displayOutput(int[] countVowels, int countConsonants) {
		System.out.println("Vowels:");
		/*
		 * Format output using printf statement
		 * %d to insert integer
		 * \n to move next line
		*/
		System.out.printf("a: %d\n", countVowels[0]);
		System.out.printf("e: %d\n", countVowels[1]);
		System.out.printf("i: %d\n", countVowels[2]);
		System.out.printf("o: %d\n", countVowels[3]);
		System.out.printf("u: %d\n", countVowels[4]);
		
		System.out.printf("Consonants: %d", countConsonants);
	}

}
