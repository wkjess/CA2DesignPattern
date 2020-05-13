package interfaces;

import java.util.List;

/**
 * InvestorInterface consists a set of getter and setter methods
 * It also to be implemented by its child class 
 * @author Kim Jang Wong
 * @date 23 April 2020
 *
 */

public interface InvestorInterface<E> {

	/**
	 * Get the user id
	 * @return the user id as expected its value
	 */
	public abstract int getId();

	/**
	 * Set the user id
	 * @param id the user id
	 */
	public abstract void setId(int id);

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
	public abstract double getUnitBought();

	/**
	 * Set the unit share bought by investor
	 * @param unitShares the unit share been bought by investor
	 */
	public abstract void setUnitBought(double unitBought);

	/*
	 * Method to return a generate of 100 user
	 * and it displays its properties
	 * @return the list of user
	 */
	public abstract List<E> createUser();

	/*
	 * display the user(s) and total of its budget
	 */
	public abstract List<E> show();

	/*
	 * sorting and printing a top list from low
	 * to high number of unit shares been bought
	 */
	public abstract List<E> lowToHigh();

	/*
	 * sorting and printing a top list from high
	 * to low number of unit shares been bought
	 */
	public abstract List<E> highToLow();

	/*
	 * Overriding the default string representation
	 * @return the string representation of this object
	 */
	public String toString();

	public abstract int compareTo(Object obj);

}
