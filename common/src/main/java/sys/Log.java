package sys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {


    public static void info(String info,Class T) {
        Logger logger = LoggerFactory.getLogger(T);
        logger.info(info);
    }
}
