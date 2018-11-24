package logger.src.logger;
public class CategoryDisplayerLogger implements Logger {

	private Logger delegateLogger;


	public CategoryDisplayerLogger(Logger delegateLogger){
		this.delegateLogger=delegateLogger;
	}
	
	public void debug (String category,String message){
		delegateLogger.debug(category,"<CATEGORY(" +category+ ")>" +" "+message);
	}

	public void info (String category,String message){
		delegateLogger.info(category,"<CATEGORY(" +category+ ")>" +" "+message);
	}

	public void error (String category,String message){
		delegateLogger.error(category,"<CATEGORY(" +category+ ")>" +" "+message);
	}
}
