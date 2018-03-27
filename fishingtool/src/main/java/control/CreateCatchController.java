package control;

import java.util.List;
import java.util.stream.Collectors;

import persist.dao.impl.BaitDaoImpl;
import persist.dao.impl.HookDaoImpl;
import persist.dao.impl.SpeciesDaoImpl;
import persist.dao.interfaces.BaitDaoInterface;
import persist.dao.interfaces.HookDaoInterface;
import persist.dao.interfaces.SpeciesDaoInterface;
import view.ifaces.CreateCatchPanel;

public class CreateCatchController extends PanelController {

	private final SpeciesDaoInterface speciesDao = new SpeciesDaoImpl();
	private final BaitDaoInterface baitDao = new BaitDaoImpl();
	private final HookDaoInterface hookDao = new HookDaoImpl();

	@Override
	public void setActionListeners() {
		CreateCatchPanel catchPanel = (CreateCatchPanel) controlledPanel;

		catchPanel.setRefreshSpeciesBoxListener(e -> {
			List<String> speciesNames = speciesDao.findAll().stream().map(x -> x.getName())
					.collect(Collectors.toList());
			catchPanel.getSpeciesBox().removeAllItems();
			speciesNames.forEach(s -> catchPanel.getSpeciesBox().addItem(s));
		});

		catchPanel.setRefreshBaitBoxListener(e -> {
			List<String> baitNames = baitDao.findAll().stream().map(x -> x.getName()).collect(Collectors.toList());
			catchPanel.getBaitBox().removeAllItems();
			baitNames.forEach(s -> catchPanel.getBaitBox().addItem(s));
		});

		catchPanel.setRefreshHookBoxListener(e -> {
			List<String> hookNames = hookDao.findAll().stream()
					.map(x -> String.valueOf(x.getHookSize()) + "," + (x.isBarb() ? "Widerhaken" : "ohne Widerhaken"))
					.collect(Collectors.toList());
			catchPanel.getHookBox().removeAllItems();
			hookNames.forEach(s -> catchPanel.getHookBox().addItem(s));
		});

	}
}
