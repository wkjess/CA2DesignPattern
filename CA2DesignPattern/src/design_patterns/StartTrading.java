package design_patterns;

/*
 * StartTrading class is a concrete class and has a set of method to allow
 * its implemented class to facilitate the change of responsibility
 * to change the state of the behaviour.
 * @author Kim Jang Wong 2017300
 * @date 07 May 2020
 * @note https://moodle.cct.ie/course/view.php?id=1505
 */

public class StartTrading implements Command {

	//declaring request class
	TradingActivity tradingActivity;

	public StartTrading(TradingActivity tradingActivities) {
		tradingActivity = tradingActivities;
	}

	/*
	 * Method to change the responsibility when
	 * a request class need it to start the trading activity
	 */
	@Override
	public void respond() {
		tradingActivity.startTrading(); 
	}

}
