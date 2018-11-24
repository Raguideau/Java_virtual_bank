package logger.src.logger;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ContextualLogger implements Logger {

	private Logger delegateLogger;
	private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:SS:sss");

	public ContextualLogger(Logger delegateLogger){
		this.delegateLogger=delegateLogger;
	}
	
	public void debug (String category,String message){
		delegateLogger.debug(category,"<DATE(" +DATE_FORMAT.format(new Date())+ ")>" +" "+message);
	}

	public void info (String category,String message){
		delegateLogger.info(category,"<DATE(" +DATE_FORMAT.format(new Date())+ ")>" +" "+message);
	}

	public void error (String category,String message){
		delegateLogger.error(category,"<DATE(" +DATE_FORMAT.format(new Date())+ ")>" +" "+message);
	}
}
