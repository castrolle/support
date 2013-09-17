package com.dev.puppet.server.vo;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Machine implements IsSerializable {

	private String configVmBox = "ubuntu_64";
	private String configVmBoxUrl = "D:\\vagrant\\boxes\\lucid64.box";
	private String configVmNetwork = "bridged";
	private String puppetManifestsPath = "puppet/manifests";

	public Machine() {

	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder(200);

		if (true) {

			builder.append("\n");

			builder.append("Vagrant::Config.run do |config|											\n");
			builder.append("                                                                        \n");
			builder.append("  config.vm.box = '"+configVmBox+"'                                     \n");
			builder.append("  config.vm.box_url = '"+configVmBoxUrl+"'                              \n");
			builder.append("  config.vm.network :"+configVmNetwork+"                                \n");
			builder.append("                                                                        \n");
			builder.append("  config.vm.provision :puppet do |puppet|                               \n");
			builder.append("    puppet.manifests_path = '"+puppetManifestsPath+"'                   \n");
			builder.append("    puppet.options = ['--verbose']                                      \n");
			builder.append("  end                                                                   \n");
			builder.append("                                                                        \n");
			builder.append("end                                                                     \n");

			builder.append("\n");

		}

		return builder.toString();

	}

	public String getConfigVmBox() {
		return configVmBox;
	}

	public void setConfigVmBox(String configVmBox) {
		this.configVmBox = configVmBox;
	}

	public String getConfigVmBoxUrl() {
		return configVmBoxUrl;
	}

	public void setConfigVmBoxUrl(String configVmBoxUrl) {
		this.configVmBoxUrl = configVmBoxUrl;
	}

	public String getConfigVmNetwork() {
		return configVmNetwork;
	}

	public void setConfigVmNetwork(String configVmNetwork) {
		this.configVmNetwork = configVmNetwork;
	}

	public String getPuppetManifestsPath() {
		return puppetManifestsPath;
	}

	public void setPuppetManifestsPath(String puppetManifestsPath) {
		this.puppetManifestsPath = puppetManifestsPath;
	}

}
