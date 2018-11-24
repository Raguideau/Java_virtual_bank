package logger.src.logger;
import java.util.function.Predicate;


public class FilteredLogger implements Logger {

	private Logger delegate;
	private Predicate<String> condition;

	public FilteredLogger(Logger delegate, Predicate<String> condition){
		this.delegate=delegate;	
		this.condition=condition;
	}
	
	public void debug(String category, String message){
		if(condition.test(category)){
			delegate.debug(category,message);
		}
	}
	
	public void info(String category, String message){
		if(condition.test(category)){
			delegate.info(category,message);
		}
	}
	
	public void error(String category, String message){
		if(condition.test(category)){
			delegate.error(category,message);
		}
	}
}
