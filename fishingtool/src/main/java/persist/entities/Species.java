package persist.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import persist.entities.columntypes.DateRange;
import persist.util.FeedingType;

@Entity
public class Species implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "image")
	private byte[] image;

	@Column(name = "closed_session")
	private DateRange closedSession;

	@Column(name = "minimum_length")
	private float minimumLength;

	@Column(name = "feeding_type")
	@Enumerated(EnumType.STRING)
	private FeedingType feedingType;
	
	@OneToMany(mappedBy="species")
	private Set<Catch> catches;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public DateRange getClosedSession() {
		return closedSession;
	}

	public void setClosedSession(DateRange closedSession) {
		this.closedSession = closedSession;
	}

	public float getMinimumLength() {
		return minimumLength;
	}

	public void setMinimumLength(float minimumLength) {
		this.minimumLength = minimumLength;
	}

	public FeedingType getFeedingType() {
		return feedingType;
	}

	public void setFeedingType(FeedingType feedingType) {
		this.feedingType = feedingType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}