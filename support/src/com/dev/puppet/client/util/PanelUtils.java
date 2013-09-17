package com.dev.puppet.client.util;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTMLPanel;

public class PanelUtils {

	
	public static HTMLPanel buildPanel(CheckBox check){
		HTMLPanel panel = new HTMLPanel("");
		
		panel.add(check);
		
		return panel;
	}
}
