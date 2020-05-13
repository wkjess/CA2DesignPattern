package stocks;

public class StopTrading {

	private TradingActivity tradingActivity;

	public StopTrading(TradingActivity tradingActivities) {
		tradingActivity = tradingActivities;
	}

	public void stop() {
		tradingActivity.stopTrading();
	}

}
