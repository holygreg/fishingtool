package persist.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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

	@EmbeddedId
	private HookKey id;

	@OneToMany(mappedBy = "hook")
	private Set<Catch> catches;

	public int getHookSize() {
		return id.getHookSize();
	}

	public boolean isBarb() {
		return id.isBarb();
	}

	public HookKey getId() {
		return id;
	}

	public void setId(HookKey id) {
		this.id = id;
	}

	public Set<Catch> getCatches() {
		return catches;
	}

	public void setCatches(Set<Catch> catches) {
		this.catches = catches;
	}
}
