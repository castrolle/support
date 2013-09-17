package com.support.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.support.utils.Log;
import com.support.vo.GlobalCheck;

public class JAXBUtil {

	private static final String SERVER_XML = "servers.xml";

	public static GlobalCheck recoveryGlobalCheck() {
		JAXBContext context;
		GlobalCheck globalCheckRecovery = null;
		try {
			ClassLoader classLoader = Thread.currentThread()
					.getContextClassLoader();
			Log.info(classLoader.getResource(SERVER_XML));
			context = JAXBContext.newInstance(GlobalCheck.class);
			Unmarshaller um = context.createUnmarshaller();
			globalCheckRecovery = (GlobalCheck) um.unmarshal(classLoader
					.getResource(SERVER_XML));

		} catch (Exception e) {
			Log.error("error recuperando xml " + e.toString());
		}
		return globalCheckRecovery;
	}

}
