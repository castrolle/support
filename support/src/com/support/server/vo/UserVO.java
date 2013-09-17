package com.support.server.vo;

import com.google.gwt.user.client.rpc.IsSerializable;

public class UserVO extends ServiceState implements IsSerializable {

	protected Boolean state;
	private String username;
	private String password;

	public UserVO() {
		super();
	}

	public UserVO(Boolean state, String username, String password) {
		super();
		this.state = state;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(200);

		if (state && username != null && !username.isEmpty()
				&& password != null && !password.isEmpty()) {

			builder.append("\n");

			builder.append("user { '" + username + "':                   \n");
			builder.append("      ensure     => present,           \n");
			builder.append("      uid        => '507',             \n");
			builder.append("      gid        => 'admin',           \n");
			builder.append("      shell      => '/bin/zsh',        \n");
			builder.append("      home       => '/home/develpment',\n");
			builder.append("	  password   => '" + password + "',        \n");
			builder.append("      managehome => true,              \n");
			builder.append("}                                      \n");

			builder.append("\n");

		}
		return builder.toString();
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	@Override
	public void setState(Boolean state) {

	}

}
