package control;

import persist.dao.impl.HookDaoImpl;
import persist.dao.interfaces.HookDaoInterface;
import persist.entities.Hook;
import view.CreateHookPanelImpl;
import view.ifaces.CreateHookPanel;

public class CreateHookController extends PanelController {

	private String hookSize;

	private String barb;

	private final HookDaoInterface hookDao = new HookDaoImpl();

	@Override
	public void setActionListeners() {
		CreateHookPanelImpl createHookPanel = (CreateHookPanelImpl) controlledPanel;

		createHookPanel.setCreateButtonActionListener(e -> {

			hookSize = createHookPanel.getHook_sizeField().getText();
			barb = (String) createHookPanel.getBarb_box().getSelectedItem();

			if (hookSize.isEmpty())
				showMessage("Es muss eine Hakengröße angegeben werden!");
			else {
				Hook hook = new Hook();
				try {
					hook.setHookSize(Integer.valueOf(hookSize));
				} catch (NumberFormatException exception) {
					showMessage("Die Hakengröße muss als Ganzzahl angegeben werden!");
					return;
				}
				hook.setBarb(barb.equals("Ja") ? true : false);

				hookDao.persist(hook);

				createHookPanel.getHook_sizeField().setText("");
				createHookPanel.validate();
				createHookPanel.repaint();
			}

		});

	}

}
