package persist.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

@Embeddable
public class HookKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "hook_size")
	private int hookSize;

	@Column(name = "barb")
	@Type(type = "numeric_boolean")
	private boolean barb;

	public HookKey(int hookSize, boolean barb) {
		this.hookSize = hookSize;
		this.barb = barb;
	}

	public HookKey() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (barb ? 1231 : 1237);
		result = prime * result + hookSize;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HookKey other = (HookKey) obj;
		if (barb != other.barb)
			return false;
		if (hookSize != other.hookSize)
			return false;
		return true;
	}
}
