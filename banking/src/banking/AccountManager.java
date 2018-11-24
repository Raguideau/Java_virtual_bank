package banking.src.banking;
import java.util.ArrayList;
import logger.src.logger.*;

public class AccountManager{
	
	private final Logger logger = LoggerFactory.getLogger("banking");
	private ArrayList<NormalUser> users=new ArrayList<NormalUser>();
	private ScannerLogger scan = new ScannerLogger();
	private String name;
	private int balance;
	private int age;


	public void addNormalUser(){
		logger.info("PROGRAM","adding new user");
		logger.info("OUTPUT","Enter user name: ");
		name = scan.next();
		logger.info("OUTPUT","Enter user age");
		try{
			age = scan.nextInt();
			if (age>=110){
				throw new IllegalArgumentException("user too old");
			}
		}catch(IllegalArgumentException e){
				throw new IllegalArgumentException(e.getMessage());
		}
		users.add(new NormalUser(new Account(),name,age));
		logger.info("OUTPUT","User added ");
	}


	public void deposit(NormalUser user){
		logger.info("PROGRAM","deposit demand");
		if (user != null){
			logger.info("OUTPUT","enter amount to deposit");
			try{
				balance = scan.nextInt();
			}catch(IllegalArgumentException e){
					throw new IllegalArgumentException(e.getMessage());
			}
			try{
				user.getAccount().deposit(balance);
				logger.info("OUTPUT","successfully deposited");
			}catch(IllegalArgumentException e){
				logger.info("OUTPUT",e.getMessage());
			}
		}
		else{
			throw new IllegalArgumentException("Please select an user");
		}
	}
	
	public void withdraw(NormalUser user){
		logger.info("PROGRAM","witdraw demand");
		if (user != null){
			logger.info("OUTPUT","enter amount to withdraw");
			try{
				balance = scan.nextInt();
			}catch(IllegalArgumentException e){
					throw new IllegalArgumentException(e.getMessage());
			}
			try{
				user.getAccount().withdraw(balance);
				logger.info("OUTPUT","successfully withdrawn");
			}catch(IllegalArgumentException e){
				logger.info("OUTPUT",e.getMessage());
			}
		}
		else{
			throw new IllegalArgumentException("Please select an user");
		}
	}


	public void chooseTransfertReceiver(NormalUser emittingUser){
		logger.info("PROGRAM","transfert demand");
		if(getUserAmount()>1){
			if (emittingUser != null){
				logger.info("OUTPUT","Please enter recieving user information: ");
				NormalUser receivingUser=getUser();
				if (receivingUser != null){
					logger.info("OUTPUT","enter amount to transfert");
					try{
						balance = scan.nextInt();
					}catch(IllegalArgumentException e){
							throw new IllegalArgumentException(e.getMessage());
					}
					try{
						transfert(emittingUser,receivingUser,balance);
						logger.info("OUTPUT","transfert succesful");
					}catch(IllegalArgumentException e){
						logger.info("OUTPUT",e.getMessage());
					}
				}
				else{
					throw new IllegalArgumentException("This user doesn't exist");
				}
			}else{
				throw new IllegalArgumentException("Please select an user");
			}
		}else{
			throw new IllegalArgumentException("There isn't enough users in the bank");
		}		
	}
	
	public void transfert(NormalUser emittingUser,NormalUser receivingUser,int balance){
		try{
			emittingUser.getAccount().withdraw(balance);
			receivingUser.getAccount().deposit(balance);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	public void creditInfo(NormalUser user){
		logger.info("PROGRAM","credit demand");
		if (user != null){
			int rate=0;
			int duration=0;
			logger.info("OUTPUT","Enter credit amount: ");
			try{
				balance = scan.nextInt();
			}catch(IllegalArgumentException e){
				throw new IllegalArgumentException(e.getMessage());
			}
				logger.info("OUTPUT","Enter rate: ");
			try{
				rate = scan.nextInt();
			}catch(IllegalArgumentException e){
				throw new IllegalArgumentException(e.getMessage());
			}
				logger.info("OUTPUT","Enter credit duration in years");
			try{
				duration = scan.nextInt();
			}catch(IllegalArgumentException e){
				throw new IllegalArgumentException(e.getMessage());
			}
				credit(rate, balance, duration, user);
				logger.info("OUTPUT","Credit granted");
		}else{
			throw new IllegalArgumentException("Please select an user");
		}
	}
	
	public void credit(int rate, int balance, int duration, NormalUser user){
		if(rate<=1){
			throw new IllegalArgumentException("the rate is too low");
		}
		else{
			if(balance<=0){
				throw new IllegalArgumentException("The amount is negative");
			}
			else{
				if(user.getCreditCount()>=2){
					throw new IllegalArgumentException("This user can't have more credits");
				}
				else{
					if (duration + user.getAge() >=70){
					throw new IllegalArgumentException("the user is too old");
					}
					else{
						user.getAccount().deposit(balance);
						user.setCreditCount(user.getCreditCount()+1);
					}
				}
			}
		}
	
	}

	public NormalUser getUser(){
		logger.info("PROGRAM","search for user");
		if(getUserAmount()>0){
			logger.info("OUTPUT","Enter user name: ");
			name = scan.next();
			logger.info("OUTPUT","Enter user age");
			try{
				age = scan.nextInt();
			}catch(IllegalArgumentException e){
				throw new IllegalArgumentException(e.getMessage());
			}
			for (int i=0; i<users.size(); i++){
				if(users.get(i).getName().equals(name) && users.get(i).getAge() == age){
					logger.info("OUTPUT","User selected");
					return users.get(i);
				}
			}
			throw new IllegalArgumentException("This user doesn't exist");
			
							
		}else{
			throw new IllegalArgumentException("There isn't any user in the bank");
		}
	}
	public int getUserAmount(){
		logger.info("PROGRAM","asked for user amount");
		return users.size();
	}

	public void getUserList(){
		logger.info("PROGRAM","user list demand");
		for (int i=0; i<users.size(); i++){
				logger.info("OUTPUT",users.get(i).getName());
		}
	}
}
