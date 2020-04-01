package t2.s2.controller;

// In order to use scanner to take in input must import the below class?
import java.util.Scanner;

//Importing is necessary to ensure that the different packages can access the needed class in another package
//Doing this is a form of OOPs
import t2.s2.pojo.UserAccess;
import t2.s2.service.BankingService;
import t2.s2.service.BankingServiceActions;




// This class is where the controller
// This class is where the user choices are stored and then base on what they want it gets carried out
// Essentially this is where when the user says login the method calls for the login steps

public class BankAppControl {
	
	// First the reference to the interface is necessary
	// Using interface is also a method of memory management
	// So this allows for less memory to be used
	
	// The error created the solution
	// A cast had to be added
	private BankingService refBS;
	// The below is a reference to the POJO file in order to use it
	private UserAccess refUA = new UserAccess();
	Scanner userChoice = new Scanner(System.in);
	
	public void bankAppControlLogic() {
		
		refBS = new BankingServiceActions();
		// In this method, we using user input to choose what they want to do
		// So 1 is register, 2 is login, 3 is forget password and 4 is Logout
		// Each choice will call a new method or if 4 is chosen end the program
		
		// So first take in the user input using the userChoice which is using scanner
		
		// Create a variable to store the choice
		int choice;
		do {
			// Next create a simple menu to display in console
			System.out.println("1. Register\n2. Login\n3. Retrieve Password\n4. Exit\n");
			// What i have done above is to create new lines with \n
			// This way i don't have to create sysout over and over again for each new line
			// I added a \n at the end so it creates a new line before taking in the user input
			
			choice = userChoice.nextInt();
			// This line takes the user input and stores it in choice
			// The data type here is integer since it uses less memory than string
			
			// Create a switch case
			// Switch case is using int in this case to control the choice
			switch (choice) {
			
			// First case is to register user
			case 1:
				// Use the reference of BankingService to call the method to register
				refBS.registerNewUser(refUA);
				break;
			
			// Second case is to login for existing user
			case 2:
				// Use same reference but this time call the login method
				refBS.loginExistingUser(refUA);
				break;
				
			// This case is to create new password, same reference as above	
			case 3:
				refBS.retrievePassword(refUA);
				break;
				
			// The fourth case is to end the program
			case 4:
				// In this case no need for any reference just say goodbye
				System.out.println("You have chosen to end the program goodbye");
				break;
				
			// The last one is to catch any exceptions to the choice to prevent the program from breaking
			default:
				System.out.println("Unavailable choice, choose again");
				break;
			}
			
		} while (choice != 4);
		
	}
}
