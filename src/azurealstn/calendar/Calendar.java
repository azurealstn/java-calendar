package azurealstn.calendar;

import java.util.Scanner;

public class Calendar {
	
	//2월 달력
	public void printSampleCalendar() {
		System.out.println(" 일 월  화  수 목  금 토");
		System.out.println("-----------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}
	
	private final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	//최대 day를 출력하는 함수
	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}
	
	public static void main(String[] args) {
		//month를 입력받아 그 month달의 최대 day(일수)를 출력
		String PROMPT = "cal>";
		Scanner sc = new Scanner(System.in);
		Calendar calc = new Calendar(); //생성자 생성
		
		int month = 1;
		while (true) {
			System.out.println("월을 입력하세요.");
			System.out.print(PROMPT);
			month = sc.nextInt();
			if (month == -1) break;
			//int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			if (month < 1 || month > 12) continue;
			System.out.printf("%d월은 %d일까지 있습니다. \n", month, calc.getMaxDaysOfMonth(month));
		}
		System.out.println("Over!");
		sc.close();
	}
}
