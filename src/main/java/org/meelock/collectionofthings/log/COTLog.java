package org.meelock.collectionofthings.log;

import org.apache.logging.log4j.Logger;

public class COTLog {
	public static Logger log;

	public static void init(Logger log) {
		COTLog.log = log;
	}

	public static void info(Object message) {
		log.info(message);
	}

	public static void info(Object message, Throwable t) {
		log.info(message, t);
	}

	public static void warn(Object message) {
		log.warn(message);
	}

	public static void warn(Object message, Throwable t) {
		log.warn(message, t);
	}

	public static void error(Object message) {
		log.error(message);
	}

	public static void error(Object message, Throwable t) {
		log.error(message, t);
	}
}
