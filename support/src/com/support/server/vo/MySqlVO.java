package com.support.server.vo;

import com.google.gwt.user.client.rpc.IsSerializable;

public class MySqlVO extends ServiceState implements IsSerializable {

	protected Boolean state;
	private String mysqlRootPassword;
	private String databaseName;

	public MySqlVO() {
		super();
	}
	
	

	public MySqlVO(Boolean state, String mysqlRootPassword, String databaseName) {
		super();
		this.state = state;
		this.mysqlRootPassword = mysqlRootPassword;
		this.databaseName = databaseName;
	}



	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder(200);

		if (state) {

			builder.append("class mysql {																					 \n");
			builder.append("	package { 'mysql-server':                                                                    \n");
			builder.append("		ensure => present,                                                                       \n");
			builder.append("		require => Exec['apt-get update'],                                                       \n");
			builder.append("	}                                                                                            \n");
			builder.append("                                                                                                 \n");
			builder.append("	service { 'mysql':                                                                           \n");
			builder.append("		ensure => running,                                                                       \n");
			builder.append("		require => Package['mysql-server'],                                                      \n");
			builder.append("	}                                                                                            \n");
			builder.append("	                                                                                             \n");

			if (mysqlRootPassword != null && !mysqlRootPassword.isEmpty()) {
				builder.append("	exec { 'set-mysql-password':                                                                 \n");
				builder.append("		unless  => 'mysql -uroot -p"+mysqlRootPassword+"',                                                        \n");
				builder.append("		user        => 'root',                                                                   \n");
				builder.append("		path        => '/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin:/root/bin', \n");
				builder.append("		cwd         => '/tmp',	                                                                 \n");
				builder.append("		command => 'mysqladmin -uroot password "+mysqlRootPassword+"',                           \n");
				builder.append("		require => Exec['apt-get update'],                                                       \n");
				builder.append("	}                                                                                            \n");
			}

			if (databaseName != null && !databaseName.isEmpty()) {
				builder.append("                                                                                                 \n");
				builder.append("	exec { 'create-database':                                                                    \n");
				builder.append("	   user        => 'root',                                                                    \n");
				builder.append("		path    => ['/bin', '/usr/bin'],                                                         \n");
				builder.append("		cwd         => '/tmp',                                                                   \n");
				builder.append("		command => 'mysql -uroot -proot -e 'create database IF NOT EXISTS \""+databaseName+"\";'',   \n");
				builder.append("		require => Exec['set-mysql-password'],                                                   \n");
				builder.append("	}                                                                                            \n");
			}

			builder.append("}                                                                                                \n");
			builder.append("\n");

		}
		return builder.toString();

	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setState(Boolean state) {
		// TODO Auto-generated method stub

	}

}
