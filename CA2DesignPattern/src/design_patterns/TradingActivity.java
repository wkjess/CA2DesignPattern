package design_patterns;

/*
 * TradingActivity class represents as a handler request 
 * when receive the responsibility and dispatching from 
 * the implementation of its command class
 * @author Kim Jang Wong 2020
 * @date 09 May 2020
 * @note: https://www.geeksforgeeks.org/chain-responsibility-design-pattern/
 */
public class TradingActivity {

	/** Declaring the instance of the associated object. */

	TradingMarket tradingMarket = new TradingMarket();
	MenuActivity menuActivity = new MenuActivity();
	/*

	/* Method to start operating the trading activity. */
	public void startTrading() {
		System.out.printf("The Stock Market Simulation Is Being Processed%n");
		// invoke the buy share method to start 
		tradingMarket.buyShare();
		tradingMarket.simulation();		
	}

	/* Method to stop operating the trading activity. */
		public void stopTrading() {
		System.out.printf("The Stock Market Trading Simulation Has Completed%n%n");
		// invoke the display update result after completing the simulation
		tradingMarket.displayUpdate();
		// prompt the menu option again here
		menuActivity.showMenu();
	}

}
