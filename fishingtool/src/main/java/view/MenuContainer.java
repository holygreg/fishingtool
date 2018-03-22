package view;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JMenu;

public class MenuContainer {

	private String name;

	private JMenu jMenu;

	private Map<String, MenuItemContainer> menuItemContainers;

	public MenuContainer(String name, JMenu jMenu) {
		this.name = name;
		this.jMenu = jMenu;
		menuItemContainers = new LinkedHashMap<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JMenu getjMenu() {
		return jMenu;
	}

	public void setjMenu(JMenu jMenu) {
		this.jMenu = jMenu;
	}

	public void addMenuItemContainer(String containerName, MenuItemContainer menuItemContainer) {
		menuItemContainers.put(containerName, menuItemContainer);
		jMenu.add(menuItemContainer.getMenuItem());
	}

	public void removeMenuItemContainer(String containerName) {

		if (menuItemContainers.containsKey(containerName)) {
			jMenu.remove(menuItemContainers.get(containerName).getMenuItem());
			menuItemContainers.remove(containerName);
		}

	}

	public Map<String, MenuItemContainer> getMenuItemContainers() {
		return menuItemContainers;
	}

}
