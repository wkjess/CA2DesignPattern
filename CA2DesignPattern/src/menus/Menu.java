package menus;

import java.util.ArrayList;
import java.util.List;

/*
 * Class Menu represents the main activity for
 * displays the selection of menu to choose from number
 * respectively
 * It displays the result of the simulation, with the following options:
 * Company with the highest capital (number of shares times (x) latest share price)  
 * Company with the lowest capital (number of shares times (x) latest share price) 
 * If there are more than one company at the top or bottom position, they all should be displayed in the result
 * Investor with the highest number of shares 
 * Investor with the lowest number of shares 
 * It there is more than one investor in any of the positions, they all should be displayed in the result.  
 *@author Kim Jang Wong
 *@date 20 April 2020
 */

public class Menu {

	private List<String> selection; // a list of menu selection

	/** Constructs empty constructor for this property. */
	public Menu() {
		createMenuSelection();
	}

	/*
	 * Create menu option to be selected by user
	 * while option will be taken from keyboard.
	 */
	public List<String> createMenuSelection() {
		// create array list object
		selection = new ArrayList<>();

		// add menu item into the array list
		selection.add("Companies with Highiest Capital");
		selection.add("Companies with Lowest Capital");
		selection.add("Investors with Highiest number of Shares");
		selection.add("Investors with Lowest number of Shares");
		selection.add("Display Companies");
		selection.add("Display Investors");
		selection.add("Testing Reports");

				return selection;
	}

	/* Getter methods. */
	public List<String> getMenuSelection() {
		return selection;
	}

}
