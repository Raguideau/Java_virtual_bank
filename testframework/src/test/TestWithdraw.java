package testframework.src.test;
import banking.src.banking.Account; 	


public class TestWithdraw{
	private final Account testAccount = new Account(100);

	public void testCorrectlyWithdrawn(){
		try{
			testAccount.withdraw(50);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("ERROR: Negative balance exception catched for positive value");
		}
		
	}
	public void testInsufficientFund(){
	try{
			testAccount.withdraw(200);
			throw new IllegalArgumentException("ERROR: Withdrawal succed without enough money");
		}catch(IllegalArgumentException e){
		}
	}
}
