package com.support.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.support.actions.ServersCheck;
import com.support.utils.Log;

@SuppressWarnings("serial")
public class SupportMonitorImpl extends RemoteServiceServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		sendEmail();
	}

	public static void main(String[] args) {
		new SupportMonitorImpl().sendEmail();
	}

	public void sendEmail() {

		try {
			new ServersCheck().process();
		} catch (Exception e) {
			Log.error(e);
		}

	}

}