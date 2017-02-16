package by.epam.tr.lesson5;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;

public class Task1 {
	private static GregorianCalendar d = new GregorianCalendar();
	private static Map<Integer, Integer> monthsLastPrintedDays = new HashMap<>();
	private static int today = d.get(Calendar.DAY_OF_MONTH);
	private static int todayMonth = d.get(Calendar.MONTH);
	
	static {
		for (int i = 0; i < Calendar.DECEMBER + 1; i++) {
			monthsLastPrintedDays.put(i, 0);
		}
	}
 
	public static void main(String[] args) {
		System.out.print("Вс Пн Вт Ср Чт Пт Сб    ");
		System.out.print("Вс Пн Вт Ср Чт Пт Сб    ");
		System.out.println("Вс Пн Вт Ср Чт Пт Сб");
		for (int i = Calendar.JANUARY; i <= Calendar.DECEMBER;) {
			if (isMonthLastPrintedDayFull()) {
				break;
			}
			if (isMonthLastPrintedDay(i)) {
				if (i != Calendar.OCTOBER) {
					System.out.println();
					System.out.print("Вс Пн Вт Ср Чт Пт Сб    ");
					System.out.print("Вс Пн Вт Ср Чт Пт Сб    ");
					System.out.println("Вс Пн Вт Ср Чт Пт Сб");
					i += 3;
				}
			}
			do {
				recursivePrintLine(i, monthsLastPrintedDays.get(i) + ((isMonthLastPrintedDay(i) ? 0 : 1)));
			}
			while (d.get(Calendar.MONTH) == i + 2 && d.get(Calendar.DAY_OF_MONTH) != ((i == Calendar.JANUARY || i == Calendar.OCTOBER) ? 31 : 30));
		}

	}
	
	private static void recursivePrintLine(int month, int day) {
		
		int year = d.get(Calendar.YEAR);
		
		d.set(Calendar.MONTH, month);		
		d.set(Calendar.DAY_OF_MONTH, day);
		
		int weekday = d.get(Calendar.DAY_OF_WEEK);
		
		if (isMonthLastPrintedDay(month)) {
			for(int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {
				System.out.print("   ");
			}
			if (isMonthLastPrintedDay(month + 1)) {
				System.out.print("   ");
			}
		}
		else {		
			if (month != Calendar.JANUARY && month != Calendar.APRIL && month != Calendar.JULY && month != Calendar.OCTOBER) {
				System.out.print("   ");
			}
			
			for(int i = Calendar.SUNDAY; i < weekday; i++) {
				System.out.print("   ");
			}		
			
			do {
				day = d.get(Calendar.DAY_OF_MONTH);
				if (day < 10) {
					System.out.print(" ");
				}
				
				System.out.print(day);
				
				if (day == today && month == todayMonth) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
				
				d.add(Calendar.DAY_OF_MONTH, 1);
				weekday = d.get(Calendar.DAY_OF_WEEK);
			}
			while (weekday != Calendar.SUNDAY && d.get(Calendar.MONTH) == month);
			
			monthsLastPrintedDays.put(month, day);
			
			if (d.get(Calendar.MONTH) != month) {
				for(int i = weekday; i <= Calendar.SATURDAY; i++) {
					System.out.print("   ");
				}
			}
			
			if (((d.get(Calendar.MONTH) == Calendar.MARCH || d.get(Calendar.MONTH) == Calendar.JUNE || d.get(Calendar.MONTH) == Calendar.SEPTEMBER || d.get(Calendar.MONTH) == Calendar.DECEMBER) && weekday == Calendar.SUNDAY)
					|| ((d.get(Calendar.MONTH) == Calendar.APRIL || d.get(Calendar.MONTH) == Calendar.JULY || d.get(Calendar.MONTH) == Calendar.OCTOBER) && d.get(Calendar.MONTH) != month)
					|| (isMonthLastPrintedDay(month) && isMonthLastPrintedDay(month + 1) && isMonthLastPrintedDay(month + 2))) {
				System.out.println();
				if (year != d.get(Calendar.YEAR)) {
					d.set(Calendar.YEAR, year);
				}
				return;
			}
		}
		
		recursivePrintLine(month + 1, monthsLastPrintedDays.get(month + 1) + 1);
	}
	
	private static boolean isMonthLastPrintedDay(int month) {
		boolean result;
		
		try {
			switch (month) {
			case 0: case 2: case 4: case 6: case 7: case 9: case 11:
				result = monthsLastPrintedDays.get(month) >= 31;
				break;
			case 1:
				result = monthsLastPrintedDays.get(month) >= ((d.isLeapYear(d.get(Calendar.YEAR))) ? 29 : 28);
				break;
			default:
				result = monthsLastPrintedDays.get(month) >= 30;
			}
		}
		catch(NullPointerException e) {
			result = true;
		}
		
		return result;
	}
	
	private static boolean isMonthLastPrintedDayFull() {
		boolean result = true;
		
		for (int i = Calendar.JANUARY; i <= Calendar.DECEMBER; i++) {			
			switch (i) {
			case 0: case 2: case 4: case 6: case 7: case 9: case 11:
				result = monthsLastPrintedDays.get(i) >= 31;
				break;
			case 1:
				result = monthsLastPrintedDays.get(i) >= (d.isLeapYear(d.get(Calendar.YEAR)) ? 29 : 28);
				break;
			default:
				result = monthsLastPrintedDays.get(i) >= 30;
			}
			if (!result) {
				return result;
			}
		}		
		return result;
	}
}
