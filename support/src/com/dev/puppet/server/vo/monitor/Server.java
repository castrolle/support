package com.dev.puppet.server.vo.monitor;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//esta anotacion es necesaria para poder declarar los getters de las listas
@XmlRootElement(name = "server")
@XmlAccessorType(XmlAccessType.FIELD)
public class Server {

	private String host;

	@XmlElementWrapper(name = "poolPorts")
	@XmlElement(name = "port")
	private List<Port> poolPorts;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public List<Port> getPoolPorts() {
		return poolPorts;
	}

	public void setPoolPorts(List<Port> poolPorts) {
		this.poolPorts = poolPorts;
	}

	@Override
	public String toString() {
		return "Server";
	}
}
