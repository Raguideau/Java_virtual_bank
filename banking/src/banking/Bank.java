package banking.src.banking;
import logger.src.logger.*;


public class Bank{

  	 public static void main (String[] args){

		Logger logger = LoggerFactory.getLogger("banking");
		AccountManager manager=new AccountManager();
		ScannerLogger scan = new ScannerLogger();
		int run=1;
		int age;
		String choice;
		NormalUser user = null;
		logger.info("PROGRAM","Bank app started");
		while (run==1){
			System.out.println();
			logger.info("OUTPUT","	/////////////   Reception   /////////////");
			System.out.println();
			if (user != null){
				logger.info("OUTPUT","User selected: " + user.getName());
			}
			logger.info("OUTPUT","What do you want to do? (type h for help)");
			choice = scan.next();

			if (choice.length()>0){
				switch(choice){

					case "q":
						System.out.println();
						logger.info("OUTPUT","Thank you for you visit");
						logger.info("PROGRAM","app closed");
						run=0;
						break;
					
					case "a":
						System.out.println();
						logger.info("OUTPUT","	/////////////   Add User   /////////////");
						System.out.println();
						try{
							manager.addNormalUser();
						}catch(IllegalArgumentException e){
							logger.info("OUTPUT",e.getMessage());
						}
						System.out.println();
						break;

					case "d":
						System.out.println();
						logger.info("OUTPUT","	/////////////   Deposit   /////////////");
						System.out.println();
						try{	
							manager.deposit(user);

						}catch(IllegalArgumentException e){
							logger.info("OUTPUT",e.getMessage());
						}
						System.out.println();
						break;
					
					case "t":
						System.out.println();
						logger.info("OUTPUT","	/////////////  Transfert  /////////////");
						System.out.println();
						try{
							manager.chooseTransfertReceiver(user);

						}catch(IllegalArgumentException e){
							logger.info("OUTPUT",e.getMessage());
						}
						System.out.println();
						break;	

					case "w":
						System.out.println();
						logger.info("OUTPUT","	/////////////   Withdraw   /////////////");
						System.out.println();
						try{	
							manager.withdraw(user);

						}catch(IllegalArgumentException e){
							logger.info("OUTPUT",e.getMessage());
						}
						System.out.println();
						break;
			
					case "s":
						System.out.println();
						logger.info("OUTPUT","	///////////// Select User /////////////");
						System.out.println();
						try{
							user=manager.getUser();

						}catch(IllegalArgumentException e){
							logger.info("OUTPUT",e.getMessage());
						}
						System.out.println();
						break;

					case "c":
						System.out.println();
						logger.info("OUTPUT","	/////////////    Credit    /////////////");
						System.out.println();
						try{
							manager.creditInfo(user);

						}catch(IllegalArgumentException e){
							logger.info("OUTPUT",e.getMessage());
						}
						System.out.println();
						break;
						
					case "l":
						System.out.println();
						logger.info("OUTPUT","	/////////////   User List   /////////////");
						System.out.println();
						try{
							manager.getUserList();
						}catch(IllegalArgumentException e){
							logger.info("OUTPUT",e.getMessage());
						}
						System.out.println();
						break;

					case "b":
						System.out.println();
						logger.info("OUTPUT","	/////////////   Balance   /////////////");
						System.out.println();
						if (user != null){
							logger.info("OUTPUT",user.getName() + " has " + user.getAccount().getBalance()
									 + " jcoins");
						}else {
							logger.info("OUTPUT","Please select an user");
						}
						System.out.println();
						break;

					case "h":
						System.out.println();
						logger.info("OUTPUT","	///////////// Command List /////////////");
						System.out.println();
						logger.info("OUTPUT","h: print this help screen");
						logger.info("OUTPUT","a: add user");
						logger.info("OUTPUT","l: get list of users");
						logger.info("OUTPUT","s: select an user");
						logger.info("OUTPUT","b: get user balance");
						logger.info("OUTPUT","d: deposit");
						logger.info("OUTPUT","w: withdraw");
						logger.info("OUTPUT","t: transfert");
						logger.info("OUTPUT","c: ask for a credit");
						logger.info("OUTPUT","q: quit the program");
						System.out.println();
						break;
					
					default:
						logger.info("OUTPUT"," Unknown command");
				}
			}
		}
	}
}
