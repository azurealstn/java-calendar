package azurealstn.calendar;

import java.util.Scanner;

public class Calendar {
	
	//2월 달력
	public void printCalendar(int year, int month) {
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println(" --------------------");
		
		int maxDay = getMaxDaysOfMonth(year, month);
		for (int i = 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == 0) System.out.println();
			
		}
		System.out.println();
//		System.out.println(" 1  2  3  4  5  6  7");
//		System.out.println(" 8  9 10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
	}
	
	private final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	//윤년인지 아닌지 boolean 타입
	public boolean isLeapYear (int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) return true;
		return false;
	}
	
	//최대 day를 출력하는 함수
	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) { //윤년일 경우
			return LEAP_MAX_DAYS[month - 1]; //윤년 최대 일수
		} else {
			return MAX_DAYS[month - 1]; //최대 일수
		}
	}
	
}
