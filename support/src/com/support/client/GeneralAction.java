package com.support.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public abstract class GeneralAction {

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	protected static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";
	
	public abstract void buildPage(RootPanel panel);
	
	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	protected final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
}
