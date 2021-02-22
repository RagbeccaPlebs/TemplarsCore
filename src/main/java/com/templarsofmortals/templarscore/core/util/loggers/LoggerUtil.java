package com.templarsofmortals.templarscore.core.util.loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
    private static Logger logger = LogManager.getLogger();

    public static void debug(String modName, String sentence) {
        logger.debug(modName + ": " + sentence);
    }

    public static void info(String modName, String sentence) {
        logger.info(modName + ": " + sentence);
    }

    public static void warn(String modName, String sentence) {
        logger.warn(modName + ": " + sentence);
    }

    public static void error(String modName, String sentence) {
        logger.error(modName + ": " + sentence);
    }
}
