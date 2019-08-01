package api.calendar;

import java.util.Calendar;
import java.util.Date;
/**
 * 
 * 자바의 달력기능을 사용하는 클래스
 * @author Administrator
 *
 */
public class DateCalendarTest {

	public static void main(String[] args) {
		// 사용
		System.out.println(new Date(2019 - 1900, 8, 1));
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.get(calendar.YEAR) + "년" + calendar.get(calendar.MONTH) + "월" + calendar.get(calendar.DAY_OF_MONTH) + "일");
		
		calendar.set(2019, 8, 1);
		System.out.println(calendar.get(calendar.YEAR) + "년" + calendar.get(calendar.MONTH) + "월" + calendar.get(calendar.DAY_OF_MONTH) + "일");
	}

}
