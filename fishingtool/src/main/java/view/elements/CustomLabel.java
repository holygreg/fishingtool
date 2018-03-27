package view.elements;

import javax.swing.JLabel;

import config.Config;

public class CustomLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomLabel(String name) {
		super(name);
		setFont(this.getFont().deriveFont(Config.jLabelFontSize));
	}
	
	public CustomLabel() {
		setFont(this.getFont().deriveFont(Config.jLabelFontSize));
	}

}