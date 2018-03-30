package control;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import persist.dao.impl.BaitDaoImpl;
import persist.dao.impl.CatchDaoImpl;
import persist.dao.impl.HookDaoImpl;
import persist.dao.impl.SpeciesDaoImpl;
import persist.dao.interfaces.BaitDaoInterface;
import persist.dao.interfaces.CatchDaoInterface;
import persist.dao.interfaces.HookDaoInterface;
import persist.dao.interfaces.SpeciesDaoInterface;
import persist.entities.Bait;
import persist.entities.Catch;
import persist.entities.Hook;
import persist.entities.HookKey;
import persist.entities.Species;
import util.DayTime;
import util.Weather;
import view.ifaces.CreateCatchPanel;

public class CreateCatchController extends PanelController {

	private final SpeciesDaoInterface speciesDao = new SpeciesDaoImpl();
	private final BaitDaoInterface baitDao = new BaitDaoImpl();
	private final HookDaoInterface hookDao = new HookDaoImpl();
	private final CatchDaoInterface catchDao = new CatchDaoImpl();

	private String selectedSpecies;
	private Date dateOfCatch;
	private DayTime dayTime;
	private Weather weather;
	private String temperature;
	private String selectedBait;
	private String selectedHook;
	private String weight;
	private String size;

	private List<String> speciesNames = getAllSpeciesFromDatabase();
	private List<String> baitNames = getAllBaitsFromDatabase();
	private Map<String, HookKey> hookNames = getAllHooksFromDatabase();

	@Override
	public void setActionListeners() {
		CreateCatchPanel catchPanel = (CreateCatchPanel) controlledPanel;

		catchPanel.setRefreshSpeciesBoxListener(e -> {
			speciesNames = getAllSpeciesFromDatabase();
			catchPanel.getSpeciesBox().removeAllItems();
			speciesNames.forEach(s -> catchPanel.getSpeciesBox().addItem(s));
		});

		catchPanel.setRefreshBaitBoxListener(e -> {
			baitNames = getAllBaitsFromDatabase();
			catchPanel.getBaitBox().removeAllItems();
			baitNames.forEach(s -> catchPanel.getBaitBox().addItem(s));
		});

		catchPanel.setRefreshHookBoxListener(e -> {
			hookNames = getAllHooksFromDatabase();
			catchPanel.getHookBox().removeAllItems();
			hookNames.keySet().forEach(s -> catchPanel.getHookBox().addItem(s));
		});

		catchPanel.setCreateButtonActionListener(e -> {
			selectedSpecies = (String) catchPanel.getSpeciesBox().getSelectedItem();
			dateOfCatch = catchPanel.getDatePicker().getDate();
			dayTime = (DayTime) catchPanel.getDayTimeBox().getSelectedItem();
			weather = (Weather) catchPanel.getWeatherBox().getSelectedItem();
			temperature = catchPanel.getTemperatureField().getText();
			selectedBait = (String) catchPanel.getBaitBox().getSelectedItem();
			selectedHook = (String) catchPanel.getHookBox().getSelectedItem();
			weight = catchPanel.getWeightField().getText();
			size = catchPanel.getSizeField().getText();

			if (temperature.isEmpty()) {
				showMessage("Es muss eine Temperatur angegeben werden!");
				return;
			} else if (weight.isEmpty()) {
				showMessage("Es muss ein Gewicht angegeben werden!");
				return;
			} else if (size.isEmpty()) {
				showMessage("Es muss eine Größe angegeben werden!");
				return;
			}

			Species species = speciesDao.findById(selectedSpecies);
			Bait bait = baitDao.findById(selectedBait);
			Hook hook = hookDao.findById(hookNames.get(selectedHook));
			float temperature_;
			float weight_;
			float size_;
			
			try {
				temperature_ = Float.valueOf(temperature);
			} catch (NumberFormatException exception) {
				showMessage("Die Temperatur muss als Zahl angegeben werden!");
				return;
			}
			try {
				weight_ = Float.valueOf(weight);
			} catch (NumberFormatException exception) {
				showMessage("Das Gewicht muss als Zahl angegeben werden!");
				return;
			}
			try {
				size_ = Float.valueOf(size);
			} catch (NumberFormatException exception) {
				showMessage("Die Größe muss als Zahl angegeben werden!");
				return;
			}

			Catch catch_ = new Catch();
			catch_.setSpecies(species);
			catch_.setDate(dateOfCatch);
			catch_.setDayTime(dayTime);
			catch_.setWeather(weather);
			catch_.setTemperature(temperature_);
			catch_.setBait(bait);
			catch_.setHook(hook);
			catch_.setWeight(weight_);
			catch_.setSize(size_);

			catchDao.saveOrUpdate(catch_);

			catchPanel.getTemperatureField().setText("");
			catchPanel.getWeightField().setText("");
			catchPanel.getSizeField().setText("");
			catchPanel.getDatePicker().setDate(new Date());

		});

	}

	public List<String> getAllSpeciesFromDatabase() {
		return speciesDao.findAll().stream().map(x -> x.getName()).collect(Collectors.toList());
	}

	public List<String> getAllBaitsFromDatabase() {
		return baitDao.findAll().stream().map(x -> x.getName()).collect(Collectors.toList());
	}

	public Map<String, HookKey> getAllHooksFromDatabase() {
		return hookDao.findAll().stream()
				.collect(Collectors.toMap(
						x -> String.valueOf(x.getHookSize()) + "," + (x.isBarb() ? "Widerhaken" : "ohne Widerhaken"),
						x -> x.getId()));
	}
}
