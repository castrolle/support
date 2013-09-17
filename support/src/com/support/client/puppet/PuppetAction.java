package com.support.client.puppet;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;
import com.support.client.GeneralAction;
import com.support.client.IDClientConstants;
import com.support.client.presenter.Presenter;
import com.support.client.presenter.PuppetPresenter;

public class PuppetAction extends GeneralAction {

	@Override
	public void buildPage(RootPanel panel) {
		HandlerManager eventBus = new HandlerManager(null);

		Presenter presenter = null;
		presenter = new PuppetPresenter(greetingService, eventBus);
		presenter.go(RootPanel.get(IDClientConstants.CONTENT_ROOT));

	}

}
