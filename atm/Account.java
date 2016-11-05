package atm;

public class Account {
	
	private int accountNumber;
	private int PIN;
	private double availableBalance;
	private double totalBalance;
	
	public Account(int accountNumber, int PIN, double availableBalance, double totalBalance) {
		this.accountNumber = accountNumber;
		this.PIN = PIN;
		this.availableBalance = availableBalance;
		this.totalBalance = totalBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}
	
	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}
	
	public double getTotalBalance() {
		return totalBalance;
	}
	
	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}
	
	public boolean validatePIN(int userPIN){
		if (userPIN == PIN){
			return true;
		} else {
			return false;
		}
	}

	public void credit(double amount){
		setTotalBalance(getTotalBalance() + amount);
		if (DepositSlot.isEnvelopReceived()){
			setAvailableBalance(getAvailableBalance() + amount);
		}
	}
	
	public void debit(double amount){
		setTotalBalance(getTotalBalance() - amount);
		setAvailableBalance(getAvailableBalance() - amount);
	}

}
