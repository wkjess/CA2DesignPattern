package design_patterns;

/**
 * InvestorInterface consists a set of getter and setter methods
 * It also to be implemented by its child class 
 * @author Kim Jang Wong
 * @date 23 April 2020
 *
 */

public interface InvestorInterface {

	/**
	 * Get the investor budget
	 * @return the investor budget as expected its value
	 */
	public abstract double getBudget();

	/**
	 * Set the investor budget
	 * @param budget the investor budget
	 */
	public abstract void setBudget(double budget);

	/**
	 * Get the investor unit share been bought
	 * @return the investor been bought unit share as expected its value
	 */
	public abstract int getUnitBought();

	/**
	 * Set the unit share bought by investor
	 * @param unitShares the unit share been bought by investor
	 */
	public abstract void setUnitBought(int unitBought);

}
