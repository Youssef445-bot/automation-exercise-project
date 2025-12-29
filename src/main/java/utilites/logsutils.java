package utilites;

import org.apache.logging.log4j.LogManager;

public class logsutils {

    private static final String Test_data_path = "test-outputs/logs";

    public static void trace(String message){
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2])
                .trace(message);

    }
    public static void info(String message){
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2])
                .info(message);

    }
    public static void error(String message){
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2])
                .error(message);

    }
    public static void warn(String message){
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2])
                .warn(message);

    }
    public static void fatal(String message){
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2])
                .fatal(message);

    }
    public static void debug(String message){
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2])
                .debug(message);

    }

}
