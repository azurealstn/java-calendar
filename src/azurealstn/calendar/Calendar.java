package azurealstn.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calendar {
	
	//2월 달력
	public void printCalendar(int year, int month) {
		System.out.printf("    <<%d년 %d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println(" --------------------");
		
		//get weekday automatically
		int weekday = getWeekday(year, month, 1);
		
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}
		int maxDay = getMaxDaysOfMonth(year, month);
		int count = 7 - weekday;
		
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		for (int i = count + 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == 7 - weekday) System.out.println();
			
		}
		System.out.println();
//		System.out.println(" 1  2  3  4  5  6  7");
//		System.out.println(" 8  9 10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
	}
	
	private int getWeekday(int year, int month, int day) {
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4;
		
		int count = 0;
		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}
		for (int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}
		
		count += day - 1;
		int weekday = (count + STANDARD_WEEKDAY) % 7;
		
		return weekday;
	}
	

	private final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	private HashMap<Date, String> planMap;
	
	//생성자
	public Calendar() {
		planMap = new HashMap<Date, String>(); //검색 기능
	}
	
	//일정 등록
	public void registerPlan(String strDate, String plan) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		//System.out.println(date);
		planMap.put(date, plan);
	}
	
	//검색 기능
	public String searchPlan(String strDate) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		String plan = planMap.get(date);
		return plan;
	}
	
	//윤년인지 아닌지 boolean 타입
	public boolean isLeapYear (int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) return true;
		return false;
	}
	
	//최대 day를 출력하는 함수
	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) { //윤년일 경우
			return LEAP_MAX_DAYS[month]; //윤년 최대 일수
		} else {
			return MAX_DAYS[month]; //최대 일수
		}
	}
	
	public static void main(String[] args) throws ParseException {
		Calendar calc = new Calendar();
		System.out.println(calc.getWeekday(1970, 1, 1) == 4);
		System.out.println(calc.getWeekday(1971, 1, 1) == 5);
		System.out.println(calc.getWeekday(1972, 1, 1) == 6);
		System.out.println(calc.getWeekday(1973, 1, 1) == 1);
		System.out.println(calc.getWeekday(1974, 1, 1) == 2);
		
		calc.registerPlan("2017-06-23", "Let's go");
		System.out.println(calc.searchPlan("2017-06-23").equals("Let's go"));
	}
	
}
