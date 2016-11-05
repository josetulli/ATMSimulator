package atm;

import java.util.Scanner;

public class ATMUse {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		ATM ATMSim = new ATM();
		ATMSim.run();

		in.close();
	}

}
