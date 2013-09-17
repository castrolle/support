package com.dev.puppet.server.vo.monitor;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "notification")
public class Notification {

	private String subject;
	private String message;
	private List<String> recipients;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<String> recipients) {
		this.recipients = recipients;
	}

	@Override
	public String toString() {
		return "Notification [subject=" + subject + ", message=" + message + ", recipients=" + recipients + "]";
	}
}
