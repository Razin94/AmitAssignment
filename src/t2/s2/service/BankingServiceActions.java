package t2.s2.service;

// Import the Scanner class for user input
import java.util.Scanner;

// Import the necessary packages
import t2.s2.dao.BankingDAO;
import t2.s2.dao.BankingDAOFunctions;
import t2.s2.pojo.UserAccess;

public class BankingServiceActions implements BankingService {
	// In this class we are going to use the methods in the BankingService interface to carry out the user account
	// Create the variables of the class
	Scanner userType = new Scanner(System.in);
	BankingDAO refBankDAO = new BankingDAOFunctions();
	UserAccess refUA = new UserAccess();
	
	// Create the variables
	// This set of variables is to act as an existing user
	String emailValidate = "xyz@gmail.com";
	String passwordValidate = "xyz123";
	String securityKeyValidate = "black";
	
	// This set of variables is to carry out the methods below
	String matchTest;
	
	@Override
	public void registerNewUser(UserAccess refUA) {
		
		System.out.println("You have chosen to create a new user");
		System.out.println("Please enter your email");
		String newEmail = userType.next();
		refUA.setUserEmail(newEmail);
		
		// Next create away to check if the email input exists
		// On the condition it does do no continue
		// If it does then go on to create the password
		
		if(!refUA.getUserEmail().equals(emailValidate)) {
			System.out.println("Create a new password");
			String newPassword = userType.next();
			System.out.println("Re-Type the password");
			String againPassword = userType.next();
			
			// Create the if else for the situation if the password don't match and when they do
			if (!newPassword.equals(againPassword)) {
				System.out.println("Your passwords do not match");
			}
			else {
				refUA.setPassword(newPassword);
				System.out.println("What is your favourite colour");
				String favColour = userType.next();
				refUA.setSecurityKey(favColour);
			}
			
			
		}
		else {
			System.out.println("The email already exists");
		}
		
	}
	
	@Override
	public void loginExistingUser(UserAccess refUA) {
		
		// @ line 65 Ask user for userid/email
		System.out.println("Enter your email:");
		String id = userType.next();
		if (id.equals(refUA.getUserEmail())) {
			
			// ask for password if email exsits
			System.out.println("Password : ");
			String pw = userType.next();
			
			if (!pw.equals(refUA.getPassword())){
				System.out.println("Your password is wrong");
			} else {
				System.out.println("login success");
				// Since password matches then login to access the bank
				accessBankApp(refUA);
			}
		} else {
			System.out.println("Your email is not registered");
		}
		
		
	}

	@Override
	public void retrievePassword(UserAccess refUA) {
		// Ask for the email that requires the password change
		System.out.println("Please Enter your email");
		String hold = userType.next();
		// Check if email is correct
		if (hold.equals(refUA.getUserEmail())) {
			System.out.println("Please enter your security answer");
			System.out.println("What is your favourite colour?");
			hold = userType.next();
			// Check if security key is corect
			if (hold.equals(refUA.getSecurityKey())) {
				System.out.println("Please enter your new password");
				hold = userType.next();
				refUA.setPassword(hold);
			} else {
				System.out.println("Your answer is wrong");
			}
		} else {
			System.out.println("Your email does not exists");
		}
	}
	
	@Override
	public void accessBankApp(UserAccess refUA) {
		String loop = "y";
		while (loop.equals("y")){
			System.out.println("What do you wish to do?");
			System.out.println("1. Check Balance\n2. Deposit\n3. Withdraw\n4. Done");
			int choice = userType.nextInt();
			switch (choice) {
			
			// first case is to check balance
			case 1:
				refBankDAO.balance();
				break;
				
			// second case is to deposit
			case 2:
				refBankDAO.deposit(refUA);
				break;
				
			// third case is withdraw
			case 3:
				refBankDAO.withdraw(refUA);
				break;
				
			case 4:
				System.out.println("Exiting...");
				loop = "n";
				break;
				
			// last is default
			default:
				System.out.println("Please enter a valid choice");
				break;
			}
		} 
	}
	
}
