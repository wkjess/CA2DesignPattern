package users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NullPointerException;
import java.util.Random;

import interfaces.*;

/*
 * The system must create dynamically 100 companies. All of them must have: 
 * A unique ID 
 * A random number of shares (between 500 and 1000)
 * A random share price (between 10 and 100)
 * Any other attribute that you consider relevant to the context 
 * Builder Pattern Applied
 */

public class Company implements CompanyInterface {

	/**The company global data fields. */

	// the company unique id
	private int id;
	// the company share
	private double share;
	// the company share's price
	private double price;
	// the company's capital
	private double capital;
	// the unit of shares sold by company
	private double unitSold;

	// create array list storage to hold companies (see how first)
	static ArrayList<Company> listOfCompany = new ArrayList<Company>();
	static ArrayList<Company> listOfCompanyCopied = new ArrayList<Company>();

	/** I might not use this constructor
	// Constructs an empty constructor without its properties. 
	public Company() {}
	 */

	/** it'd work if a nested class be invoked outside this constructor
	public Company(int ids, double shares, double prices, double capitals, double unitSolds) {
		id = ids;
		share = shares;
		price = prices;
		capital = capitals;
		unitSold = unitSolds;
	}
	 */

	/*
	 * add a private constructor and implement it in the inner class inner class
	 * @param the instance of the inner class
	 */
	private Company(CreateCompany createCompany) {
		id = createCompany.id;
		share = createCompany.share;
		price = createCompany.price;
		capital = createCompany.capital;
		unitSold = createCompany.unitSold;
	}

	/**
	 * Get the company id
	 * @return the company id as expected its value
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * Set the company id
	 * @param id the company id
	 */
	@Override
	public void setId(int ids) {
		id = ids;
	}

	/**
	 * --- This part was implemented by investor,
	 * so just ignore it!
	 */

	/**
	 * Get the investor budget
	 * @return the investor budget as expected its value
	 */
	@Override
	public double getBudget() {}

	/**
	 * Set the investor budget
	 * @param budget the investor budget
	 */
	@Override
	public void setBudget(double budgets) {}

	/**
	 * Get the investor unit share been bought
	 * @return the investor been bought unit share as expected its value
	 */
	@Override
	public double getUnitBought() {}

	/**
	 * Set the unit share bought by investor
	 * @param unitShares the unit share been bought by investor
	 */
	@Override
	public void setUnitBought(double unitBoughts) {}

	/** --- End of implementation investor interface ------ */

	/**
	 * Get the company shares
	 * @return the share of the company as expected its value
	 */
	@Override
	public double getShare() {
		return share;
	}

	/**
	 * Set the share
	 * @param share the share
	 */
	@Override
	public void setShare(double shares) {
		share = shares;
	}

	/**
	 * Get the company share price
	 * @return the share price of the company as expected its value
	 */
	@Override
	public double getPrice() {
		return price;
	}

	/**
	 * Set the share price
	 * @param price the share price
	 */
	@Override
	public void setPrice(double prices) {
		price = prices;
	}

	/**
	 * Get the company capital
	 * @return the capital of the company as expected its value
	 */
	@Override
	public double getCapital() {
		return capital;
	}

	/**
	 * Set the capital
	 * @param capital the capital
	 */
	@Override
	public void setCapital(double capitals) {
		capital = capitals;
	}

	/**
	 * Get the company unit sold share
	 * @return the unit sold share of the company as expected its value
	 */
	@Override
	public double getUnitSold() {
		return unitSold;
	}

	/**
	 * Set the unit sold share
	 * @param unitSold the unit sold of share
	 */
	@Override
	public void setUnitSold(double unitSolds) {
		unitSold = unitSolds;
	}

	/*
	 * Method to return a generate of 100 company
	 * and it displays its properties
	 * @return the list of company
	 */
	@Override
	public List<Company> createUser() {
		Company company;

		// the least unique id
		int minId = 1;
		// despite creation of 100 companies so far!
		int maxId = 1000;
		// the minimum share starting at 500 to 1000
		double minShare = 500;
		double maxShare = 1000;
		// the minimum company's share price from 10 to 1000
		double minPrice = 10;
		double maxPrice = 1000;

		// create 100 company
		for(int i = 0; i < 100; i=i+1) {
			// generate an id from 1 to 1000
			id = (int) (Math.random() * (maxId - minId) + minId);
			// generate share from 500 to 1000
			share = (double) (Math.random() * (maxBudget - minBudget) + minBudget);
			// generate price from 10 to 1000
			price = (double) (Math.random() * (maxPrice - minPrice) + minPrice);
			capital = 0; // as default value capital so far
			unitSold = 0; // as default values unit sold so far

			//setId(id);
			//setShare(share);
			//setPrice(price);
			//setCapital(capital);
			//setUnitSold(unitSold);

			company = new Company.CreateCompany(id, share, price, capital, unitSold).getCompany();

			// adding a new object into the storage
			// but array list work fine too
			listOfCompany.add(company);
		}

		// display numbers of companies are registered
		show();
		return listOfCompany;
	}

	/*
	 * Method to display the company,
	 * total of shares and total price registered.
	 * @return the array list of the companies
	 */
	@Override
	public List<Company> show() {
		double totalShares = 0;	
		double totalPrice = 0;
		int minPrice = 0;
		int maxPrice = 0;

		// for 100 companies
		for (int i = 0; i < listOfCompany.size(); i=i+1) {					
			totalShares = totalShares + listOfCompany.get(i).getShare();
			totalPrice = totalPrice + listOfCompany.get(i).getPrice();

			if(listOfCompany.get(i).getPrice() < listOfCompany.get(minPrice).getPrice()) {
				minPrice = i;
			}
			if(listOfCompany.get(i).getPrice() > listOfCompany.get(maxPrice).getPrice()) {
				maxPrice = i;
			}
		}	

		System.out.println(listOfCompany);
		System.out.println();
		System.out.printf("There are Numbers of %d Companies are registered%n%n", listOfCompany.size());
		System.out.println("Total of shares registered to sell: " + totalShares);	
		System.out.println("Total value of the shares registered to sell: " + totalPrice);	
		System.out.println();
		System.out.println("Share with lowest price: " + listOfCompany.get(minPrice).getPrice());
		System.out.println("Share with highest price: " + listOfCompany.get(maxPrice).getPrice());	
		System.out.println();

		return listOfCompany;
	}

	/*
	 * sorting and printing a top list from low,
	 * to high number of shares			
	 */
	@Override
	public List<Company> lowToHigh() {
		Collections.sort(Company.listOfCompany);
		System.out.println(Company.listOfCompany);
		System.out.println();

		// sorting and printing a top list from low to high number of shares			
		//printing copy list

		Collections.sort(Company.listOfCompanyCopied);
		System.out.println(Company.listOfCompanyCopied);			

		return Company.listOfCompany;
	}

	/*
	 * reversing and printing a top list from high,
	 * to low number of shares			
	 */
	@Override
	public List<Company> highToLow() {
		//reversing the sorted list		
		Collections.reverse(Company.listOfCompany);
		System.out.println(Company.listOfCompany);
		System.out.println();

		//printing copy list
		Collections.sort(Company.listOfCompanyCopied);
		System.out.println(Company.listOfCompanyCopied);

		return Company.listOfCompany;
	}		

	/**
	 * Overriding the default string representation of this object
	 * It displays a string representation of this object to the screen
	 * @return the string representation of this object 
	 */
	@Override
	public String toString() {
		String result = "Company ID: " + id + " | " +
				"Company Share: " + share + " | " +
				"Company's Share Price: " + price + " | " +
				"Company's Capital: " + capital + " | " +
				"Unit Sold: " + unitSold + "\n";
		return result;
	}

	@Override
	public int compareTo(Object obj) {
		if(obj == null) {
			throw new NullPointerException("Null Pointer");
		}
		Company com = (Company) obj;
		if(capital > com.capital) {
			//returns high-low
			return -1; 
		}
		if (capital < com.capital) {
			//returns low-high
			return 1; 
		} 
		return 0;		
	}

	/** Create an inner class to standing for class investor. */

	public static class CreateCompany {

		/** Declare the same attributes that use in company. */

		// the company unique id
		private int id;
		// the company share
		private double share;
		// the company share's price
		private double price;
		// the company's capital
		private double capital;
		// the unit of shares sold by company
		private double unitSold;

		/** Constructs an empty constructor without its properties. */
		public CreateCompany() {}

		/*
		 * Constructs the company with its specified properties
		 * @param id the company id
		 * @param share the company share
		 * @param price the company share
		 * @param capital the company capital
		 * @param unitSold the company share unit sold
		 */
		public CreateCompany(int ids, double shares, double prices, double capitals, double unitSolds) {
			id = ids;
			share = shares;
			price = prices;
			capital = capitals;
			unitSold = unitSolds;
		}

		/*
		 * Method to get an instance of the company
		 * @return the new instance of the company
		 */
		public Company getCompany() {
			return new Company(this);
		}

		/*
		 * Get the company id
		 * by using its parent's interface
		 * @return the company id
		 */
		public int getId() {
			return id;
		}

		/*
		 * Set the company id
		 * by using its parent's interface
		 * @param id the company id
		 */
		public void setId(int ids) {
			id = ids;
		}

		/*
		 * Get the company share
		 * by using its parent's interface
		 * @return the company share
		 */
		public double getShare() {
			return share;
		}

		/*
		 * Set the company share
		 * by using its parent's interface
		 * @param share the company share
		 */
		public void setShare(double shares) {
			share = shares;
		}

		/*
		 * Get the company share price
		 * by using its parent's interface
		 * @return the company share price
		 */
		public double getPrice() {
			return price;
		}

		/*
		 * Set the company share
		 * by using its parent's interface
		 * @param share the company share
		 */
		public void setPrice(double prices) {
			price = prices;
		}

		/*
		 * Get the company capital
		 * by using its parent's interface
		 * @return the company capital
		 */
		public double getCapital() {
			return capital;
		}

		/*
		 * Set the company capital
		 * by using its parent's interface
		 * @param capital the company capital
		 */
		public void setCapital(double capitals) {
			capital = capitals;
		}

		/*
		 * Get the company unit sold
		 * by using its parent's interface
		 * @return the company unit share been sold
		 */
		public double getUnitSold() {
			return unitSold;
		}

		/*
		 * Set the company unit sold
		 * by using its parent's interface
		 * @param unitSold the company unit share been sold
		 */
		public void setUnitSold(double unitSolds) {
			unitSold = unitSolds;
		}

	}
}
