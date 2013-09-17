package com.support.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.support.client.GreetingServiceAsync;
import com.support.client.util.DialogUtils;
import com.support.client.view.PuppetView;
import com.support.server.vo.Machine;
import com.support.server.vo.ServerVO;

public class PuppetPresenter implements Presenter {

	private final HandlerManager eventBus;
	private final PuppetView display;

	private GreetingServiceAsync greetingService;

	public PuppetPresenter(GreetingServiceAsync greetingService,
			HandlerManager eventBus) {
		this.greetingService = greetingService;
		this.eventBus = eventBus;
		display = new PuppetView();
	}

	public void bind() {

		display.getSendButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				sendNameToServer(display.getServerDefinition());
			}
		});

		display.getUserCheck().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				display.changePanelUser(display.getUserCheck());
			}
		});

		display.getApacheCheck().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				display.changePanelApache(display.getApacheCheck());
			}
		});
		
		display.getPhpCheck().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				display.changePanelPhp(display.getPhpCheck());
			}
		});
		
		
		display.getMysqlCheck().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				display.changePanelMysql(display.getMysqlCheck());
			}
		});
		
		
		display.getJavaCheck().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				display.changePanelJava(display.getJavaCheck());
			}
		});
		
	

	}

	public void go(final HasWidgets container) {
		init();
		bind();
		container.clear();
		container.add(display.asWidget());
	}

	private void init() {

	}

	/**
	 * Send the name from the nameField to the server and wait for a response.
	 * 
	 * @param serverVO
	 */
	private void sendNameToServer(ServerVO serverVO) {

		final String server = serverVO.toString();
		final String machine = new Machine().toString();
		
		DialogUtils.showMessage(server,machine);
		/*greetingService.greetServer(serverVO, new AsyncCallback<String>() {
			public void onFailure(Throwable caught) {

			}

			public void onSuccess(String result) {
				DialogUtils.showMessage(value);
			}
		});*/
	}
}
