package com.dev.puppet.client.puppet;

import com.dev.puppet.client.GeneralAction;
import com.dev.puppet.client.IDClientConstants;
import com.dev.puppet.client.presenter.Presenter;
import com.dev.puppet.client.presenter.PuppetPresenter;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

public class PuppetAction extends GeneralAction {

	@Override
	public void buildPage(RootPanel panel) {
		HandlerManager eventBus = new HandlerManager(null);

		Presenter presenter = null;
		presenter = new PuppetPresenter(greetingService, eventBus);
		presenter.go(RootPanel.get(IDClientConstants.CONTENT_ROOT));

	}

}
