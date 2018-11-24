package banking.src.banking;
import logger.src.logger.*;

public class Account {

	private final Logger logger = LoggerFactory.getLogger("banking");
	private int balance;


	public Account(){
		logger.info("PROGRAM","New account created");
	}
	public Account( int balance){
		this.balance=balance;
	}

	
	public int getBalance(){
		return balance;
	}
	
	public void deposit(int deposit){
		if (deposit>=0){
			balance=balance+deposit;
			logger.info("PROGRAM","Updated balance: " + Integer.toString(balance));
		}
		else{
			throw new IllegalArgumentException("error: please enter a positive value");
		}
	}

	public void withdraw(int withdraw){
		if (Math.abs(withdraw)<=balance){
			balance=balance-Math.abs(withdraw);
			logger.info("PROGRAM","Updated balance: " + Integer.toString(balance));
		}
		else{
			throw new IllegalArgumentException("error: not enough credit");
		}
	}
}
