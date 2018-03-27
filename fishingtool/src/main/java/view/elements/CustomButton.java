package view.elements;

import javax.swing.JButton;

import config.Config;

public class CustomButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomButton(String name) {
		super(name);
		setFont(this.getFont().deriveFont(Config.jButtonFontSize));
	}

}
