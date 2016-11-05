package atm;

public abstract class Transaction {

	private int accountNumber;
	
	public Transaction(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public abstract void execute();
	
}
