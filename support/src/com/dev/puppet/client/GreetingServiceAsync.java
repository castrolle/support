package com.dev.puppet.client;

import com.dev.puppet.server.vo.ServerVO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(ServerVO input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
