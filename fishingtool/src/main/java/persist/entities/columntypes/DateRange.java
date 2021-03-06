package persist.entities.columntypes;

import java.io.Serializable;
import java.util.Date;

public class DateRange  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date start;

	private Date end;

	public DateRange(Date start, Date end) {
		this.start = start;
		this.end = end;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
}
