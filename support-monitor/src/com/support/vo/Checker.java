package com.support.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "checker")
// esta anotacion es necesaria para poder declarar los getters de las listas
@XmlAccessorType(XmlAccessType.FIELD)
public class Checker {


	private String type;



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
