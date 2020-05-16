package design_patterns;

/*
 * MainActivity class is to respond the main method
 * when the menu activity is been invoked
 * @author Kim Jang Wong 2017300
 * @date 10 May 2020
 */

public class MainActivity {

	public static void main(String[] args) {

		// create the instance of the menu activity and call its method
		
		MenuActivity menuActivity = new MenuActivity();
		menuActivity.showMenu();

	}

}
