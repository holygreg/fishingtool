package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.text.NumberFormatter;

import control.PanelController;
import view.ifaces.CreateHookPanel;

public class CreateHookPanelImpl extends ControlledPanel implements CreateHookPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateHookPanelImpl(PanelController panelController) {
		super(panelController);
	}

	private JLabel hook_size;
	private JLabel barb;
	private JFormattedTextField hook_sizeField;
	private JComboBox<String> barb_box;
	private JButton createButton;

	@Override
	protected void initPanel() {
		hook_size = new JLabel("Hakengröße");
		hook_size.setPreferredSize(new Dimension(128, 19));
		hook_size.setMinimumSize(new Dimension(128, 19));
		hook_size.setMaximumSize(new Dimension(128, 19));
		contentPanel.add(hook_size);

		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		formatter.setCommitsOnValidEdit(true);

		hook_sizeField = new JFormattedTextField(formatter);
		contentPanel.add(hook_sizeField);
		hook_sizeField.setColumns(10);

		barb = new JLabel("Widerhaken");
		contentPanel.add(barb);

		barb_box = new JComboBox<String>(new String[] { "Ja", "Nein" });
		contentPanel.add(barb_box);

		JLabel fill1 = new JLabel();
		contentPanel.add(fill1);
		
		JLabel fill2 = new JLabel();
		contentPanel.add(fill2);
		
		JLabel fill3 = new JLabel();
		contentPanel.add(fill3);
		
		JLabel fill4 = new JLabel();
		contentPanel.add(fill4);
		
		JLabel fill5 = new JLabel();
		contentPanel.add(fill5);
		
		JLabel fill6 = new JLabel();
		contentPanel.add(fill6);
		
		JLabel fill7 = new JLabel();
		contentPanel.add(fill7);
		
		JLabel fill8 = new JLabel();
		contentPanel.add(fill8);
		
		JLabel fill9 = new JLabel();
		contentPanel.add(fill9);
		
		JLabel fill10 = new JLabel();
		contentPanel.add(fill10);
		
		createButton = new JButton("Anlegen");
		contentPanel.add(createButton);
		
		JLabel fill11 = new JLabel();
		contentPanel.add(fill11);
	
	}

	@Override
	public void setCreateButtonActionListener(ActionListener actionListener) {
		createButton.addActionListener(actionListener);
	}

	public JButton getCreateButton() {
		return createButton;
	}

	public void setCreateButton(JButton createButton) {
		this.createButton = createButton;
	}

	public JFormattedTextField getHook_sizeField() {
		return hook_sizeField;
	}

	public JComboBox<String> getBarb_box() {
		return barb_box;
	}

}
