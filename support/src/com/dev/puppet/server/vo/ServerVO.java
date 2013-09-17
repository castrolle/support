package com.dev.puppet.server.vo;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ServerVO implements IsSerializable {

	private UserVO userVO;
	private ApacheVO apacheVO;
	private PhpVO phpVO;
	private MySqlVO mySqlVO;
	private JavaVO javaVO;
	
	public ServerVO() {
	
	}

	public ServerVO(UserVO userVO, ApacheVO apacheVO, PhpVO phpVO,
			MySqlVO mySqlVO, JavaVO javaVO) {
		this.userVO = userVO;
		this.apacheVO = apacheVO;
		this.phpVO = phpVO;
		this.mySqlVO = mySqlVO;
		this.javaVO = javaVO;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(600);

		builder.append("exec { 'apt-get update':                 \n");
		builder.append("    command => '/usr/bin/apt-get update',\n");
		builder.append("	path    => ['/bin', '/usr/bin'],     \n");
		builder.append("}                                        \n");
		builder.append("\n");

		if(userVO != null && userVO.state){
			
			builder.append(userVO);
			builder.append("\n");
		}
		
		if (apacheVO != null && apacheVO.state) {
			builder.append(apacheVO);

			builder.append("\n");
			builder.append("include apache \n");
		}

		if (phpVO != null && phpVO.state) {
			builder.append(phpVO);

			builder.append("\n");
			builder.append("include php \n");
		}
		
		if (mySqlVO != null && mySqlVO.state) {
			builder.append(mySqlVO);

			builder.append("\n");
			builder.append("include mysql \n");
		}
		
		if (javaVO != null && javaVO.state) {
			builder.append(javaVO);

			builder.append("\n");
			builder.append("include java \n");
		}

		

		return builder.toString();

	}

}
