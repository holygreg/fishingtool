package view;

import javax.swing.JPanel;

import control.PanelController;
import view.ifaces.DecoratablePanel;

public abstract class ControlledPanel extends JPanel implements DecoratablePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PanelController panelController;

	protected JPanel contentPanel;

	public ControlledPanel(PanelController panelController) {
		this.panelController = panelController;
		this.panelController.setPanel(this);
		contentPanel = new JPanel();
		initPanel();
		this.panelController.setActionListeners();
	}

	protected abstract void initPanel();

	@Override
	public JPanel getContentPanel() {
		return contentPanel;
	}

}
