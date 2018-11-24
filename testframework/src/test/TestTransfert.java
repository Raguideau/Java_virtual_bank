package testframework.src.test;
import banking.src.banking.*;


public class TestTransfert{

	private final NormalUser user1= new NormalUser(new Account(200),"user1",20);	
	private final NormalUser user2= new NormalUser(new Account(),"user2",20);
	private final AccountManager manager=new AccountManager();


	public void testInsufficientFund(){ 
		try{
			manager.transfert(user1, user2, 500);
			if( user1.getAccount().getBalance() != 200 && user2.getAccount().getBalance() != 0){
				throw new IllegalArgumentException("ERROR: Transfert succed without enough money");
			}
		}
		catch(IllegalArgumentException e){}			
	
	}
	
	public void testCorrectlyTransfered(){
		manager.transfert(user1, user2, 50);
		if( user1.getAccount().getBalance() != 150 && user2.getAccount().getBalance() != 50){
			throw new IllegalArgumentException("ERROR:  Transfered amount doesn't match: \n user1 excpected: 150 but has " 
									+ user1.getAccount().getBalance() + "\n user2 excpected: 50 but has " 
									+ user2.getAccount().getBalance());
		}
	}
}
