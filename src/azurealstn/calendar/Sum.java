package azurealstn.calendar;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		String s1, s2;
		System.out.println("두 수를 입력하기: ");
		s1 = sc.next();
		s2 = sc.next();
		
		a = Integer.parseInt(s1);
		b = Integer.parseInt(s2);
//		System.out.println("입력된 두 수: " + a + ", " + b);
//		System.out.println("두 수의 합: " + (a + b));
		System.out.printf("%d와 %d의 합: %d", a, b, a + b);
		sc.close();
	}

}
