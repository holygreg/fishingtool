package view;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import org.jdesktop.swingx.JXDatePicker;

import control.PanelController;
import persist.dao.impl.BaitDaoImpl;
import persist.dao.impl.HookDaoImpl;
import persist.dao.impl.SpeciesDaoImpl;
import persist.dao.interfaces.BaitDaoInterface;
import persist.dao.interfaces.HookDaoInterface;
import persist.dao.interfaces.SpeciesDaoInterface;
import util.DayTime;
import util.Weather;
import view.elements.CustomButton;
import view.elements.CustomComboBox;
import view.elements.CustomLabel;
import view.elements.CustomTextField;
import view.ifaces.CreateCatchPanel;

public class CreateCatchPanelImpl extends ControlledPanel implements CreateCatchPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CustomLabel species;
	private CustomLabel catchDate;
	private CustomLabel dayTime;
	private CustomLabel weather;
	private CustomLabel temperature;
	private CustomLabel bait;
	private CustomLabel hook;
	private CustomLabel weight;
	private CustomLabel size;
	private CustomComboBox<String> speciesBox;
	private CustomButton refreshSpeciesBox;
	private JXDatePicker catchDatePicker;
	private CustomComboBox<DayTime> dayTimeBox;
	private CustomComboBox<Weather> weatherBox;
	private CustomTextField temperatureField;
	private CustomComboBox<String> baitBox;
	private CustomButton refreshBaitBox;
	private CustomComboBox<String> hookBox;
	private CustomButton refreshHookBox;
	private CustomTextField weightField;
	private CustomTextField sizeField;
	private CustomButton createButton;

	public CreateCatchPanelImpl(PanelController panelController) {
		super(panelController);
	}

	@Override
	public void setCreateButtonActionListener(ActionListener actionListener) {
		createButton.addActionListener(actionListener);
	}

	@Override
	public CustomComboBox<String> getSpeciesBox() {
		return speciesBox;
	}

	@Override
	public JXDatePicker getDatePicker() {
		return catchDatePicker;
	}

	@Override
	public CustomComboBox<DayTime> getDayTimeBox() {
		return dayTimeBox;
	}

	@Override
	public CustomComboBox<Weather> getWeatherBox() {
		return weatherBox;
	}

	@Override
	public CustomTextField getTemperatureField() {
		return temperatureField;
	}

	@Override
	public CustomComboBox<String> getBaitBox() {
		return baitBox;
	}

	@Override
	public CustomComboBox<String> getHookBox() {
		return hookBox;
	}

	@Override
	public CustomTextField getWeightField() {
		return weightField;
	}

	@Override
	public CustomTextField getSizeField() {
		return sizeField;
	}

	@Override
	public CustomButton getCreateButton() {
		return createButton;
	}

	@Override
	protected void initPanel() {
		SpeciesDaoInterface speciesDao = new SpeciesDaoImpl();
		BaitDaoInterface baitDao = new BaitDaoImpl();
		HookDaoInterface hookDao = new HookDaoImpl();

		List<String> speciesNames = speciesDao.findAll().stream().map(x -> x.getName()).collect(Collectors.toList());
		List<String> baitNames = baitDao.findAll().stream().map(x -> x.getName()).collect(Collectors.toList());
		List<String> hookNames = hookDao.findAll().stream()
				.map(x -> String.valueOf(x.getHookSize()) + "," + (x.isBarb() ? "Widerhaken" : "ohne Widerhaken"))
				.collect(Collectors.toList());

		species = new CustomLabel("Spezies");
		contentPanel.add(species);

		speciesBox = new CustomComboBox<String>(speciesNames.toArray(new String[speciesNames.size()]));
		contentPanel.add(speciesBox);

		refreshSpeciesBox = new CustomButton("refresh");
		contentPanel.add(refreshSpeciesBox);

		catchDate = new CustomLabel("Fangdatum");
		contentPanel.add(catchDate);

		catchDatePicker = new JXDatePicker();
		contentPanel.add(catchDatePicker);

		contentPanel.add(new CustomLabel());

		dayTime = new CustomLabel("Tageszeit");
		contentPanel.add(dayTime);

		dayTimeBox = new CustomComboBox<>(DayTime.values());
		contentPanel.add(dayTimeBox);

		contentPanel.add(new CustomLabel());

		weather = new CustomLabel("Wetter");
		contentPanel.add(weather);

		weatherBox = new CustomComboBox<>(Weather.values());
		contentPanel.add(weatherBox);

		contentPanel.add(new CustomLabel());

		temperature = new CustomLabel("Temperatur");
		contentPanel.add(temperature);

		temperatureField = new CustomTextField();
		contentPanel.add(temperatureField);

		contentPanel.add(new CustomLabel());

		bait = new CustomLabel("Köder");
		contentPanel.add(bait);

		baitBox = new CustomComboBox<>(baitNames.toArray(new String[baitNames.size()]));
		contentPanel.add(baitBox);

		refreshBaitBox = new CustomButton("refresh");
		contentPanel.add(refreshBaitBox);

		hook = new CustomLabel("Haken");
		contentPanel.add(hook);

		hookBox = new CustomComboBox<>(hookNames.toArray(new String[hookNames.size()]));
		contentPanel.add(hookBox);

		refreshHookBox = new CustomButton("refresh");
		contentPanel.add(refreshHookBox);

		weight = new CustomLabel("Gewicht");
		contentPanel.add(weight);

		weightField = new CustomTextField();
		contentPanel.add(weightField);

		contentPanel.add(new CustomLabel());

		size = new CustomLabel("Größe");
		contentPanel.add(size);

		sizeField = new CustomTextField();
		contentPanel.add(sizeField);

		contentPanel.add(new CustomLabel());

		createButton = new CustomButton("Anlegen");
		contentPanel.add(createButton);

	}

	@Override
	public void setRefreshSpeciesBoxListener(ActionListener actionListener) {
		refreshSpeciesBox.addActionListener(actionListener);
	}

	@Override
	public void setRefreshBaitBoxListener(ActionListener actionListener) {
		refreshBaitBox.addActionListener(actionListener);
	}

	@Override
	public void setRefreshHookBoxListener(ActionListener actionListener) {
		refreshHookBox.addActionListener(actionListener);
	}

	@Override
	public CustomButton getRefreshSpeciesBoxButton() {
		return refreshSpeciesBox;
	}

	@Override
	public CustomButton getRefreshBaitBoxButton() {
		return refreshBaitBox;
	}

	@Override
	public CustomButton getRefreshHookBoxButton() {
		return refreshHookBox;
	}

}
