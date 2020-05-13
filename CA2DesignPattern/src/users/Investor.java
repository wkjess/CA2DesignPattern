package users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NullPointerException;
import java.util.Random;

import interfaces.InvestorInterface;

/*
 * The system must create dynamically 100 investors. All of them must have: 
 * A unique ID 
 * A random budget between 1000 and 10000 
 * Any other attribute that you consider relevant to the context 
 * Data Pattern applied: Builder Class
 */

public class Investor implements InvestorInterface<Investor> {

	/**The investor global data fields. */

	// the investor unique id
	private int id;
	// the investor budget
	private double budget;
	// the unit of shares bought by investor
	private double unitBought;

	// create an array list to store the investor object
	static ArrayList<Investor> listOfInvestor = new ArrayList<Investor>();
	static ArrayList<Investor> listOfInvestorCopied = new ArrayList<>();

	/*
	public Investor() {}
	 */

	/** it'd work if a nested class be invoked outside this constructor
	public Investor(int ids, double budgets, double unitShare) {
		id = ids;
		budget = budgets;
		unitShares = unitShare;
	}
	 */

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
	@Override
	public int getId() {
		return id;
	}

	/**
	 * Set the investor id
	 * @param id the investor id
	 */
	@Override
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
	public double getUnitBought() {
		return unitBought;
	}

	/**
	 * Set the unit share bought by investor
	 * @param unitShares the unit share been bought by investor
	 */
	@Override
	public void setUnitBought(double unitBoughts) {
		unitBought = unitBoughts;
	}

	/*
	 * Method to return a generate of 100 investor
	 * and it displays its properties
	 * @return the list of investor
	 */
	@Override
	public List<Investor> createUser() {
		Investor investor;
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

			investor = new Investor.CreateInvestor(id, budget, unitBought).getInvestor();

			// adding a new object into the storage
			// but array list work fine too
			listOfInvestor.add(investor);
		}

		// display numbers of investors are registered
		show();
		return listOfInvestor;
	}

	/*
	 * display the investors and total of its budget
	 */
	@Override
	public List<Investor> show() {
		// display the investors and total of budget

		double total = 0;
		for (int i = 0; i < listOfInvestor.size(); i=i+1) {					
			total = total + listOfInvestor.get(i).getBudget();				
		}	

		System.out.println();
		System.out.println(listOfInvestor);
		System.out.println();
		// display numbers of investors are registered
		System.out.printf("There are total of %-2d investors are registered%n%n", listOfInvestor.size());
		System.out.println("Total amount of budget: " + getBudget());	
		System.out.println();

		return listOfInvestor;
	}

	/*
	 * sorting and printing a top list from low
	 * to high number of unit shares been bought
	 */
	@Override
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
	 * sorting and printing a top list from high
	 * to low number of unit shares been bought
	 */
	@Override
	public ArrayList<Investor> highToLow(){
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

	@Override
	public int compareTo(Object obj) {
		if(obj == null) {
			throw new NullPointerException("Null Pointer");
		}
		Investor investor = (Investor) obj;
		if(unitBought > investor.unitBought) {
			return -1;
		}
		if(unitBought < investor.unitBought) {
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
		private double unitBought;

		/** Constructs an empty constructor without its properties. */
		public CreateInvestor() {}

		/*
		 * Constructs the inner class instance with its properties (as Investor)
		 * @param id the id
		 * @param budget the budget
		 * @param unitShares the unit share been bought
		 */
		public CreateInvestor(int ids, double budgets, double unitBoughts) {
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

		/*
		 * Get the investor id
		 * by using its parent's interface
		 * @return the investor id
		 */
		public int getId() {
			return id;
		}

		/*
		 * Set the investor id
		 * by using its parent's interface
		 * @param id the investor id
		 */
		public void setId(int ids) {
			id = ids;
		}

		/*
		 * Get the investor budget
		 * by using its parent's interface
		 * @return the investor budget
		 */
		public double getBudget() {
			return budget;
		}

		/*
		 * Set the investor budget
		 * by using its parent's interface
		 * @param budget the investor budget
		 */
		public void setBudget(double budgets) {
			budget = budgets;
		}

		/*
		 * Get the investor bought unit share
		 * by using its parent's interface
		 * @return the investor bought unit share
		 */
		public double getUnitBought() {
			return unitBought;
		}

		/*
		 * Set the investor bought unit share
		 * by using its parent's interface
		 * @param unitShare the investor bought unit share
		 */
		public void setUnitBought(double unitBoughts) {
			unitBought = unitBoughts;
		}

	}

}
