package com.dev.puppet.server.vo.monitor;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//esta anotacion es necesaria para poder declarar los getters de las listas
@XmlRootElement(name = "globalcheck")
@XmlAccessorType(XmlAccessType.FIELD)
public class GlobalCheck {

	@XmlElementWrapper(name = "servers")
	@XmlElement(name = "server")
	private List<Server> servers;

		

	public List<Server> getServers() {
		return servers;
	}

	public void setServers(List<Server> servers) {
		this.servers = servers;
	}

	
}
