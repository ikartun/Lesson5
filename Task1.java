package by.epam.tr.lesson5;

import java.util.GregorianCalendar;
import java.util.Calendar;

public class Task1 {
	private static GregorianCalendar gCalendar = new GregorianCalendar(); 
	private static int today = gCalendar.get(Calendar.DAY_OF_MONTH);
	private static int todayMonth = gCalendar.get(Calendar.MONTH);
	
	public static void main(String[] args) {
		GregorianCalendar d1 = new GregorianCalendar(gCalendar.get(Calendar.YEAR), 0, 1);
		GregorianCalendar d2 = new GregorianCalendar(gCalendar.get(Calendar.YEAR), 1, 1);
		GregorianCalendar d3 = new GregorianCalendar(gCalendar.get(Calendar.YEAR), 2, 1);
		boolean b1 = true;
		boolean b2 = true;
		boolean b3 = true;
		
		for (int j = 1; j <= 4; j++) {
			System.out.println("");
			System.out.println("Вс Пн Вт Ср Чт Пт Сб    Вс Пн Вт Ср Чт Пт Сб    Вс Пн Вт Ср Чт Пт Сб");
			b1 = b2 = b3 = true;
			for (int i = 1; i <= 6; i++) {
				if (!b1 && !b2 && !b3) {
					break;
				}
				else {				
					if (b1) {
						b1 = printWeek(d1, d1.get(Calendar.MONTH), d1.get(Calendar.DAY_OF_WEEK), i);
					}
					else {
						System.out.print("                        ");
					}
					
					if (b2) {
						b2 = printWeek(d2, d2.get(Calendar.MONTH), d2.get(Calendar.DAY_OF_WEEK), i);
					}
					else {
						System.out.print("                        ");
					}
					
					if (b3) {
						b3 = printWeek(d3, d3.get(Calendar.MONTH), d3.get(Calendar.DAY_OF_WEEK), i);
					}
					else {
						System.out.print("                        ");
					}
				}
				System.out.println("");
			}			
		}
	}
	
	private static boolean printWeek(GregorianCalendar d, int month, int weekday, int week) {		
		if (week == 1) {
			for(int i = Calendar.SUNDAY; i < weekday; i++) {
				System.out.print("   ");
			}			
		}
		
		do {				
			int day = d.get(Calendar.DAY_OF_MONTH);
			
			if(day < 10) {
				System.out.print(" ");
			}
				
			System.out.print(day);
				
			if (month == todayMonth && day == today) {
				System.out.print("*");
			}
			else {
				System.out.print(" ");
			}
			
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
		}
		while(weekday != Calendar.SUNDAY && d.get(Calendar.MONTH) == month);
		
		if (d.get(Calendar.MONTH) != month) {
			if (weekday != 1) {
				for(int i = weekday; i <= Calendar.SATURDAY; i++) {
					System.out.print("   ");
				}
			}
			
			d.set(Calendar.MONTH, d.get(Calendar.MONTH) + 2);
			System.out.print("   ");
			
			return false;
		}
		
		System.out.print("   ");
		
		return true;
	}
}
