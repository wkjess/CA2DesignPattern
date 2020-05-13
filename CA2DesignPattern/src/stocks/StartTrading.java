package stocks;

public class StartTrading {
	private TradingActivity tradingActivity;

	public StartTrading(TradingActivity tradingActivities) {
		tradingActivity = tradingActivities;
	}

	public void start() {
		tradingActivity.startTrading();
	}

}
