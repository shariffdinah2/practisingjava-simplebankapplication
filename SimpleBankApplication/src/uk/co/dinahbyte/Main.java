package uk.co.dinahbyte;

import java.util.Scanner;

// https://javahungry.blogspot.com/2019/12/java-projects-for-beginners.html
// Working on first project

// Version 1
// Display informational message to user
// Display 5 options to user
// 1. Check Balance
// 2. Deposit
// 3. Withdraw
// 4. Check Previous Transaction
// 5. Exit
// Ask user to make a choice
// Process input



public class Main {
	private static final short VERSION_NUMBER = 1;
	private static BankAccount [] bankAccounts = new BankAccount[3];

	public static void main(String[] args) {
		System.out.println ("Starting simple bank application...");
		makeSomeBankAccounts();
		while (true) {
			showMenu();
			char selection = getInputFromUser();
			if (!processInput(selection)) {
				break;
			}
		}

	}
	
	
	private static void makeSomeBankAccounts() {
		BankAccount shariff = new BankAccount("shariff", 100);
		BankAccount faranaz = new BankAccount("faranaz", 200);
		bankAccounts[0] = shariff;
		bankAccounts[1] = faranaz;
		
	}


	private static void showMenu() {
		System.out.println("Welcome to Shariff Banking Application version " + VERSION_NUMBER);
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit Some Money");
		System.out.println("C. Withdraw Some Money");
		System.out.println("D. Check Previous Transaction");
		System.out.println("E. Exit the application");
		System.out.println("\n");				
		
	}
	
	private static char getInputFromUser() {
		System.out.println("Enter an option:");
		Scanner scanner = new Scanner (System.in);
		char input = scanner.next().toUpperCase().charAt(0);
		scanner.close();
		return input;
	}
	
	//returns false if exit chosen
	private static boolean processInput(char selection) {
		boolean retVal = true;
		
		switch (selection) {
		case 'A':
			checkBalance();
			break;
		case 'B':
			depositMoney();
			break;
		case 'C':
			withdrawMoney();
			break;
		case 'D':
			checkPrevTrans();
			break;
		case 'E':
			retVal = false;
			break;
		default:
			System.out.println("Incorrect option entered. Please try again.");
			break;
			
		}
		return retVal;
		
	}


	private static void checkPrevTrans() {
		BankAccount ba = findBankAccount(getCustomerName());
		if (ba != null) {
			ba.getPreviousTransaction();
		}
		
	}


	private static void withdrawMoney() {
		BankAccount ba = findBankAccount(getCustomerName());
		if (ba != null) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Amount to withdraw:");
			ba.withdraw(scanner.nextInt());
			scanner.close();
		}
		
	}


	private static void depositMoney() {
		BankAccount ba = findBankAccount(getCustomerName());
		if (ba != null) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Amount to deposit:");
			ba.deposit(scanner.nextInt());
			scanner.close();
		}
	}


	private static void checkBalance() {
		
		BankAccount ba = findBankAccount(getCustomerName());
		if (ba != null) {
			System.out.println("Balance is :" + ba.getBalance());
		}
		
	}


	private static String getCustomerName() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter CustomerName:");
		return scanner.next();
	}


	private static BankAccount findBankAccount(String name) {
		BankAccount ba = null;
		for (int i = 0; i < bankAccounts.length; i++) {
			ba = bankAccounts[i];
			if (ba != null && ba.getCustomerName().equals(name)) {
				return ba;
			}
		}
		System.out.println("Invalid customer name");
		return null;
	}
	
	

}
