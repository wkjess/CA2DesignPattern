package design_patterns;

/**
 * CompanyInterface consists a set of getter and setter methods
 * It also extends use of InvestorInterface's method to be implemented by its child class 
 * @author Kim Jang Wong
 * @date 23 April 2020
 *
 */

public interface CompanyInterface {

	/**
	 * Get the company shares
	 * @return the share of the company as expected its value
	 */
	public abstract int getShare();

	/**
	 * Set the company share
	 * @param share the share
	 */
	public abstract void setShare(int share);

	/**
	 * Get the company share price
	 * @return the share price of the company as expected its value
	 */
	public abstract double getPrice();

	/**
	 * Set the share price
	 * @param price the share price
	 */
	public abstract void setPrice(double prices);

	/**
	 * Get the company capital
	 * @return the capital of the company as expected its value
	 */
	public abstract double getCapital();

	/**
	 * Set the capital
	 * @param capital the capital
	 */
	public abstract void setCapital(double capatals);

	/**
	 * Get the company unit sold share
	 * @return the unit sold share of the company as expected its value
	 */
	public abstract int getUnitSold();

	/**
	 * Set the unit sold share
	 * @param unitSold the unit sold of share
	 */
	public abstract void setUnitSold(int unitSolds);

}
