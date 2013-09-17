package com.dev.puppet.client.util;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DialogUtils {

	public static void showMessage(String puppetText, String vagrantFile) {

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setWidth("600px");
	
		final Button closeButton = new Button("Cerrar");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		
			    
		TextArea taPuppet = new TextArea();
	    taPuppet.setCharacterWidth(100);
	    taPuppet.setVisibleLines(15);
	    taPuppet.setText(puppetText);
	    
	    TextArea taVagrant = new TextArea();
	    taVagrant.setCharacterWidth(100);
	    taVagrant.setVisibleLines(15);
	    taVagrant.setText(vagrantFile);

		
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Mensaje:</b>"));
		dialogVPanel.add(textToServerLabel);


		TabPanel panel = new TabPanel();
		
		panel.add(taPuppet,"default.pp");
		panel.add(taVagrant,"Vagrantfile");
		panel.selectTab(0);

	    
		dialogVPanel.add(panel);
		
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
			}
		});

		serverResponseLabel.setHTML("<pre>"+puppetText+"</pre>");
		dialogBox.center();
		closeButton.setFocus(true);

	}

}
