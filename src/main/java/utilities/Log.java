package utilities;

import org.apache.log4j.Logger;

public class Log {
    final static Logger logger = Logger.getLogger(Log.class.getName());

    public static void infoTestCase(String string) {
        logger.info("====" + string + "====");
    }

    public static void info(String string) {
        logger.info("->" + string);
    }
    public static void error(String string) {
        logger.error("->" + string);
    }
}
