package control;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import persist.dao.impl.SpeciesDaoImpl;
import persist.dao.interfaces.SpeciesDaoInterface;
import persist.entities.Species;
import persist.entities.columntypes.DateRange;
import util.FeedingType;
import view.ifaces.CreateSpeciesPanel;

public class CreateSpeciesController extends PanelController {

	private String name;

	private FeedingType feedingType;

	private String minimumLegth;

	private Date startOfClosedSession;

	private Date endOfClosedSession;

	private File imageFile;

	private final SpeciesDaoInterface speciesDao = new SpeciesDaoImpl();

	@Override
	public void setActionListeners() {
		CreateSpeciesPanel createSpeciesPanel = (CreateSpeciesPanel) controlledPanel;

		createSpeciesPanel.setChooseImageButtonActionListener(e -> {
			JFileChooser chooser = new JFileChooser();

			int choosen = chooser.showOpenDialog(null);

			if (choosen == JFileChooser.APPROVE_OPTION)
				imageFile = chooser.getSelectedFile();
		});

		createSpeciesPanel.setCreateButtonActionListener(e -> {
			name = createSpeciesPanel.getNameField().getText();
			feedingType = (FeedingType) createSpeciesPanel.getFeedingTypeBox().getSelectedItem();
			minimumLegth = createSpeciesPanel.getMinimumLengthField().getText();
			startOfClosedSession = createSpeciesPanel.getStartClosedSessionPicker().getDate();
			endOfClosedSession = createSpeciesPanel.getEndClosedSessionPicker().getDate();

			if (name.isEmpty())
				showMessage("Es muss eine Species angegeben werden!");
			else if (minimumLegth.isEmpty())
				showMessage("Es muss ein Mindestmaß angegeben werden!");
			else if (startOfClosedSession == null)
				showMessage("Es muss ein Startdatum für die Schonzeit angegeben werden!");
			else if (endOfClosedSession == null)
				showMessage("Es muss ein Enddatum für die Schonzeit angegeben werden!");
			else if (imageFile == null)
				showMessage("Es muss ein Bild angegeben werden");
			else {

				byte[] imageAsByteArray = null;
				try {
					InputStream imgStream = new FileInputStream(imageFile);
					BufferedImage img = ImageIO.read(imgStream);
					WritableRaster raster = img.getRaster();
					DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
					imageAsByteArray = data.getData();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Species species = new Species();
				species.setName(name);
				species.setFeedingType(feedingType);
				try {
					species.setMinimumLength(Float.valueOf(minimumLegth));
				} catch (NumberFormatException exception) {
					showMessage("Das Mindestmaß muss als Zahl angegeben werden!");
					return;
				}
				species.setImage(imageAsByteArray);
				species.setClosedSession(new DateRange(startOfClosedSession, endOfClosedSession));

				speciesDao.persist(species);

				createSpeciesPanel.getNameField().setText("");
				createSpeciesPanel.getMinimumLengthField().setText("");
				createSpeciesPanel.getStartClosedSessionPicker().setDate(null);
				createSpeciesPanel.getEndClosedSessionPicker().setDate(null);
				imageFile = null;
			}
		});

	}

}
