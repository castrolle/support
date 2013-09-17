package com.support.server.vo;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ApacheVO extends ServiceState implements IsSerializable {

	protected Boolean state;

	public ApacheVO() {
		super();
	}

	public ApacheVO(Boolean state) {
		super();
		this.state = state;
	}

	public boolean isEnabled() {
		return this.state;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(200);

		if (state) {

			builder.append("\n");
			builder.append("class apache {					   \n");
			builder.append("                                   \n");
			builder.append("  package { 'apache2':             \n");
			builder.append("    ensure => present,             \n");
			builder.append("  }                                \n");
			builder.append("                                   \n");
			builder.append("  service { 'apache2':             \n");
			builder.append("    ensure => running,             \n");
			builder.append("    require => Package['apache2'], \n");
			builder.append("  }                                \n");
			builder.append("                                   \n");
			builder.append("  file { '/var/www':               \n");
			builder.append("    ensure => link,                \n");
			builder.append("    target => '/vagrant',          \n");
			builder.append("    notify => Service['apache2'],  \n");
			builder.append("    force  => true                 \n");
			builder.append("  }                                \n");
			builder.append("}                                  \n");
			builder.append("\n");

		}
		return builder.toString();
	}

	@Override
	public void setState(Boolean state) {
		this.state = state;
	}

}
