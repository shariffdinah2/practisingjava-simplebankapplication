package uk.co.dinahbyte;

public class BankAccount {
	private int balance, previousTransaction;
	private String customerName, customerId;
	private static int customerCounter = 0;
	
	public BankAccount(String customerName, int initialBalance) {
		this.customerName = customerName;
		this.balance = initialBalance;
		this.customerId = Integer.toString(customerCounter);
		customerCounter++;
	}
	
	public String toString() {
		return "Bank Account Details for " + customerName + 
			   "\n Balance: " + balance + 
			   "\n CustomerId: " + customerId + "\n";
	}
	
	// Returns -1 in case of error
	// Else returns new balance value
	public int deposit (int amount) {
		if (amount <= 0) {
			System.out.println("invalid amount to deposit: " + amount);
			return -1;
		}
		
		balance += amount;
		previousTransaction = amount;
		return balance;
		
	}

	// Returns -1 in case of error
	// Else returns new balance value
	public int withdraw (int amount) {
		if (amount <= 0) {
			System.out.println("invalid amount to withdraw: " + amount);
			return -1;
		}
		
		balance -= amount;
		previousTransaction = -amount;
		return balance;
		
	}
	
	public void getPreviousTransaction() {
		if (previousTransaction == 0) {
			System.out.println("None");
			return;
		}
		if (previousTransaction > 0) {
			System.out.println("Deposited " + previousTransaction);
		} else {
			System.out.println("Withdrew " + previousTransaction);
		}
	}
	
}
