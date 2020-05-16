package design_patterns;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
 * Class MenuActivity represents the menu activity for
 * it displays the selection of menu to choose from number
 * respectively
 *  * Company with the highest capital (number of shares times latest share price)  
 * Company with the lowest capital (number of shares times (x) latest share price) 
 * If there are more than one company at the top or bottom position, they all should be displayed in the result
 * Investor with the highest number of shares 
 * Investor with the lowest number of shares 
 * It there is more than one investor in any of the positions, they all should be displayed in the result.  
 * This class is use of Builder, Command design patterns
 *@author Kim Jang Wong
 *@date 03 May 2020
 */

public class MenuActivity {

	/** Declare the instance of associated class for the menu activity. */

	// never declare the instance of the associated object here!!!
	// you will pay a huge effort to find the error or bugs here!
	// try it if you don't believe it!

	/** Constructs an empty constructor without its properties. */
	public MenuActivity() {}

	/** Method to display the current date and time. */
	private static void showCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd:MM:yy HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		System.out.printf("Current Date/Time: %T:%M:%S", dateFormat.format(calendar.getTime()));
	}

	/*
	 * Method to display a list of menu option
	 * to be selected for the stock market trading simulation
	 */
	public void showMenu() {
		// create the instance of this company
		Company company = new Company.CreateCompany().getCompany();
		// create the instance of this investor
		Investor investor = new Investor.CreateInvestor().getInvestor();

		// create the instance of the command to start the simulation
		TradingActivity tradingActivity = new TradingActivity();
		StartTrading startTrading = new StartTrading(tradingActivity);

		// using the try and catch to continue to the menu be displayed
		
		try {
			do {

				// a list of prompt message here

				System.out.printf("------ Stock Market Trading Menu ------%n%n");
				System.out.printf("1 - The company from highest to lowest capital %n");
				System.out.printf("2 - The company from lowest to highest capital %n");
				System.out.printf("3 - The investor from highest to lowest budget %n");
				System.out.printf("4 - The investor from lowest to highest budget %n");
				System.out.printf("5 - Displaying the company profiles %n");
				System.out.printf("6 - Displaying the investor pprofiles %n");
				System.out.printf("7 - Displaying the stock market trading activity  pdetails %n%n");
				
				// read input data value from keyboard

				int option = Console.readInput("Select from 1 to 7: ");

				// see how selection is chosen

				switch (option) {

				case 1:
					System.out.printf("%n----- The company from highest to lowest capital -----%n%n");
					company.highToLow();
					break;

				case 2:
					System.out.printf("%n----- The company from lowest to highest capital -----%n%n");
					company.lowToHigh();
					break;

				case 3:
					System.out.printf("%n----- The investor from highest to lowest budget -----%n%n");
					investor.highToLow();
					break;

				case 4:
					System.out.printf("%n----- The investor from lowest to highest budget -----%n%n");
					investor.lowToHigh();
					break;

				case 5:
					System.out.printf("%n----- Displaying the company profiles -----%n%n");
					company.createUser();
					break;

				case 6:
					System.out.printf("%n----- Displaying the investor pprofiles -----%n");
					investor.createUser(); 
					break;

				case 7:
					System.out.printf("%n----- Displaying the stock market trading activity  pdetails -----%n%n");
					startTrading.respond();
					break;

				default:
					System.out.printf("%nError reading input, choose 1 to 7 only%n%n");
					showMenu();
					System.out.println();
				}
			} while (true);
		} catch (Exception e) {
			System.out.printf("Error reading input%n");
		}
	}

}
