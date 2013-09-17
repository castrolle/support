package com.dev.puppet.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.puppet.client.util.Log;
import com.dev.puppet.server.monitor.ServersCheck;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class EmailServiceImpl extends RemoteServiceServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		sendEmail();
	}

	public static void main(String[] args) {
		new EmailServiceImpl().sendEmail();
	}

	public void sendEmail() {

		try {
			new ServersCheck().process();
		} catch (Exception e) {
			Log.error(e);
		}

	}

}