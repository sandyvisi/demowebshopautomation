package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {

	public static Logger getLogger(Class<?> className) {

		return LogManager.getLogger(className);
	}

}
