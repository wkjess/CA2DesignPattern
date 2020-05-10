package consoles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

	/*
	 * Method to read input data value
	 * from standard keyboard.
	 * @param prompt the prompt message
	 * @return the data value read as an integer.
	 */
	public static int readInput(String prompt) {
		// read input data value by class Scanner
		Scanner scan = null;
		// initial the expression value
		boolean validInt = false;
		int input = 0;

		while(! validInt) {
			// read in the data value in the try body
			// otherwise skip and catch it if any exception
			try {
				System.out.print(prompt);
				scan = new Scanner(System.in);
				input = scan.nextInt();
				validInt = true;
			}
			catch(InputMismatchException imexp) {
				// clear the buffered
				scan.hasNextLine();
				// prompt re-input the expected data value
				System.out.printf("%-2s  range from selection only.%n", prompt);
			}
		}
		return input;
	}

	/*
	 * Prompts user to select to continue
	 * to the program or quit the program.
	 * @param prompt the prompt message to the user
	 */
	public static void getUserRespond(String prompt) {
		// Display some option message to user to continue or quit the program.
		System.out.println("1 - To continue the program");
		System.out.println("2 - To continue the program");

		// Read user input.

		int input = readInput(prompt);

		// switching between from selection were made
		switch(input) {

		case 1:
			break;

		case 2:
			quitProgram();
			break;

		default:
			// re-invoke the method and prompt to re-input expected data value
			getUserRespond("Enter selection 1 or 2 only: ");
			break;
		}
	}

	/*
	 * Get user to respond to
	 * quit the program, and
	 * display a goodbye message to the standard screen.
	 */
	private static void quitProgram() {
		System.out.printf("You are quitted the trading program.%n");
		System.exit(0);
	}

	public static void main(String[] args) {
		int i = readInput("Enter number: ");
		System.out.println(i + " number entered.");
		getUserRespond("Select an option: ");
	}

}
