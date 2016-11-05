package atm;

public class ATM {

	private boolean userAuthenticated;
	private int currAccountNumber;
	private BankDatabase bankDatabase;

	public ATM() {
		this.userAuthenticated = false;
		this.currAccountNumber = 0;
		this.bankDatabase = new BankDatabase();
	}

	public void run(){

		int choice;
		Transaction currTransaction;
		boolean runATM = true;

		while (runATM){

			choice = 0;
			Screen.displayMessageLine("Welcome!");
			userAuthenticated = authenticateUser();

			while (userAuthenticated){
				choice = mainMenu();
				switch (choice) {
				case 1:
					Screen.displayMessageLine("View my balance:\n");
					currTransaction = new BalanceInquiry(currAccountNumber, bankDatabase);
					currTransaction.execute();
					currTransaction = null;
					break;
				case 2:
					Screen.displayMessageLine("Withdraw cash:");
					currTransaction = new Withdrawal(currAccountNumber, bankDatabase);
					currTransaction.execute();
					currTransaction = null;
					break;
				case 3:
					Screen.displayMessageLine("Deposit funds");
					currTransaction = new Deposit(currAccountNumber, bankDatabase);
					currTransaction.execute();
					currTransaction = null;
					break;
				case 4:
					Screen.displayMessageLine("Good bye!\n\n\n");
					userAuthenticated = false;
					break;
				case 5:
					Screen.displayMessageLine("Stopping simulator...");
					runATM = false;
				default:
					Screen.displayMessageLine("Invalid choice. Please select again.");
				}
			}

		}

	}

	private boolean authenticateUser(){

		int counter = 1;
		int tempAccountNumber;
		int tempPIN;
		boolean flag = false;

		do {
			Screen.displayMessage("Please enter account number: ");
			tempAccountNumber = Keypad.getInput();
			Screen.displayMessage("Enter your PIN: ");
			tempPIN = Keypad.getInput();
			flag = bankDatabase.authenticateUser(tempAccountNumber, tempPIN);
			if (!flag){
				if (counter < 3){
					Screen.displayMessageLine("Wrong information. Please try again\n");
				} else {
					Screen.displayMessageLine("Wrong information. Can't log in\n");
				}
			} else {
				currAccountNumber = tempAccountNumber;
			}
			counter++;
		} while (!flag && (counter <= 3) );

		return flag;

	}

	private int mainMenu(){

		Screen.displayMessageLine("\n\nMain Menu");
		Screen.displayMessage("1 - View my balance\n2 - Withdraw cash\n3 - Deposit funds\n4 - Exit\n5 - End prog\nType one choice: ");
		return Keypad.getInput();

	}

}
