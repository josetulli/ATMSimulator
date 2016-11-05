package atm;

public class CashDispenser {
	
	private static int count = 10;
	
	//This method deliver amount of money user requested
	public static void dispenseCash(double amount){
		count -= (amount/20);
	}
	
	//This method check if amount required by user is available on account
	public static boolean isSufficientCashAvailable(double amount){
		if ( (amount/20) <= count){
			return true;
		} else {
			return false;
		}
	}

}
