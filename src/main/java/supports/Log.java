package supports;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
    //Initialize Log4j logs

    private static Logger Log = Logger.getLogger(Log.class.getName());
    public static void error(String message) {

        // PropertiesConfigurator is used to configure logger from properties file
        PropertyConfigurator.configure("log4j.properties");
        Log.error(message);

    }
}
