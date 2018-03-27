package view.elements;

import javax.swing.JComboBox;

import config.Config;

public class CustomComboBox<E> extends JComboBox<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomComboBox(E[] items) {
		super(items);
		setFont(this.getFont().deriveFont(Config.jComboBoxFontSize));
	}

}
