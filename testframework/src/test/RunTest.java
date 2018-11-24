package testframework.src.test;
import logger.src.logger.*;
import java.lang.reflect.Method;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class RunTest{


	public static void main (String[] args){
		long beginRun = System.currentTimeMillis();
		Logger logger = LoggerFactory.getLogger("test");
		int testCount=0;
		int okCount=0;
		for(int i=0; i<args.length;i++){
			String className=("testframework.src.test.Test"+args[i]);
			try {
				Class<?> clazz = Class.forName(className); 
				for(Method method : clazz.getDeclaredMethods()) {
					Object instance = null;
					try {
						instance = clazz.newInstance();
					} catch (InstantiationException | IllegalAccessException e) {
						 logger.info("OUTPUT","Couldn't instantiate class: " + clazz.getName());
					}
					testCount++;
					long testStart = System.currentTimeMillis();
					try {
						method.invoke(instance);
						long testEnd = System.currentTimeMillis();
						logger.info("OUTPUT","Test"+ args[i] + " " + method.getName() 
								+ " OK " + (testEnd-testStart) + "ms");
						okCount++;
					}catch (InvocationTargetException | IllegalAccessException e) {
							long testEnd = System.currentTimeMillis();
							logger.error("OUTPUT", e.getCause().getMessage());
							logger.info("OUTPUT",clazz.getName() + " " + method.getName() 
									+ " KO " + (testEnd-testStart) + "ms");
					}
				}
			} catch (ClassNotFoundException e) {
				logger.info("OUTPUT","Class not found");
			}
		}
		long endRun = System.currentTimeMillis();
		if (testCount>0){
			logger.info("OUTPUT", okCount +"/" + testCount + "	" + (okCount*100/testCount) + "% Succes	" 
					+  "	Test total duration: " + (endRun-beginRun) + "ms");
		}else{
			logger.info("OUTPUT", okCount +"/" + testCount + "	" + 0 + "% Succes	" 
					+  "	Test total duration: " + (endRun-beginRun) + "ms");
		}
	}
}
