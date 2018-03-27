package view.elements;

import javax.swing.JTextField;

import config.Config;

public class CustomTextField extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomTextField(String name) {
		super(name);
		setFont(this.getFont().deriveFont(Config.jLabelFontSize));
	}

	public CustomTextField() {
		setFont(this.getFont().deriveFont(Config.jLabelFontSize));
	}

}
