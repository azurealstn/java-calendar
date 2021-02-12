package azurealstn.calendar;

import java.util.Scanner;

public class Prompt {

	//private final static String PROMPT = "cal> ";

	public void runPrompt() {
		// month를 입력받아 그 month달의 최대 day(일수)를 출력
		Scanner sc = new Scanner(System.in);
		Calendar calc = new Calendar(); // 생성자 생성

		int month;
		int year;
		while (true) {
			System.out.println("년도를 입력하세요.");
			System.out.print("YEAR>");
			year = sc.nextInt();
			System.out.println("월을 입력하세요.");
			System.out.print("MONTH>");
			month = sc.nextInt();
			if (month == -1)
				break;
			// int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			if (month < 1 || month > 12)
				continue;
			calc.printCalendar(year, month);
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
