package t2.s2.service;

import t2.s2.pojo.UserAccess;

// Refer to BankingDAO interface to know why interface is used

public interface BankingService {
	
	void registerNewUser(UserAccess refUA);
	void loginExistingUser(UserAccess refUA);
	void retrievePassword(UserAccess refUA);
	void accessBankApp(UserAccess refUA);
}
