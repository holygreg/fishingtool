package control;

import javax.swing.JOptionPane;

import view.ControlledPanel;

/**
 * Abstract superclass that must be extended by all controllers for controlled
 * panels. Controlled panels will call the method
 * {@link #setPanel(ControlledPanel controlledPanel)} with themselves as an
 * argument in order to connect them to their corresponding controller.
 * 
 * @author gregor
 *
 */
public abstract class PanelController {

	/**
	 * Controlled panel that will be controlled by the PanelController
	 */
	protected ControlledPanel controlledPanel;

	/**
	 * Sets the ControlledPanel to be controlled by the controller. This method will
	 * be called by the corresponding ControlledPanel that takes a PanelController
	 * as an constructor-argument.
	 * 
	 * @param controlledPanel
	 *            ControlledPanel to be controlled
	 */
	public void setPanel(ControlledPanel controlledPanel) {
		this.controlledPanel = controlledPanel;
	}

	/**
	 * This method must be implemented to set all necessary ActionListeners to the
	 * elements of the corresponding ControlledPanel.
	 */
	public abstract void setActionListeners();

	/**
	 * This method launches a JOptionPane showing the given message
	 * 
	 * @param message
	 *            message to be shown by the JOptionPane
	 */
	protected void showMessage(String message) {
		JOptionPane.showMessageDialog(controlledPanel.getParent(), message);
	}

}
