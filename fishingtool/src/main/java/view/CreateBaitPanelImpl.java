package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import control.PanelController;
import util.BaitType;
import view.ifaces.CreateBaitPanel;
import view.ifaces.DecoratablePanel;

public class CreateBaitPanelImpl extends ControlledPanel implements CreateBaitPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField nameField;
	private JTextField brand_field;
	private JTextField price_field;
	private JTextField weightField;
	private JTextField shopField;
	private JLabel shop;
	private JLabel weight;
	private JComboBox<util.Color> colorBox;
	private JLabel color;
	private JComboBox<BaitType> baitBox;
	private JLabel bait_type;
	private JLabel price;
	private JLabel brand;
	private JLabel name;
	private JButton createButton;

	/**
	 * Create the panel.
	 */
	public CreateBaitPanelImpl(PanelController panelController) {
		super(panelController);
	}

	@Override
	public void setCreateButtonActionListener(ActionListener actionListener) {
		createButton.addActionListener(actionListener);
	}

	public JTextField getNameField() {
		return nameField;
	}

	public JTextField getBrand_field() {
		return brand_field;
	}

	public JTextField getPrice_field() {
		return price_field;
	}

	public JTextField getWeightField() {
		return weightField;
	}

	public JTextField getShopField() {
		return shopField;
	}

	public JComboBox<util.Color> getColorBox() {
		return colorBox;
	}

	public JComboBox<BaitType> getBaitBox() {
		return baitBox;
	}

	public JButton getCreateButton() {
		return createButton;
	}

	@Override
	protected void initPanel() {
		name = new JLabel("Produktname");
		contentPanel.add(name);

		nameField = new JTextField();
		contentPanel.add(nameField);
		nameField.setColumns(10);

		brand = new JLabel("Marke");
		contentPanel.add(brand);

		brand_field = new JTextField();
		contentPanel.add(brand_field);
		brand_field.setColumns(10);

		price = new JLabel("Preis");
		contentPanel.add(price);

		price_field = new JTextField();
		contentPanel.add(price_field);
		price_field.setColumns(10);

		bait_type = new JLabel("Ködertyp");
		contentPanel.add(bait_type);

		baitBox = new JComboBox<BaitType>(BaitType.values());
		contentPanel.add(baitBox);

		color = new JLabel("Farbe");
		contentPanel.add(color);

		colorBox = new JComboBox<util.Color>(util.Color.values());
		contentPanel.add(colorBox);

		weight = new JLabel("Gewicht");
		contentPanel.add(weight);

		weightField = new JTextField();
		contentPanel.add(weightField);
		weightField.setColumns(10);

		shop = new JLabel("Geschäft");
		contentPanel.add(shop);

		shopField = new JTextField();
		contentPanel.add(shopField);
		shopField.setColumns(10);

		createButton = new JButton("Anlegen");
		contentPanel.add(createButton);
	}

}
