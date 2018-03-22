package view;

import java.awt.EventQueue;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import control.CreateBaitController;

public class MainApplicationFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar;
	private Map<String, MenuContainer> menuContainers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MainApplicationFrameBuilder().setDefaultMenus()
							// .addMenu("fang", new MenuContainer("fang", new JMenu("Fang")))
							// .addMenuItemToMenu("fang",
							// new MenuItemContainer("anlegen", new JMenuItem("Fang anlegen"), new
							// JPanel()))
							.build().initAndRun();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initAndRun() {

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuContainers.forEach((k, v) -> menuBar.add(v.getjMenu()));
		menuContainers
				.forEach((k, v) -> v.getMenuItemContainers().forEach((a, b) -> b.getMenuItem().addActionListener(e -> {
					setContentPane(b.getPanel());
					validate();
					repaint();
				})));

		setContentPane(menuContainers.values().iterator().next().getMenuItemContainers().values().iterator().next()
				.getPanel());

		this.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	private MainApplicationFrame(Map<String, MenuContainer> menuContainers) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		this.menuContainers = menuContainers;

	}

	public static class MainApplicationFrameBuilder {

		private Map<String, MenuContainer> menuContainers;

		public MainApplicationFrameBuilder() {
			menuContainers = new LinkedHashMap<>();
		}

		public MainApplicationFrameBuilder setDefaultMenus() {

			MenuContainer köder = new MenuContainer("köder", new JMenu("Köder"));

			köder.addMenuItemContainer("köder_anlegen", new MenuItemContainer("anlegen", new JMenuItem("Köder anlegen"),
					new CreateEntityPanelTemplate(new CreateBaitPanelImpl(new CreateBaitController()), 8, 2)));
			// köder.addMenuItemContainer("köder_anzeigen",
			// new MenuItemContainer("anzeigen", new JMenuItem("Köder anzeigen"), new
			// JPanel()));

			menuContainers.put("köder", köder);

			return this;
		}

		public MainApplicationFrameBuilder addMenu(String menuName, MenuContainer menuContainer) {
			menuContainers.put(menuName, menuContainer);
			return this;
		}

		public MainApplicationFrameBuilder addMenuItemToMenu(String menuName, MenuItemContainer menuItemContainer) {
			if (menuContainers.containsKey(menuName))
				menuContainers.get(menuName).addMenuItemContainer(menuItemContainer.getName(), menuItemContainer);
			return this;
		}

		public MainApplicationFrame build() {
			return new MainApplicationFrame(menuContainers);
		}

	}

}