package design_patterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Company class represents the notion of a company,
 * and it must create dynamically 100 companies. All of them must have: 
 * A unique ID 
 * A random number of shares (between 500 and 1000)
 * A random share price (between 10 and 100)
 * a company capital
 * a company's share  unit sold
 * This class is used of builder design patterns
 * @author Kim Jang Wong 2017300
 * @date 04 May 2020
 * @note https://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html
 */

public class Company implements CompanyInterface, Comparable<Company> {

	/**The company global data fields. */

	// the company unique id
	private int id;
	// the company share
	private int share;
	// the company share's price
	private double price;
	// the company's capital
	private double capital;
	// the unit of shares sold by company
	private int unitSold;

	// create array list storage to hold companies
	static List<Company> listOfCompany = new ArrayList<Company>();
	static List<Company> listOfCompanyCopied = new ArrayList<Company>();

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
	public int getId() {
		return id;
	}

	/**
	 * Set the company id
	 * @param id the company id
	 */
	public void setId(int ids) {
		id = ids;
	}

	/**
	 * Get the company shares
	 * @return the share of the company as expected its value
	 */
	@Override
	public int getShare() {
		return share;
	}

	/**
	 * Set the share
	 * @param share the share
	 */
	@Override
	public void setShare(int shares) {
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
	public int getUnitSold() {
		return unitSold;
	}

	/**
	 * Set the unit sold share
	 * @param unitSold the unit sold of share
	 */
	@Override
	public void setUnitSold(int unitSolds) {
		unitSold = unitSolds;
	}

	/*
	 * Method to return a generate of 100 company
	 * prior to selling a share,
	 * this method must be invoked first and run it
	 * and it displays its properties
	 * @return the list of company
	 */
	public List<Company> createUser() {
		Company n;

		// the least unique id
		int minId = 1;
		// despite creation of 100 companies so far!
		int maxId = 1000;
		// the minimum share starting at 500 to 1000
		int minShare = 500;
		int maxShare = 1000;
		// the minimum company's share price from 10 to 1000
		double minPrice = 10;
		double maxPrice = 100;

		// create 100 company
		for(int i = 0; i < 100; i=i+1) {
			// generate an id from 1 to 1000
			id = (int) (Math.random() * (maxId - minId) + minId);
			// generate share from 500 to 1000
			share = (int) (Math.random() * (maxShare - minShare) + minShare);
			// generate price from 10 to 1000
			price = (double) (Math.random() * (maxPrice - minPrice) + minPrice);
			capital = 0; // as default value capital so far
			unitSold = 0; // as default values unit sold so far

			//setId(id);
			//setShare(share);
			//setPrice(price);
			//setCapital(capital);
			//setUnitSold(unitSold);

			n = new Company.CreateCompany(id, share, price, capital, unitSold).getCompany();

			// adding a new object into the storage
			// but array list work fine too
			listOfCompany.add(n);
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
	public List<Company> show() {
		int totalShares = 0;	
		double totalPrice = 0;
		int minPrice = 0;
		int maxPrice = 0;

		// for 100 companies
		for (int i = 0; i < listOfCompany.size(); i=i+1) {					
			totalShares += listOfCompany.get(i).getShare();
			totalPrice += listOfCompany.get(i).getPrice();

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
		System.out.printf("Total of shares registered to sell: %d%n", totalShares);
		System.out.printf("Total value of the shares price registered to sell: %.2f%n", totalPrice);	
		System.out.println();
		System.out.printf("Share with lowest price: %.2f%n",listOfCompany.get(minPrice).getPrice());
		System.out.printf("Share with highest price: %.2f%n",listOfCompany.get(maxPrice).getPrice());	
		System.out.println();

		return listOfCompany;
	}

	/*
	 * sorting and printing a top list from low,
	 * to high number of shares			
	 */
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

	/*
	 * Method Compares this object with the specified object for order.
	 * @param obj the object to be compared
	 * @returns a negative integer, zero, or a positive integer as this object is less than, equal to,
	 * or greater than the specified object.
	 */
		@Override
	public int compareTo(Company company) {
		if(this.capital > company.capital) {
			//returns high-low
			return -1; 
		}
		if (this.capital < company.capital) {
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
		private int share;
		// the company share's price
		private double price;
		// the company's capital
		private double capital;
		// the unit of shares sold by company
		private int unitSold;

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
		public CreateCompany(int ids, int shares, double prices, double capitals, int unitSolds) {
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

	}
}
