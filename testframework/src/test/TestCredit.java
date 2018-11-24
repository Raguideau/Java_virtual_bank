package testframework.src.test;
import banking.src.banking.*;

public class TestCredit{

	private final NormalUser user= new NormalUser(new Account(200),"user1",60);	
	private final AccountManager manager=new AccountManager();

	
	public void testCorrectlyCredited(){
		try{
			manager.credit(5,200,5,user);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("ERROR: Unexpected error:" + e.getMessage());
		}
		if (user.getAccount().getBalance() != 400){
			throw new IllegalArgumentException("ERROR: Wrong credit amount expected 200 but has: "
								 + (user.getAccount().getBalance()-200));
		}
		if(user.getCreditCount() != 1){
			throw new IllegalArgumentException("ERROR: Wrong credit count expected 1 but has: " + user.getCreditCount());
		}
		
	}

	public void testInsufficientRate(){
		try{
			manager.credit(0,200,5,user);
			throw new IllegalArgumentException("ERROR: Credit succed with rate<1");
		}catch(IllegalArgumentException e){
		}
	}

	public void testUserTooOld(){
		try{
			manager.credit(5,-200,15,user);
			throw new IllegalArgumentException("ERROR: Credit succed with negative credit");
		}catch(IllegalArgumentException e){
		}
	}

	public void testNegativeValue(){
		user.setCreditCount(5);
		try{
			manager.credit(5,-200,5,user);
			throw new IllegalArgumentException("ERROR: Credit succed with negative credit");
		}catch(IllegalArgumentException e){
		}
	}

	public void testCreditCount(){
		try{
			manager.credit(5,200,5,user);
			throw new IllegalArgumentException("ERROR: Credit succed when user has more than 2 credit");
		}catch(IllegalArgumentException e){
		}
	}
}
