package persist.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name="hook_size")
	private int hookSize;
	
	@Column(name="barb")
	private boolean barb;
	
	@OneToMany(mappedBy="hook")
	private Set<Catch> catches;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHookSize() {
		return hookSize;
	}

	public void setHookSize(int hookSize) {
		this.hookSize = hookSize;
	}

	public boolean isBarb() {
		return barb;
	}

	public void setBarb(boolean barb) {
		this.barb = barb;
	}

}
