package view;

import java.awt.event.ActionListener;

import control.PanelController;
import view.elements.CustomButton;
import view.elements.CustomComboBox;
import view.elements.CustomLabel;
import view.elements.CustomTextField;
import view.ifaces.CreateHookPanel;

public class CreateHookPanelImpl extends ControlledPanel implements CreateHookPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateHookPanelImpl(PanelController panelController) {
		super(panelController);
	}

	private CustomLabel hook_size;
	private CustomLabel barb;
	private CustomTextField hook_sizeField;
	private CustomComboBox<String> barb_box;
	private CustomButton createButton;

	@Override
	protected void initPanel() {
		hook_size = new CustomLabel("Hakengröße");
		contentPanel.add(hook_size);

		hook_sizeField = new CustomTextField();
		contentPanel.add(hook_sizeField);
		hook_sizeField.setColumns(10);

		barb = new CustomLabel("Widerhaken");
		contentPanel.add(barb);

		barb_box = new CustomComboBox<String>(new String[] { "Ja", "Nein" });
		contentPanel.add(barb_box);

		CustomLabel fill1 = new CustomLabel();
		contentPanel.add(fill1);

		CustomLabel fill2 = new CustomLabel();
		contentPanel.add(fill2);

		CustomLabel fill3 = new CustomLabel();
		contentPanel.add(fill3);

		CustomLabel fill4 = new CustomLabel();
		contentPanel.add(fill4);

		CustomLabel fill5 = new CustomLabel();
		contentPanel.add(fill5);

		CustomLabel fill6 = new CustomLabel();
		contentPanel.add(fill6);

		CustomLabel fill7 = new CustomLabel();
		contentPanel.add(fill7);

		CustomLabel fill8 = new CustomLabel();
		contentPanel.add(fill8);

		CustomLabel fill9 = new CustomLabel();
		contentPanel.add(fill9);

		CustomLabel fill10 = new CustomLabel();
		contentPanel.add(fill10);

		createButton = new CustomButton("Anlegen");
		contentPanel.add(createButton);

		CustomLabel fill11 = new CustomLabel();
		contentPanel.add(fill11);

	}

	@Override
	public void setCreateButtonActionListener(ActionListener actionListener) {
		createButton.addActionListener(actionListener);
	}

	public CustomButton getCreateButton() {
		return createButton;
	}

	public void setCreateButton(CustomButton createButton) {
		this.createButton = createButton;
	}

	public CustomTextField getHook_sizeField() {
		return hook_sizeField;
	}

	public CustomComboBox<String> getBarb_box() {
		return barb_box;
	}

}
