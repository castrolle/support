package com.support.server.vo;

import com.google.gwt.user.client.rpc.IsSerializable;

public class PhpVO extends ServiceState  implements IsSerializable {

	protected Boolean state;
	
	private Boolean phpCli;
	private Boolean phpMysql;
	private Boolean libApacheMod;

	public PhpVO() {
		super();
		this.state = false;
	}
	
	public PhpVO(Boolean state) {
		super();
		this.state = state;
	}

	public PhpVO(Boolean state,Boolean phpCli, Boolean phpMysql, Boolean libApacheMod) {
		super();
		this.state = state;
		this.phpCli = phpCli;
		this.phpMysql = phpMysql;
		this.libApacheMod = libApacheMod;
	}

	public boolean isEnabled() {
		return this.state;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(200);

		if (state) {
			builder.append("class php {                      \n");
			builder.append("  package { 'php5':              \n");
			builder.append("    ensure => present,           \n");
			builder.append("  }                              \n");
			builder.append("                                 \n");

			if (phpCli) {
				builder.append("package { 'php5-cli':            \n");
				builder.append("    ensure => present,           \n");
				builder.append("  }                              \n");
				builder.append("                                 \n");
			}

			if (phpMysql) {
				builder.append("package { 'php5-mysql':          \n");
				builder.append("    ensure => present,           \n");
				builder.append("  }                              \n");
				builder.append("                                 \n");
			}

			if (libApacheMod) {
				builder.append("package { 'libapache2-mod-php5': \n");
				builder.append("    ensure => present,           \n");
				builder.append("  }                              \n");
			}

			builder.append("}                                \n");

		}
		return builder.toString();
	}

	@Override
	public void setState(Boolean state) {
		this.state = state;
	}

}