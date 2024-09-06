import java.util.Scanner;

/*
 * Cayaga, Kurt Joshua P.
 * Pega, Jede Isaiah Maxweil
 * 2CS - A
*/

public class Exercise3 {

	public static void main(String[] args) {
		//Displays a welcome message
		System.out.println("------------ Student Periodical Grade ------------");
		System.out.println("Note: Inputted Name must not exceed 25 characters.");
		System.out.println("      Inputted Grade must be around 0 - 100.\n");
		
		Scanner input = new Scanner(System.in); //Create scanner object called input
		
		System.out.print("Enter Number of Students: ");
		int noOfStudents = input.nextInt();
		
		//Declare arrays of students, prelims, midterms, finals, averages, and grades
		String[] students = new String[noOfStudents];
		
		double[] prelims = new double[noOfStudents];
		double[] midterms = new double[noOfStudents];
		double[] finals = new double[noOfStudents];
		
		double[] averages = new double[noOfStudents];
		char[] grades = new char[noOfStudents];
		
		for(int i = 0; i < noOfStudents; i++) {
			System.out.printf("\n------------------- Student #%d -------------------\n", i + 1);
			input.nextLine(); //Clear newline char (\n) after numeric input
			
			students[i] = inputValid(input);
			
			prelims[i] = inputValid(input, "Prelim");
			midterms[i] = inputValid(input, "Midterm");
			finals[i] = inputValid(input, "Final");
			
			averages[i] = getAverage(prelims[i], midterms[i], finals[i]);
			grades[i] = getGrade(averages[i]);
		}
		
		//Sort by average grades using merge sort
        mergeSort(students, prelims, midterms, finals, averages, grades, 0, noOfStudents - 1);
		//Display Grade Table
		displayTable(students, prelims, midterms, finals, averages, grades);
		
	}
	
	//This method asks for name, then check if valid (less than 25 characters)
	private static String inputValid(Scanner input) {
		String name;
		
		while(true) {
			System.out.print("Enter Student Name: ");
			name = input.nextLine();
			
			if(name.length() <= 25)
				return name; //Return name since valid
			
			System.err.println("Name too long, Please try again..."); //Display warning message since invalid
		}
	}
	
	//This method asks for term grade, then check if valid (0 - 100)
	private static double inputValid(Scanner input, String term) {
		double grade;
		
		while(true) {
			System.out.printf("Enter %s Grade: ", term);
			grade = input.nextDouble();
			
			if(grade >= 0 && grade <= 100)
				return grade; //Return grade since valid
			
			System.err.println("Invalid! Please try again..."); //Display warning message since invalid
		}
		
	}

	/*This method computes for the average grade
	 * Prelim - 30%
	 * Midterm - 30%
	 * Final - 40%
	*/
	private static double getAverage(double prelim, double midterm, double finals) {
		return (prelim * 0.30) + (midterm * 0.30) + (finals * 0.40);
	}
	
	//This method determines equivalent letter grade
	private static char getGrade(double average) {
		if(average >= 90) return 'A';
		else if(average >= 80) return 'B';
		else if(average >= 70) return 'C';
		else if(average >= 60) return 'D';
		else return 'F';
	}
	
    //Merge sort method
    private static void mergeSort(String[] students, double[] prelims, double[] midterms, double[] finals, double[] averages, char[] grades, int left, int right) {
        if(left < right) {
            int mid = (left + right)/2;
            
            mergeSort(students, prelims, midterms, finals, averages, grades, left, mid);
            mergeSort(students, prelims, midterms, finals, averages, grades, mid + 1, right);

            merge(students, prelims, midterms, finals, averages, grades, left, mid, right);
        }
    }
    
    //Helper method for merge sort
    private static void merge(String[] students, double[] prelims, double[] midterms, double[] finals, double[] averages, char[] grades, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        //Temporary arrays
        String[] leftStudents = new String[n1];
        String[] rightStudents = new String[n2];
        double[] leftPrelims = new double[n1];
        double[] rightPrelims = new double[n2];
        double[] leftMidterms = new double[n1];
        double[] rightMidterms = new double[n2];
        double[] leftFinals = new double[n1];
        double[] rightFinals = new double[n2];
        double[] leftAverages = new double[n1];
        double[] rightAverages = new double[n2];
        char[] leftGrades = new char[n1];
        char[] rightGrades = new char[n2];

        //Copy elems of arrays to temporary arrays
        for(int i = 0; i < n1; i++) {
            leftStudents[i] = students[left + i];
            leftPrelims[i] = prelims[left + i];
            leftMidterms[i] = midterms[left + i];
            leftFinals[i] = finals[left + i];
            leftAverages[i] = averages[left + i];
            leftGrades[i] = grades[left + i];
        }
        for(int j = 0; j < n2; j++) {
            rightStudents[j] = students[mid + 1 + j];
            rightPrelims[j] = prelims[mid + 1 + j];
            rightMidterms[j] = midterms[mid + 1 + j];
            rightFinals[j] = finals[mid + 1 + j];
            rightAverages[j] = averages[mid + 1 + j];
            rightGrades[j] = grades[mid + 1 + j];
        }

        //Merge temporary arrays
        int i = 0, j = 0;
        int k = left;

        while(i < n1 && j < n2) {
            if(leftAverages[i] >= rightAverages[j]) {
                students[k] = leftStudents[i];
                prelims[k] = leftPrelims[i];
                midterms[k] = leftMidterms[i];
                finals[k] = leftFinals[i];
                averages[k] = leftAverages[i];
                grades[k] = leftGrades[i];
                i++;
            } else {
                students[k] = rightStudents[j];
                prelims[k] = rightPrelims[j];
                midterms[k] = rightMidterms[j];
                finals[k] = rightFinals[j];
                averages[k] = rightAverages[j];
                grades[k] = rightGrades[j];
                j++;
            }
            k++;
        }

        //Copy remaining elems of left arr
        while(i < n1) {
            students[k] = leftStudents[i];
            prelims[k] = leftPrelims[i];
            midterms[k] = leftMidterms[i];
            finals[k] = leftFinals[i];
            averages[k] = leftAverages[i];
            grades[k] = leftGrades[i];
            i++;
            k++;
        }

        //Copy remaining elems of right arr
        while(j < n2) {
            students[k] = rightStudents[j];
            prelims[k] = rightPrelims[j];
            midterms[k] = rightMidterms[j];
            finals[k] = rightFinals[j];
            averages[k] = rightAverages[j];
            grades[k] = rightGrades[j];
            j++;
            k++;
        }
    }
    
    /*
     * This method displays the formatted grade table (we use printf)
     * %s for String (also for proper spacing of table)
     * %c for char
     * %.2f for double (2 decimals)
    */
	private static void displayTable(String[] students, double[] prelims, double[] midterms, double[] finals, double[] averages, char[] grades) {
		System.out.println("_____________________________________________________________________");
		System.out.printf("%-25s%-6s%-7s%-7s%-5s%-4s%n", "NAME", "| PRELIM |", " MIDTERM |", " FINAL |", "  AVG  |", " GRADE |");
		System.out.println("---------------------------------------------------------------------");
		
		for(int i = 0; i < students.length; i++) {
			System.out.printf("%-25s| %-6.2f | %-7.2f | %-5.2f | %-5.2f | %-5c |%n", students[i], prelims[i], midterms[i], finals[i], averages[i], grades[i]);
		}
		System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
	}

}
