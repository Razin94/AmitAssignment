package t2.s2.app;

// import this package in order to to be able to use the controller class
import t2.s2.controller.BankAppControl
;
public class BankApp {
	
	public static void main(String[] args) {
		BankAppControl ref = new BankAppControl();
		ref.bankAppControlLogic();
	}

}
