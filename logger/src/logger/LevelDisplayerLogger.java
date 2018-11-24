package logger.src.logger;

public class LevelDisplayerLogger implements Logger {

	private Logger delegateLogger;

	public LevelDisplayerLogger(Logger delegateLogger){
		this.delegateLogger=delegateLogger;
	}
	
	public void debug (String category,String message){
		delegateLogger.debug(category,"<LEVEL(DEBUG)>" + " " + message);
	}

	public void info (String category,String message){
		delegateLogger.info(category,"<LEVEL(INFO)>" + " " + message);
	}

	public void error (String category,String message){
		delegateLogger.error(category,"<LEVEL(ERROR)>" + " " + message);
	}
}
