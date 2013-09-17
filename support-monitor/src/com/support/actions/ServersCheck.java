package com.support.actions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.support.enums.CheckPortEnum;
import com.support.utils.JAXBUtil;
import com.support.utils.Log;
import com.support.utils.MailSender;
import com.support.vo.GlobalCheck;
import com.support.vo.Port;
import com.support.vo.Server;

public class ServersCheck {

	private List<Server> servers = new ArrayList<Server>();

	private void setUp() {
		GlobalCheck global = JAXBUtil.recoveryGlobalCheck();
		servers.addAll(global.getServers());
	}

	public void process() {
		setUp();

		for (Server s : servers) {
			for (Port p : s.getPoolPorts()) {

				if (!checkPort(s.getHost(), p)) {
					Log.error("Servicio :" + p.getName() + " fallido");
					String msg = p.getNotification().getMessage() + "\n"
							+ s.toString() + p.toString();
					MailSender.send(msg, "", p.getNotification()
							.getRecipients());
				} else {
					Log.info("Servicio :" + p.getName() + " exitoso");
				}

			}
		}
	}

	private boolean checkPort(String server, Port p) {

		try {
			if(CheckPortEnum.valueOf(p.getChecker().getType()).equals(CheckPortEnum.HTTP)){
				String protocol = p.getChecker().getType().toLowerCase();
				
				URL url = new URL(protocol+"://"+server+":"+p.getNumber());
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();
				int code = connection.getResponseCode();
				Log.info("OK");
				return true;				
						
			}
		} catch (IOException e) {
			Log.info(e);
		}

		return false;
	}
}
