package com.support.client.view;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.support.client.util.PanelUtils;
import com.support.server.vo.ApacheVO;
import com.support.server.vo.JavaVO;
import com.support.server.vo.MySqlVO;
import com.support.server.vo.PhpVO;
import com.support.server.vo.ServerVO;
import com.support.server.vo.UserVO;

public class PuppetView extends WidgetTI {

	/* User systeme */
	private TextBox user = new TextBox();
	private TextBox password = new TextBox();

	/* Php */
	private CheckBox phpCli = new CheckBox("php5-cli");
	private CheckBox phpMysql = new CheckBox("php5-mysql");
	private CheckBox libApacheMod = new CheckBox("libapache2-mod-php5");

	/* Mysql */
	private TextBox rootPassword = new TextBox();
	private TextBox initialDbField = new TextBox();

	/*Java*/
	private CheckBox jdk = new CheckBox("jdk");
	private CheckBox jre = new CheckBox("jre");

	private CheckBox apacheCheck = new CheckBox("Apache");
	private CheckBox phpCheck = new CheckBox("PHP");
	private CheckBox mysqlCheck = new CheckBox("Mysql");
	private CheckBox javaCheck = new CheckBox("Java");
	private CheckBox userCheck = new CheckBox("Usuario");

	private HorizontalPanel hPanelUser = new HorizontalPanel();
	private HorizontalPanel hPanelApache = new HorizontalPanel();
	private HorizontalPanel hPanelPhp = new HorizontalPanel();
	private HorizontalPanel hPanelMysql = new HorizontalPanel();
	private HorizontalPanel hPanelJava = new HorizontalPanel();

	private Button sendButton = new Button("Send");

	public PuppetView() {
		super();
		init();
	}

	private void init() {

		sendButton.addStyleName("sendButton");

		final FlexTable contentTable;

		contentTable = new FlexTable();
		contentTable.getCellFormatter().setWidth(0, 0, "100%");
		contentTable.getFlexCellFormatter().setVerticalAlignment(0, 0,
				DockPanel.ALIGN_TOP);

		HTMLPanel panelUser = PanelUtils.buildPanel(userCheck);
		initFielSetUser(panelUser);

		HTMLPanel panelApache = PanelUtils.buildPanel(apacheCheck);
		initFielSetApache(panelApache);

		HTMLPanel panelPhp = PanelUtils.buildPanel(phpCheck);
		initFielSetPhp(panelPhp);

		HTMLPanel panelMysql = PanelUtils.buildPanel(mysqlCheck);
		initFielSetMysql(panelMysql);

		HTMLPanel panelJava = PanelUtils.buildPanel(javaCheck);
		initFielSetJava(panelJava);

		contentTable.getCellFormatter().addStyleName(0, 0, "contacts-ListMenu");
		contentTable.setWidget(0, 0, panelUser);
		contentTable.setWidget(1, 0, panelApache);
		contentTable.setWidget(2, 0, panelPhp);
		contentTable.setWidget(3, 0, panelMysql);
		contentTable.setWidget(4, 0, panelJava);
		contentTable.setWidget(5, 0, sendButton);

		contentTableDecorator.add(contentTable);

	}

	private void initFielSetUser(HTMLPanel panelUser) {
		VerticalPanel vPanel = new VerticalPanel();

		hPanelUser.setVisible(false);

		hPanelUser.setBorderWidth(0);
		hPanelUser.setSpacing(0);

		hPanelUser.add(new Label("Usuario:"));
		user.setText("develpment");
		password.setText("develpment");
		hPanelUser.add(user);
		hPanelUser.add(new Label("Password:"));
		hPanelUser.add(password);

		vPanel.add(hPanelUser);
		panelUser.add(vPanel);

	}

	private void initFielSetApache(HTMLPanel panelApache) {

		VerticalPanel vPanel = new VerticalPanel();

		hPanelApache.setVisible(false);
		hPanelApache.setBorderWidth(0);
		hPanelApache.setSpacing(0);

		vPanel.add(hPanelApache);

		panelApache.add(vPanel);
	}

	private void initFielSetPhp(HTMLPanel panelPhp) {

		VerticalPanel vPanel = new VerticalPanel();

		hPanelPhp.setVisible(false);
		hPanelPhp.setBorderWidth(0);
		hPanelPhp.setSpacing(0);

		hPanelPhp.add(phpCli);
		hPanelPhp.add(phpMysql);
		hPanelPhp.add(libApacheMod);
		vPanel.add(hPanelPhp);

		panelPhp.add(vPanel);

	}

	private void initFielSetMysql(HTMLPanel panelMysql) {

		VerticalPanel vPanel = new VerticalPanel();

		hPanelMysql.setVisible(false);
		hPanelMysql.setBorderWidth(0);
		hPanelMysql.setSpacing(0);

		// Focus the cursor on the name field when the app loads
		rootPassword.setText("root");
		initialDbField.setText("test");

		hPanelMysql.add(new Label("Password (root):"));
		hPanelMysql.add(rootPassword);
		hPanelMysql.add(new Label("Crear base de datos:"));
		hPanelMysql.add(initialDbField);

		vPanel.add(hPanelMysql);
		panelMysql.add(vPanel);

	}

	private void initFielSetJava(HTMLPanel panelJava) {

		VerticalPanel vPanel = new VerticalPanel();

		hPanelJava.setVisible(false);
		hPanelJava.setBorderWidth(0);
		hPanelJava.setSpacing(0);

		jre.setEnabled(false);
		jre.setValue(true);
		hPanelJava.add(jdk);
		hPanelJava.add(jre);
		vPanel.add(hPanelJava);

		panelJava.add(vPanel);
	}

	public void changePanelUser(CheckBox check) {
		hPanelUser.setVisible(check.getValue());
	}

	public void changePanelApache(CheckBox check) {
		hPanelApache.setVisible(check.getValue());

	}

	public void changePanelPhp(CheckBox check) {
		hPanelPhp.setVisible(check.getValue());

	}

	public void changePanelMysql(CheckBox check) {
		hPanelMysql.setVisible(check.getValue());

	}

	public void changePanelJava(CheckBox check) {
		hPanelJava.setVisible(check.getValue());
	}
	
	
	public ServerVO getServerDefinition(){
		
		ApacheVO apache = new ApacheVO(apacheCheck.getValue());
		PhpVO php = new PhpVO(phpCheck.getValue(),phpCli.getValue(),phpMysql.getValue(),libApacheMod.getValue());
		UserVO user = new UserVO(this.userCheck.getValue(), this.user.getText(), password.getText());
		MySqlVO mySqlVO = new MySqlVO(this.mysqlCheck.getValue(),rootPassword.getText(),initialDbField.getText());
		JavaVO javaVO = new JavaVO(this.javaCheck.getValue(),jdk.getValue(),jre.getValue());
		
		ServerVO server = new ServerVO(user,apache, php, mySqlVO, javaVO);
		return server;
	}

	/**
	 * Getters & Setters
	 * 
	 */

	public Button getSendButton() {
		return sendButton;
	}

	public TextBox getNameField() {
		return rootPassword;
	}

	public CheckBox getApacheCheck() {
		return apacheCheck;
	}

	public CheckBox getPhpCheck() {
		return phpCheck;
	}

	public CheckBox getMysqlCheck() {
		return mysqlCheck;
	}

	public CheckBox getJavaCheck() {
		return javaCheck;
	}

	public CheckBox getUserCheck() {
		return userCheck;
	}

}
