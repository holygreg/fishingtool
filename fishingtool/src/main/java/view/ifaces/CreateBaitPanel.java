package view.ifaces;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import util.BaitType;

public interface CreateBaitPanel {

	public void setCreateButtonActionListener(ActionListener actionListener);

	public JTextField getNameField();

	public JTextField getBrand_field();

	public JTextField getPrice_field();

	public JTextField getWeightField();

	public JTextField getShopField();

	public JComboBox<util.Color> getColorBox();

	public JComboBox<BaitType> getBaitBox();

	public JButton getCreateButton();
}
