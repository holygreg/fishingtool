package control;

import javax.swing.JOptionPane;

import view.ControlledPanel;

public abstract class PanelController {

	protected ControlledPanel controlledPanel;

	public void setPanel(ControlledPanel controlledPanel) {
		this.controlledPanel = controlledPanel;
	}

	public abstract void setActionListeners();

	protected void showMessage(String message) {
		JOptionPane.showMessageDialog(controlledPanel.getParent(), message);
	}

}