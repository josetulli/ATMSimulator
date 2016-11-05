package atm;

import java.util.Scanner;

public class Keypad {
	
	//This method gets input from the user and only accepts integer values
	public static int getInput(){
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int input;
		
		while (!in.hasNextInt()){
			Screen.displayMessageLine("Wrong input. Please type an integer value!\n");
			in.next();
		}
		input = in.nextInt();
		return input;
	}

}
