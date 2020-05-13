package menus;

import java.util.ArrayList;
import java.util.Collections;

import static consoles.Console.*;
import users.*;
import stocks.*;

/*
 * Class MenuActivity represents an interaction from
 * user(s) with data access object
 * It shows a list of menu option
 * can be selected, all result will be extracting from
 * @author Kim Jang Wong
 * Date: 06 May 2020
 */

public class MenuActivity {

	/** Declare the instance of the class that require.*/

	Company company = new Company.CreateCompany().getCompany();
	Investor investor = new Investor.CreateInvestor().getInvestor();
	StockTrading stockTrading = new StockTrading();
	TradingActivity tradingActivity = new TradingActivity();
	StartTrading startTrading = new StartTrading(tradingActivity);
	Menu menu;

	/** Construct the instance of the class and create the class menu's object. */
	public MenuActivity() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * This method is displaying a list of
	 * menu option to be selected by automatically on the screen
	 */
	public void showMenu() {
		// a variable assigned for reading input by user selection
		int option;

		// looping the list of menu option
		for(int i = 0; i < menu.createMenuSelection().size(); i=i+1) {
			// displaying the list of menu option
			System.out.println(i + 1 + " - " + menu.createMenuSelection().get(i));
		}
		// put extra line here
		System.out.println();

		// now reading input from keyboard by user
		option = readInput("Choose an option from the menu: ");

		// observe which option been selected
		// using switch cases option
		switch (option) {

		case 1:
			System.out.printf("----- The company from highest to lowest capital -----%n");
			company.highToLow();
			break;

		case 2:
			System.out.printf("----- The company from lowest to highest capital -----%n");
			break;

		case 3:
			System.out.printf("----- The investor from highest to lowest budget -----%n");
			investor.highToLow();
			break;

		case 4:
			System.out.printf("----- The investor from lowest to highest budget -----%n");
			investor.lowToHigh();
			break;

		case 5:
			System.out.printf("----- Displaying the company profiles -----%n");
			company.createUser();
			break;

		case 6:
			System.out.printf("----- Displaying the investor pprofiles -----%n");
			investor.createUser();
			break;

		case 7:
			System.out.printf("----- Displaying the stock market trading activity  pdetails -----%n");
			startTrading.start();
			break;

		case 8:
			System.out.printf("----- O my god, you'd quitted the program, anyway good luck -----%n");
			quit();
			break;

			// no selection then do nothing
		default:
				break;
		}
	}

	/** This method to quit the program. */

	private void quit() {
		System.out.println("I see you later, bye!");
		System.exit(0);
	}

}
