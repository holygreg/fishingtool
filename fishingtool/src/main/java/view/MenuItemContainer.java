package view;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuItemContainer {

	private String name;

	private JMenuItem menuItem;

	private JPanel jPanel;

	public MenuItemContainer(String name, JMenuItem menuItem, JPanel jPanel) {
		this.name = name;
		this.menuItem = menuItem;
		this.jPanel = jPanel;
		this.jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.jPanel.setLayout(null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JMenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(JMenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public JPanel getPanel() {
		return jPanel;
	}

	public void setPanel(ControlledPanel controlledPanel) {
		this.jPanel = controlledPanel;
	}

}
