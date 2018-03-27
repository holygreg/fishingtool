package view.ifaces;

import java.awt.event.ActionListener;

import org.jdesktop.swingx.JXDatePicker;

import util.DayTime;
import util.Weather;
import view.elements.CustomButton;
import view.elements.CustomComboBox;
import view.elements.CustomTextField;

public interface CreateCatchPanel {

	public void setCreateButtonActionListener(ActionListener actionListener);
	
	public void setRefreshSpeciesBoxListener(ActionListener actionListener);
	
	public void setRefreshBaitBoxListener(ActionListener actionListener);
	
	public void setRefreshHookBoxListener(ActionListener actionListener);
	
	public CustomComboBox<String> getSpeciesBox();
	
	public JXDatePicker getDatePicker();
	
	public CustomComboBox<DayTime> getDayTimeBox();
	
	public CustomComboBox<Weather> getWeatherBox();
	
	public CustomTextField getTemperatureField();
	
	public CustomComboBox<String> getBaitBox();
	
	public CustomComboBox<String> getHookBox();
	
	public CustomTextField getWeightField();
	
	public CustomTextField getSizeField();
	
	public CustomButton getCreateButton();
	
	public CustomButton getRefreshSpeciesBoxButton();
	
	public CustomButton getRefreshBaitBoxButton();
	
	public CustomButton getRefreshHookBoxButton();
}
