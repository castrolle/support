package com.support.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.support.server.vo.ServerVO;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(ServerVO input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
