package design_patterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Investor class represents the notion of an investor,
 * and it must create dynamically 100 investors. All of them must have: 
 * A unique ID 
 * A random budget between 1000 and 10000
 * a unit bought of share
 *  * This class is used of builder design patterns
 * @author Kim Jang Wong 2017300
 * @date 04 May 2020
 * @note https://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html
 */ 

public class Investor implements InvestorInterface, Comparable<Investor> {

	/**The investor global data fields. */

	// the investor unique id
	private int id;
	// the investor budget
	private double budget;
	// the unit of shares bought by investor
	private int unitBought;

	// create an array list to store the investor object
	static List<Investor> listOfInvestor = new ArrayList<Investor>();
	static List<Investor> listOfInvestorCopied = new ArrayList<Investor>();

	/*
	 * add a private constructor and implement it in the inner class inner class
	 * @param the instance of the inner class
	 */
	private Investor(CreateInvestor createInvestor) {
		id = createInvestor.id;
		budget = createInvestor.budget;
		unitBought = createInvestor.unitBought;
	}

	/**
	 * Get the investor id
	 * @return the investor id as expected its value
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the investor id
	 * @param id the investor id
	 */
	public void setId(int ids) {
		id = ids;
	}

	/**
	 * Get the investor budget
	 * @return the investor budget as expected its value
	 */
	@Override
	public double getBudget() {
		return budget;
	}

	/**
	 * Set the investor budget
	 * @param budget the investor budget
	 */
	@Override
	public void setBudget(double budgets) {
		budget = budgets;
	}

	/**
	 * Get the investor unit share been bought
	 * @return the investor been bought unit share as expected its value
	 */
	@Override
	public int getUnitBought() {
		return unitBought;
	}

	/**
	 * Set the unit share bought by investor
	 * @param unitShares the unit share been bought by investor
	 */
	@Override
	public void setUnitBought(int unitBoughts) {
		unitBought = unitBoughts;
	}

	/*
	 * Method to return a generate of 100 investor
	 * prior to buying a share,
	 * this method must be invoked first and run it
	 * and it displays its properties
	 * @return the list of investor
	 */
	public List<Investor> createUser() {
		Investor n;
		// the least unique id
		int minId = 1;
		// despite creation of 100 investors so far!
		int maxId = 1000;
		// the minimum budget starting at 1000 to 10000
		double minBudget = 1000;
		double maxBudget = 10000;
		// create 100 investor
		for(int i = 0; i < 100; i=i+1) {
			id = (int) (Math.random() * (maxId - minId) + minId);
			budget = (double) (Math.random() * (maxBudget - minBudget) + minBudget);
			unitBought = 0; // as default values invested so far

			//setId(id);
			//setBudget(budget);
			//setUnitShares(unitShares);

			n = new Investor.CreateInvestor(id, budget, unitBought).getInvestor();

			// adding a new object into the storage
			// but array list work fine too
			listOfInvestor.add(n);
		}

		// display numbers of investors are registered
		show();
		return listOfInvestor;
	}

	/*
	 * display the investors and total of its budget
	 */
	public List<Investor> show() {
		// display the investors and total of budget

		double total = 0;
		for (int i = 0; i < listOfInvestor.size(); i=i+1) {					
			total += listOfInvestor.get(i).getBudget();				
		}	

		System.out.println();
		System.out.println(listOfInvestor);
		System.out.println();
		// display numbers of investors are registered
		System.out.printf("There are total numbers of %-2d investors are registered%n%n", listOfInvestor.size());
		System.out.printf("Total amount of budget: %.2f%n", total);
		System.out.println();

		return listOfInvestor;
	}

	/*
	 * sorting and printing a top list from low
	 * to high number of unit shares been bought
	 */
	public List<Investor> lowToHigh() {
		Collections.sort(Investor.listOfInvestor);
		System.out.println(Investor.listOfInvestor);
		System.out.println();
		//or just print according to the size of the array		
		Collections.sort(Investor.listOfInvestorCopied);			
		System.out.println(Investor.listOfInvestorCopied);

		return Investor.listOfInvestorCopied;
	}

	/*
	 * reversing and printing a top list from high
	 * to low number of unit shares been bought
	 */
	public List<Investor> highToLow(){
		//reversing the sorted list		
		Collections.reverse(Investor.listOfInvestor);
		System.out.println(Investor.listOfInvestor);

		System.out.println();		
		Collections.reverse(Investor.listOfInvestorCopied);
		System.out.println(Investor.listOfInvestorCopied);

		return Investor.listOfInvestor;
	}	

	/*
	 * Overriding the default string representation
	 * @return the string representation of this object
	 */
	@Override
	public String toString() {
		String result = "Investor ID: " + id + " | " +
				"Invested Budget: " + budget + " | " +
				"Bought Unit Shares: " + unitBought + "\n";
		return result;
	}

	/*
	 * Method Compares this object with the specified object for order.
	 * @param obj the object to be compared
	 * @returns a negative integer, zero, or a positive integer as this object is less than, equal to,
	 * or greater than the specified object.
	 */
	@Override
	public int compareTo(Investor invest) {
		if(unitBought > invest.unitBought) {
			return -1;
		}
		if(unitBought < invest.unitBought) {
			return 1;
		}
		return 0;
	}

	/** Create an inner class to standing for class investor. */

	public static class CreateInvestor {

		/** Declare the same attributes that use in investor. */

		// the investor unique id
		private int id;
		// the investor budget
		private double budget;
		// the unit of shares bought by investor
		private int unitBought;

		/** Constructs an empty constructor without its properties. */
		public CreateInvestor() {}

		/*
		 * Constructs the inner class instance with its properties (as Investor)
		 * @param id the id
		 * @param budget the budget
		 * @param unitShares the unit share been bought
		 */
		public CreateInvestor(int ids, double budgets, int unitBoughts) {
			id = ids;
			budget = budgets;
			unitBought = unitBoughts;
		}

		/*
		 * Method to get an instance of the investor
		 * @return the new instance of the investor
		 */
		public Investor getInvestor() {
			return new Investor(this);
		}
	}

}
