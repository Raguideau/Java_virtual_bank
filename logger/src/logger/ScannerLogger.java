package logger.src.logger;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ScannerLogger{

	private Scanner scan = new Scanner(System.in);
	private String message;
	private int number;
	private final Logger logger = LoggerFactory.getLogger("banking");


	public String next(){
		System.out.print("]-->");
		message=scan.next();
		logger.info("INPUT",message);
		return message;
	}

	public int nextInt(){
		System.out.print("]-->");
		try{
			number=scan.nextInt();
			logger.info("INPUT",Integer.toString(number));
		}catch(InputMismatchException e){
			scan.next();
			throw new IllegalArgumentException("Please enter a number");
		}
		return number;
	}
}
