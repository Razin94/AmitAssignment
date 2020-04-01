package t2.s2.dao;

import t2.s2.pojo.UserAccess;

// This interface class is created to hold the abstract methods
// Interface is to declare what a class must do but not how
// Using interface allows for us to achieve multiple inheritance in Java
// Using interface allows us to have abstract classes that can contain non-final variables
public interface BankingDAO {
	
	// The UserAccess refUser in the brackets for the method is now passing the variables from one class to another
	void balance();
	void deposit(UserAccess refUA);
	void withdraw(UserAccess refUA);
	
}
