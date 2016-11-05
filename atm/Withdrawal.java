package atm;

public class Withdrawal extends Transaction {

	private double amount;
	private BankDatabase currBankDatabase;

	public Withdrawal(int accountNumber, BankDatabase userBankDatabase) {
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
		boolean exitOption = false;
		boolean enoughMoney;

		while (!exitOption){
			exitOption = selectAmount();
			if (!exitOption){
				enoughMoney = checkEnoughBalance();
				if (enoughMoney){
					if ( CashDispenser.isSufficientCashAvailable(getAmount()) ){
						getMoney();
						exitOption = true;
					} else {
						Screen.displayMessageLine("Cash dispenser without enough money. Please select a smaller amount");
					}
				} else {
					Screen.displayMessageLine("You don't have enough money. Please select a smaller amount");
				}
			}
		}
	}

	private boolean selectAmount(){
		int userSelection;

		do {
			showMenu();
			userSelection = Keypad.getInput();
			switch (userSelection) {
			case 1:
				Screen.displayMessageLine("$20 withdrawal...");
				setAmount(20);
				break;
			case 2:
				Screen.displayMessageLine("$40 withdrawal...");
				setAmount(40);
				break;
			case 3:
				Screen.displayMessageLine("$60 withdrawal...");
				setAmount(60);
				break;
			case 4:
				Screen.displayMessageLine("$100 withdrawal...");
				setAmount(100);
				break;
			case 5:
				Screen.displayMessageLine("$200 withdrawal...");
				setAmount(200);
				break;
			case 6:
				Screen.displayMessageLine("Returning to main menu...");
				return true;
			default:
				Screen.displayMessageLine("Invalid choice. Please select again.\n\n");
			}
		} while ( (userSelection < 1) || (userSelection > 6) );
		return false;
	}

	private void showMenu(){
		Screen.displayMessageLine("\tWithdrawal menu");
		Screen.displayMessageLine("1 - $20\t\t4 - $100\n2 - $40\t\t5 - $200\n3 - $60\t\t6 - Cancel transaction");
		Screen.displayMessage("Choose a withdrawal amount: ");
	}

	private boolean checkEnoughBalance(){
		double balance = currBankDatabase.getAvailableBalance(getAccountNumber());
		return (balance >= getAmount()) ? (true) : (false);
	}

	private void getMoney(){
		currBankDatabase.debit(getAccountNumber(), getAmount());
		CashDispenser.dispenseCash(getAmount());
		Screen.displayMessageLine("Please get your money in the cash dispenser");
	}

}
