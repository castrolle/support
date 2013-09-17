package com.dev.puppet.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;

public class WidgetTI extends Composite{

	protected DecoratorPanel contentTableDecorator;
	
	public WidgetTI() {
		super();
		contentTableDecorator = new DecoratorPanel();
		initWidget(contentTableDecorator);
	}

	protected void clearMessages(){
		
	}
	
}
