package azurealstn.calendar;

import java.util.Scanner;

public class Prompt {

	//private final static String PROMPT = "cal> ";
	
	//첫번째 요일
	public int parseDay(String week) {
		if (week.equals("su")) return 0;
		else if (week.equals("mo")) return 1;
		else if (week.equals("tu")) return 2;
		else if (week.equals("we")) return 3;
		else if (week.equals("th")) return 4;
		else if (week.equals("fr")) return 5;
		else if (week.equals("sa")) return 6;
		else return 0;
	}

	public void runPrompt() {
		// month를 입력받아 그 month달의 최대 day(일수)를 출력
		Scanner sc = new Scanner(System.in);
		Calendar calc = new Calendar(); // 생성자 생성

		int month;
		int year;
		int weekday;
		while (true) {
			System.out.println("년도를 입력하세요. exit: -1");
			System.out.print("YEAR>");
			year = sc.nextInt();
			System.out.println("월을 입력하세요.exit: -1");
			System.out.print("MONTH>");
			month = sc.nextInt();
			System.out.println("첫번째 요일을 입력하세요. (SU, MO, TU, WE, TH, FR, SA)");
			String str_weekday = sc.next();
			weekday = parseDay(str_weekday);
			System.out.println(weekday + ", " + str_weekday);
			if (month == -1 || year == -1)
				break;
			// int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			if (month < 1 || month > 12)
				continue;
			calc.printCalendar(year, month, weekday);
		}
		System.out.println("Over!");
		sc.close();
	}

	public static void main(String[] args) {
		//쉘 실행
		Prompt pt = new Prompt();
		pt.runPrompt();
	}

}
