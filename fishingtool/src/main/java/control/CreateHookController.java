package control;

import persist.dao.impl.HookDaoImpl;
import persist.dao.interfaces.HookDaoInterface;
import persist.entities.Hook;
import persist.entities.HookKey;
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
				int hookSize;
				Hook hook = new Hook();
				try {
					hookSize = Integer.valueOf(this.hookSize);
				} catch (NumberFormatException exception) {
					showMessage("Die Hakengröße muss als Ganzzahl angegeben werden!");
					return;
				}
				HookKey hookKey = new HookKey();
				hookKey.setHookSize(hookSize);
				hookKey.setBarb(barb.equals("Ja") ? true : false);
				hook.setId(hookKey);
				hookDao.saveOrUpdate(hook);

				createHookPanel.getHook_sizeField().setText("");
				createHookPanel.validate();
				createHookPanel.repaint();
			}

		});

	}

}
