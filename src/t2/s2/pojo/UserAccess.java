package t2.s2.pojo;

// This class is an example of POJO
// POJO is encapsulation where you get private variables
// This variables are private to prevent unauthorized access or use
// In order to use the variables here, the setter and getter methods are used

public class UserAccess {
	
	// This variables are used in the setter & getter method so you can give them something to hold and a way to access them
	
	private String userEmail, password, securityKey;
	int amount;
	
	// The below lists of methods(functions) are how the private variables are set and accessed
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecurityKey() {
		return securityKey;
	}
	public void setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
