package atm;

public class BankDatabase {

	private Account bankAccounts[] = new Account[5];
	
	public BankDatabase() {
		bankAccounts[0] = new Account(123, 123, 1000.01, 1000.01);
		bankAccounts[1] = new Account(321, 123, 2000, 2500);
		bankAccounts[2] = new Account(111, 123, 100.99, 200.98);
		bankAccounts[3] = new Account(222, 123, 344.20, 429.84);
		bankAccounts[4] = new Account(333, 123, 368.29, 4027.33);
	}

	public boolean authenticateUser(int userAccountNumber, int userPIN){
		Account currAccount;
		currAccount = getAccount(userAccountNumber);
		if (currAccount == null){
			return false;
		} else {
			return currAccount.validatePIN(userPIN);
		}
	}
	
	private Account getAccount(int userAccountNumber){
		for (Account accounts : bankAccounts){
			if (accounts.getAccountNumber() == userAccountNumber)
				return accounts;
		}
		return null;
	}
	
	public double getAvailableBalance(int userAccountNumber){
//		Account currAccount;
//		currAccount = getAccount(userAccountNumber);
//		return currAccount.getAvailableBalance();
		//First improvement:
		return getAccount(userAccountNumber).getAvailableBalance();
	}
	
	public double getTotalBalance(int userAccountNumber){
		return getAccount(userAccountNumber).getTotalBalance();
	}
	
	public void credit(int userAccountNumber, double amount){
		getAccount(userAccountNumber).credit(amount);
	}
	
	public void debit(int userAccountNumber, double amount){
		getAccount(userAccountNumber).debit(amount);
	}

}
