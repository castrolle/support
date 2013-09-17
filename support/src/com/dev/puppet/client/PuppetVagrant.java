package com.dev.puppet.client;

import com.dev.puppet.client.puppet.PuppetAction;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PuppetVagrant implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

	
		RootPanel rootId = RootPanel.get("pagePuppet");
		if (rootId != null) {
			new PuppetAction().buildPage(rootId);
		}
	}
}
