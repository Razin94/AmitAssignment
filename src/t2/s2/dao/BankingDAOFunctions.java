package t2.s2.dao;

import java.util.Scanner;

// Import the package in order to use the setter and getter methods
// The use of encapsulation
import t2.s2.pojo.UserAccess;

// In this class it gets its method's from the interface
// This is where you execute the abstract methods
// First you need to implement this class to the interface. So the Interface becomes the parent
// This makes the Interface the parent and this class the child

public class BankingDAOFunctions implements BankingDAO {
	
	// In this method create the what the methods of the interface do
	
	int depositAmount, withdrawAmount;
	static int balanceAmount = 0; // For now we are starting with just 0 in the bank account
	Scanner userInput = new Scanner(System.in);
	
	// Use override
	// This is so the class can implement the method in the way it needs it
	// This is an example of PolyMorphism

	@Override
	public void balance() {
		
		// This method is now to show bank balance
		System.out.println("THe current balance of your account is: " + balanceAmount);
		
	}

	@Override
	public void deposit(UserAccess refUA) {
		
		// This method is to deposit more money
		// First get how much money user wants to deposit
		System.out.println("How much money do you wish to deposit");
		depositAmount = userInput.nextInt();
		
		// Then use the POJO file to handle the flow of the variables (Encapsulation)
		refUA.setAmount(depositAmount);
		balanceAmount = balanceAmount + refUA.getAmount();
		balance();
	}

	@Override
	public void withdraw(UserAccess refUA) {
		// This method will handle the withdrawal of money
		System.out.println("How much money do you wish to withdraw");
		withdrawAmount = userInput.nextInt();
		
		// Use the setter and getter class
		refUA.setAmount(withdrawAmount);
		balanceAmount = balanceAmount - refUA.getAmount();
		balance();
	}
	
}
