package atm;

public class Screen {

	//Display a message on system output
	public static void displayMessage(String message){
		System.out.printf(message);
	}
	
	//Display a message on system output, ending with a new line
	public static void displayMessageLine(String message){
		System.out.println(message);
	}
	
	//Display a message with the amount of money, ending with a new line
	public static void displayMoney(double amount){
		System.out.printf("$%.2f\n", amount);
	}

}
