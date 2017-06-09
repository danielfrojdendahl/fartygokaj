package se.iths.Skeppokaj.domain;

import java.util.Date;
import java.util.List;

public class WeekReport {

	private Date			fromDate;
	private Date			toDate;
	private List<DayReport> reports;
	
	
	public WeekReport(Date fromDate, Date toDate, List<DayReport> reports) {
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.reports = reports;
	}
	
	public Date getFromDate() {
		return fromDate;
	}
	
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	
	public Date getToDate() {
		return toDate;
	}
	
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	public List<DayReport> getReports() {
		return reports;
	}
	
	public void setReports(List<DayReport> reports) {
		this.reports = reports;
	}
	
}
