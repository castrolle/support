package com.dev.puppet.server;

import com.dev.puppet.client.GreetingService;
import com.dev.puppet.server.vo.ServerVO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.support.utils.HtmlUtils;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public String greetServer(ServerVO input) throws IllegalArgumentException {
		System.out.println(input);
		return HtmlUtils.escapeHtml(input.toString());
	}

}
