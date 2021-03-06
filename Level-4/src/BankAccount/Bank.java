package BankAccount;

import java.util.ArrayList;

public class Bank {
	private ArrayList<Account> accounts;
	
	public Bank(){
		accounts = new ArrayList<Account>();
	}
	
	public void addAccount(Account account, int accountNum) throws PreviouslyExistingAccountException{
		for(Account a: accounts){
			if(a.getAccountNum() == accountNum){
				throw new PreviouslyExistingAccountException("Account number already exists");
			}
		}
		account.setAccountNum(accountNum);
		accounts.add(account);
	}
	
	public void removeAccount(int accountNum) throws NonExistantAccountException{
		int i = 0;
		for(Account a: accounts){
			if(a.getAccountNum() == accountNum){
				accounts.remove(i);
				return;
			}
			i++;
		}
		throw new NonExistantAccountException("No account exists with this account number");
	}
	public void addMoney(int accountNum, float amount) throws NonExistantAccountException{
		for(Account a: accounts){
			if(a.getAccountNum() == accountNum){
				a.addMoney(amount);
				return;
			}
		}
		throw new NonExistantAccountException("No account exists with this account number");
	}
	public void widthdrawMoney(int accountNum, float amount) throws AccountOverdrawnException, NonExistantAccountException{
		int i = 0;
		for(Account a: accounts){
			if(a.getAccountNum() == accountNum){
				a.widthdrawMoney(amount);
				return;
			}
		}
		throw new NonExistantAccountException("No account exists with this account number");
	}
}
