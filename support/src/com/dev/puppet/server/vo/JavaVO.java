package com.dev.puppet.server.vo;

import com.google.gwt.user.client.rpc.IsSerializable;

public class JavaVO extends ServiceState implements IsSerializable {

	protected Boolean state;
	private Boolean jdk;
	private Boolean jre;

	public JavaVO() {
		super();
	}

	public JavaVO(Boolean state, Boolean jdk, Boolean jre) {
		super();
		this.state = state;
		this.jdk = jdk;
		this.jre = jre;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(200);

		if (state && (jdk != null && jdk || jre != null && jre)) {

			builder.append("\n");

			builder.append("class java($version='6') {													 \n");
			builder.append("  if($::operatingsystem =~ /Ubuntu|Debian/){                                 \n");
			builder.append("                                                                             \n");
			builder.append("		$jdk= $version ? {                                                   \n");
			builder.append("		  '7'      => 'openjdk-7-jdk ',                                      \n");
			builder.append("		  default  => 'openjdk-6-jdk'                                        \n");
			builder.append("		}                                                                    \n");
			builder.append("		                                                                     \n");
			builder.append("		$jre= $version ? {                                                   \n");
			builder.append("		  '7'      => 'openjdk-7-jdk ',                                      \n");
			builder.append("		  default  => 'openjdk-6-jre'                                        \n");
			builder.append("		}                                                                    \n");
			builder.append("		                                                                     \n");
			builder.append("		exec { 'apt-cache-search-jdk':                                       \n");
			builder.append("			user        => 'root',                                           \n");
			builder.append("			path    => ['/bin', '/usr/bin'],                                 \n");
			builder.append("			cwd         => '/tmp',                                           \n");
			builder.append("			command => 'apt-cache search jdk',	                             \n");
			builder.append("		}                                                                    \n");
			builder.append("		                                                                     \n");

			if (jdk != null && jdk) {
				builder.append("		package { $jdk:                                                      \n");
				builder.append("			ensure => present,                                               \n");
				builder.append("			require => [Exec['apt-get update'],Exec['apt-cache-search-jdk']],\n");
				builder.append("		}                                                                    \n");
				builder.append("		                                                                     \n");
			}

			if (jre != null && jre) {
				builder.append("		package { $jre:                                                      \n");
				builder.append("			ensure => present,                                               \n");
				builder.append("			require => [Exec['apt-get update'],Exec['apt-cache-search-jdk']],\n");
				builder.append("		}	                                                                 \n");
			}

			builder.append("    }                                                                        \n");
			builder.append("}                                                                            \n");

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
