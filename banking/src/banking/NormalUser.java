package banking.src.banking;
import logger.src.logger.*;

public class NormalUser{

	private Account userAccount;
	private final Logger logger = LoggerFactory.getLogger("banking");

	private final String name;
	private int age;
	private int creditCount;
	
	public NormalUser (Account userAccount, String name, int age) {
		this.age=age;
		this.userAccount=userAccount;		
		this.name=name;
		this.creditCount=0;
		logger.info("PROGRAM","new user created: "+ name + ", " + age + " years old");
	}

	public int getCreditCount(){
		return creditCount;
	}
	
	public void setCreditCount(int creditCount){
		this.creditCount=creditCount;
		logger.info("PROGRAM","creditCount set to "+creditCount);
	}

	public int getAge(){
		return age;
	}
	public String getName(){
		return name;
	}
	public Account getAccount(){
		return userAccount;
	}

}
