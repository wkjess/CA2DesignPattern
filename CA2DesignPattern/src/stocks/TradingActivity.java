package stocks;

import menus.MenuActivity;

/*
 * TradingActivity class represents the stock market trading activity
 * It acts as a request class when user(s) perform a 
 * stock trading activity from an actual class
 * @author Kim Jang Wong 2017300
 * @date 03 May 2020
 */

public class TradingActivity {

	/** Initial the instance of any class associated to this class .*/

	StockTrading stockTrading = new StockTrading();
	MenuActivity menuActivity = new MenuActivity();

	/**
	 * Supplies an empty constructor when needed.
	 */
	public TradingActivity() {}

	/** Method to start to simulate the trading activity. */
	public void startTrading() {
		// invoke the buy share method to start the activity
		System.out.printf("The stock trading is operating (ON)%n");
		stockTrading.buyShare();
		stockTrading.simulation();
	}

	/** Method to stop to simulate the  trading activity. */
	public void stopTrading() {
		// invoke the display method to stop the activity and display it.
		System.out.printf("The stock trading is stop (OFF)%n");
		stockTrading.displayUpdate();
		// organise the menu selection 
		menuActivity.showMenu();
	}

}
