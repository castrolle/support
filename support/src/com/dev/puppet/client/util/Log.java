package com.dev.puppet.client.util;

import java.util.logging.Logger;

public class Log {

	static Logger logger = Logger.getLogger(Log.class.getName());

	public static void info(Object msg) {
		logger.info(msg.toString());
	}
	
	public static void error(Object msg) {
		logger.warning(msg.toString());
	}

}