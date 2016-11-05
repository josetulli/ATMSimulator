package atm;

public class Deposit extends Transaction {

	private double amount;
	private BankDatabase currBankDatabase;
	
	public Deposit(int accountNumber, BankDatabase userBankDatabase) {
		super(accountNumber);
		this.currBankDatabase = userBankDatabase;
	}

	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public void execute() {
		int userAmount;
		Screen.displayMessage("Type the deposit amount (in cents)\nor type 0 to cancel: ");
		userAmount = Keypad.getInput();
		if (userAmount != 0){
			setAmount (((double)userAmount) / 100);
			Screen.displayMessageLine("Please insert envelop on deposit slot...");
			if (DepositSlot.isEnvelopReceived()){
				Screen.displayMessage("Envelope received. The money\nwill be available after verification.");
				currBankDatabase.credit(getAccountNumber(), amount);
			} else {
				Screen.displayMessageLine("No envelope received. Transaction canceled.");
			}
		}
		Screen.displayMessageLine("Returning to main menu...\n\n");
	}
	
}
