package com.support.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.support.client.puppet.PuppetAction;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Support implements EntryPoint {

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
