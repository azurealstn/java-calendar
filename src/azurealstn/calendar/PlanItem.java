package azurealstn.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {
	public Date planDate;
	public String detail;
	public String people = "";
	
	public static Date getDatefromString(String strDate) throws ParseException {
		Date date = null;
		date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		return date;
	}
	
	public PlanItem(String date, String detail) throws ParseException {
		this.planDate = getDatefromString(date);
		this.detail = detail;
	}
	
	public Date getDate() {
		return planDate;
	}
	
	public void addPeople(String name) {
		people += name + ",";
	}

	public String saveString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = formatter.format(planDate);
		return sdate + "," + "\"" + detail + "\"" + "\n";
	}
}
