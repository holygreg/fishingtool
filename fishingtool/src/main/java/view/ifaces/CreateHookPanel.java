package view.ifaces;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public interface CreateHookPanel {

	public void setCreateButtonActionListener(ActionListener actionListener);

	public JButton getCreateButton();

	public JTextField getHook_sizeField();

	public JComboBox<String> getBarb_box();
}
