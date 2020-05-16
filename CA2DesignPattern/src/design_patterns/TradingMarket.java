package design_patterns;

import java.util.List;
import java.util.Random;

/*
 * TradingMarket  class will simulate the stock market,
 * and allow investor and company to buy and sell their share
 * get both Company and Investor ArrayList
 * @author Kim Jang Wong 2017300
 * @date 09 May 2020
 */ 

public class TradingMarket {

	/** Create both company and investor array list which imported from the instance of Company and Investor. */

	// a reference array list of company
			List<Company> company = Company.listOfCompany;
	List<Company> companyTrades = Company.listOfCompanyCopied;

	// a reference array list of investor
	List<Investor> investor = Investor.listOfInvestor;
	List<Investor> investorTrades = Investor.listOfInvestorCopied;

	// generate a random index
	Random r = new Random();
		boolean valid;
	
	/** Constructs an empty constructor without its properties. */
	public TradingMarket() {}

/*
 * Method to allow investor to search for a share
 * from a list of company,
 * investor has to buy as many shares, one by one
 * then, subtract budget from investor and add the share into numberOfSharesBought,
 * after, subtract from Company the share sold and add the value into capital
 * Double up price: a company that has sold 10 shares, will have its price double up
 */
	public void buyShare() {
		
		TradingActivity tradingActivity = new TradingActivity();
		StopTrading stopTrading = new StopTrading(tradingActivity);		

		// random index from user
		
		int index = 0;
		int companyIndex = 0;

		// minimum amount of shares
				int minShares = 1;
				// the minimum share price
								int minPrice = 0;

								// for 100 companies
								
				for (int i = 0; i < Company.listOfCompany.size(); i=i+1) {
			if(Company.listOfCompany.get(i).getPrice() < Company.listOfCompany.get(minPrice).getPrice()) {
				minPrice = i;
			}
		}

				// for company to buy share
				// pick up random Company from the array list
				//then, check if the company has at least 1 share to sell
				// if so, check if the company has already 10 shares sold.
				// if yes, double up its price	
				//if a company has less than 1 share available,
				// then remove if from the list

		//now, pick up a company share randomly		
		try {
			valid = false;
			do {		
				companyIndex = r.nextInt(Company.listOfCompany.size());

				System.out.printf("%nGetting new negotiation%n");
								System.out.println(Company.listOfCompany.get(companyIndex));

								// now see if check the Company has at least 1 share to sell.
								// if yes, proceed to sell
								
				if(Company.listOfCompany.get(companyIndex).getShare() >= minShares) {
					System.out.printf("Shares are available to sell... %n%n");
					System.out.println(Company.listOfCompany.get(companyIndex));
					valid = true;
				}

				// now check if the Company has already 10 sales.
				// if yes, double up price
				
				if  (Company.listOfCompany.get(companyIndex).getUnitSold() == 10) {
					valid = true;
					System.out.printf("The shares are now double up the price%n");

					// double up the new price
					
					double price = Company.listOfCompany.get(companyIndex).getPrice() * 2;
					Company.listOfCompany.get(companyIndex).setPrice(price);
					System.out.println(Company.listOfCompany.get(companyIndex));
								}

				//then, if the Company has less than 1 share (0),
				// then remove from the list 
				
				if (Company.listOfCompany.get(companyIndex).getShare() < minShares ) {
					valid = false;
					System.out.println("The least share of this company being removed: " + Company.listOfCompany.get(companyIndex));
					
					companyTrades.add(Company.listOfCompany.get(index));
					Company.listOfCompany.remove(companyIndex); 					
				}
			} while (valid == false);	
					} catch(Exception exp) {
						System.out.printf("There are no shares are available this time, try again later%n");
						//go back to menu while simulation is completed
			stopTrading.respond();
		};

		// for Investors to buy share
				// pick up random Investor from the array list
				//if so, check if the Investor has enough money to buy the share from the company.
				// if yes, proceed to buy. if not,
				// change company and investor
				// if a Investor has a budget lower than the cheapest share,
				// then remove it from the list

		try {
			valid = false;
			do {					
				//first, pick up randomly a investor
				index = r.nextInt(Investor.listOfInvestor.size());

				System.out.printf("Searching investors... %n%n");
				System.out.println(Investor.listOfInvestor.get(index));

				// check if the investor has enough money to buy the shares from the company. If yes,
				// proceed to buy it
				
				if (Investor.listOfInvestor.get(index).getBudget() >= Company.listOfCompany.get(companyIndex).getPrice()) {
					valid = true;
					System.out.printf("Buying a share... %n%n");
					System.out.println(Investor.listOfInvestor.get(index));
				}

				// if not, then pick up another investor
				// pick up another company
				// or pick either of them and until find a potential investor to buy share
				
				if (Investor.listOfInvestor.get(index).getBudget() < Company.listOfCompany.get(companyIndex).getPrice()) {
					valid = false;
					System.out.printf("Failed to buy a share this time, try different amount and see next available lowest share%n");

					// or see any next available company,
					// has a bit lower share price to sell

					companyIndex = r.nextInt(Company.listOfCompany.size());
					System.out.printf("Searching the next available company for cheapest price of share%n%n");
					System.out.println(Company.listOfCompany.get(companyIndex));

					// or neither both investor or company are not available
					// to sell or buy this time

				}

				// if the budget is too low, then remove from the list				
				
				if(Investor.listOfInvestor.get(index).getBudget() <= Company.listOfCompany.get(minPrice).getPrice()) {
					valid = false;
					System.out.println("The Investor has lowest budget are being removed: " + Investor.listOfInvestor.get(index));
					System.out.println("The budget lower than " + Company.listOfCompany.get(minPrice).getPrice());
					investorTrades.add(Investor.listOfInvestor.get(index));
					Investor.listOfInvestor.remove(index);

					// there are no guarantee there are company
					// who has the lowest share to sell while
					// company this is only a simulation while investor has no enough money
					// to invest a share from the random pick company

				}
										} while (valid == false);
		} catch(Exception exp) {
			System.out.printf("There are no investors are available to buy share this time, try again later%n%n");
			// go back to menu while simulation is completed
			stopTrading.respond();
		};

		// deduct 1 share, add 1 share sold, add the value of the price to capital
		
		int shares = Company.listOfCompany.get(companyIndex).getShare() - 1;
		int sharesSold = Company.listOfCompany.get(companyIndex).getUnitSold() + 1;
		double capital = sharesSold * Company.listOfCompany.get(companyIndex).getPrice();

		// update the company list
		Company.listOfCompany.get(companyIndex).setShare(shares);
		Company.listOfCompany.get(companyIndex).setUnitSold(sharesSold);
		Company.listOfCompany.get(companyIndex).setCapital(capital);

		// deduct from budget the price of share, add 1 share bought
		
		int sharesBought = Investor.listOfInvestor.get(index).getUnitBought() + 1;
		double budget =  Investor.listOfInvestor.get(index).getBudget() - Company.listOfCompany.get(companyIndex).getPrice(); 		

		// update the investor list
		Investor.listOfInvestor.get(index).setBudget(budget);
		Investor.listOfInvestor.get(index).setUnitBought(sharesBought);

		//printing the updates

		System.out.printf("The both company and investor trading activity is updated%n");
		System.out.println(Company.listOfCompany.get(companyIndex));
		System.out.println(Investor.listOfInvestor.get(index));

		//display the update of the trade		
		displayUpdate();	

				}

	/** Method to update the stock market according to the array list. */
			public void displayUpdate() {
		
		//updating the stock market according to the arrays
		int totalShares = 0;
		double totalBudget = 0;

		// for company
		
		for (int i = 0; i < Company.listOfCompany.size(); i=i+1) {
			totalShares += Company.listOfCompany.get(i).getShare();
		}

		// for investor

		for (int i = 0; i < Investor.listOfInvestor.size(); i=i+1) {
			totalBudget += Investor.listOfInvestor.get(i).getBudget();			
		}

		System.out.printf("----- The stock market is being updated ----%n%n");
		System.out.printf("The shares available: %d%n", totalShares);
		System.out.printf("The budget available: %.2f%n", totalBudget);	
		System.out.println();

	}

			/** 		//Method will run until the program buyShare() 10000 times */
					public void simulation() {
						// see how if 5000 times to get buy share done!
						// if not, try 15,000 or even more times!
						
		for (int i = 0;  i < 25000; i=i+1) {
			buyShare();				
		}	

		System.out.printf("The simulation completed%n%n");
		displayUpdate();
	}

}
