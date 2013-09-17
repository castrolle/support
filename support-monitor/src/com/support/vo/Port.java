package com.support.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "port")
public class Port {

	private String name;
	private String path;
	private int number;
	private Checker checker;
	private Notification notification;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Checker getChecker() {
		return checker;
	}

	public void setChecker(Checker checker) {
		this.checker = checker;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	@Override
	public String toString() {
		return "Port [name=" + name + ", number=" + number + "\n\t checker="
				+ checker + "\n\t notification="
				+ notification + "\n]";
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
