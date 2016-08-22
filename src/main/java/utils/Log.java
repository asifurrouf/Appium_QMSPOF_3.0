package utils;

import org.apache.log4j.*;


/**
 * Created by buddyarifin on 8/15/16.
 */
public class Log {

    private static final Logger LOGGER = Logger.getLogger("APPIUM");
    private static PatternLayout layout = new PatternLayout("%d{dd MMM yyyy HH:mm:ss} %5p %c{1} - %m%n");
    private static ConsoleAppender consoleAppender;

    static {
        consoleAppender = new ConsoleAppender(layout, "System.out");
    }

    /**
     * Method to display errors in log.
     *
     * @param className  name of class in which error occurred.
     * @param methodName name of method in which error occurred.
     * @param exception  stack trace of exception
     */
    public static void logError(String className, String methodName, String exception) {
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("ClassName :" + className);
        LOGGER.info("MethodName :" + methodName);
        LOGGER.info("Exception :" + exception);
        LOGGER.info("-----------------------------------------------------------------------------------");
    }

    /**
     * Method to display information in logs
     *
     * @param message message to be displayed
     */
    public static void info(String message) {
        consoleAppender.setName("Console");
        LOGGER.addAppender(consoleAppender);
        LOGGER.setLevel(Level.INFO);
        LOGGER.info(message);
    }
}
