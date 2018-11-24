package testframework.src.test;
import banking.src.banking.Account;


public class TestDeposit{
	private final Account testAccount = new Account(100);

	public void testNegativeValue(){
		try{
			testAccount.deposit(-100);
			throw new IllegalArgumentException("ERROR: Negative value deposit");
		}catch(IllegalArgumentException e){
		}		
	}
	public void testCorrectlyDeposited(){
		try{
			testAccount.deposit(100);
			if (testAccount.getBalance() != 200){
				throw new IllegalArgumentException("ERROR: deposed value doesn't match: excpected 100 but deposed "
						+ (testAccount.getBalance()-100));
			}
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("ERROR: Negative value exception catched for positive value");
		}
	}

}
