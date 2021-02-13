package azurealstn.calendar;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
	
	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록 ");
		System.out.println("| 2. 일정 검색 ");
		System.out.println("| 3. 달력 보기 ");
		System.out.println("| h. 도움말 q. 종료 ");
		System.out.println("+----------------------+");
	}

	//private final static String PROMPT = "cal> ";
	
	//첫번째 요일
	public int parseDay(String week) {
		switch(week) {
		case "su":
			return 0;
		case "mo":
			return 1;
		case "tu":
			return 2;
		case "we":
			return 3;
		case "th":
			return 4;
		case "fr":
			return 5;
		case "sa":
			return 6;
		default:
			return 0;
		}
	}

	public void runPrompt() throws ParseException, IOException {
		printMenu();
		// month를 입력받아 그 month달의 최대 day(일수)를 출력
		Scanner sc = new Scanner(System.in);
		Calendar calc = new Calendar(); // 생성자 생성
		
		boolean isLoop = true;
		while (isLoop) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = sc.next();
			switch(cmd) {
			case "1":
				cmdRegister(sc, calc);
				break;
			case "2":
				cmdSearch(sc, calc);
				break;
			case "3":
				showCalendar(sc, calc);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop = false;
				break;
			}

		}
		System.out.println("Over!");
		sc.close();
	}

	private void showCalendar(Scanner sc, Calendar calc) {
		int month;
		int year;
		System.out.println("년도를 입력하세요. exit: -1");
		System.out.print("YEAR>");
		year = sc.nextInt();
		System.out.println("월을 입력하세요.exit: -1");
		System.out.print("MONTH>");
		month = sc.nextInt();
		//System.out.println("첫번째 요일을 입력하세요. (SU, MO, TU, WE, TH, FR, SA)");
		//String str_weekday = sc.next();
		//weekday = parseDay(str_weekday);
		//System.out.println(weekday + ", " + str_weekday);
		//if (month == -1 || year == -1)
		//	break;
		// int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (month < 1 || month > 12)
			return;
		calc.printCalendar(year, month);
		
	}

	private void cmdSearch(Scanner sc, Calendar calc) throws ParseException {
		System.out.println("[새 일정 검색]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = sc.next();
		PlanItem plan = calc.searchPlan(date);
		if (plan != null) System.out.println(plan.detail);
		else System.out.println("일정이 없습니다.");
	}

	private void cmdRegister(Scanner sc, Calendar calc) throws ParseException, IOException {
		System.out.println("[새 일정 등록]");
        System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
        String date = sc.next();
        String text = "";
        sc.nextLine();
        System.out.println("일정을 입력해 주세요.");
        text = sc.nextLine();
        calc.registerPlan(date, text);
	}

	public static void main(String[] args) throws ParseException, IOException {
		//쉘 실행
		Prompt pt = new Prompt();
		pt.runPrompt();
	}

}
