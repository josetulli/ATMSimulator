package atm;

public class BalanceInquiry extends Transaction {
	
	private BankDatabase currBankDatabase;

	public BalanceInquiry(int accountNumber, BankDatabase currBankDatabase) {
		super(accountNumber);
		this.currBankDatabase = currBankDatabase;
	}

	@Override
	public void execute() {
		double myAvailableBalance = currBankDatabase.getAvailableBalance(getAccountNumber());
		double myTotalBalance = currBankDatabase.getTotalBalance(getAccountNumber());

		Screen.displayMessage("Available balance = ");
		Screen.displayMoney(myAvailableBalance);
		Screen.displayMessage("Total balance = ");
		Screen.displayMoney(myTotalBalance);
	}

}
