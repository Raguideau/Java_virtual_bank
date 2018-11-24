package logger.src.logger;
import java.util.function.Predicate;

public class LoggerFactory{
	
		public static Logger getLogger(String file){
			Predicate<String> condition = message -> message.contains("OUTPUT");
			return new CompositeLogger(
					new FilteredLogger(
						new ConsoleLogger(),
						condition
						),
					new ContextualLogger(
						new CategoryDisplayerLogger(
							new LevelDisplayerLogger(
								new FileLogger(file + ".log")
								)
							)
						)
					);
		}
}

