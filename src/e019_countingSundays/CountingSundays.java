/*You are given the following information, but you may prefer to do some research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 *
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

package e019_countingSundays;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CountingSundays {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		int sundaysGauss = 0;
		int sundaysCalendar = 0;
		int year = 0;
		int month = 0;
		int dayOfWeek = 0;
		String yourDate = "";
		Calendar c = Calendar.getInstance();

		for (year = 1901; year < 2001; year++) {
			for (month = 1; month < 13; month++) {

				// Java Calendar API
				yourDate = "01/" + month + "/" + year;
				c.setTime(new SimpleDateFormat("dd/M/yyyy").parse(yourDate));
				dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
				if (dayOfWeek == 7)
					sundaysCalendar++;
				// ----------------------------
				// Method using Gaussian formula
				if (gaussDay(year, month, 1) == 0)
					sundaysGauss++;

			}
		}

	}

	/*
	 * Gaussian formula for calculating day of the week [Mon - Sun] given the
	 * date Returns 0 for Sun; 1 - 6 for Mon - Sat
	 * 
	 * w=(d+floor((13*m-1)/5))+y+floor(y/4)+(c/4)-2c)mod7 Where Y: year-1 for
	 * January or February, year for the rest of the year d: day (1 to 31) m:
	 * shifted month (March=1,...February=12), eg. ((month + 9) % 12) + 1 y:
	 * last 2 digits of Y c: first 2 digits of Y / w: day of week
	 * (0=Sunday,..6=Saturday)
	 */
	public static int gaussDay(int year, int month, int day) {

		int Y = year;
		if (month < 3)
			Y = Y - 1;
		int d = day;
		int m = ((month + 9) % 12) + 1;
		int y = Y % 100;
		int c = Integer.parseInt(("" + Y).substring(0, 2));

		double w = (d + Math.floor((13 * m - 1) / 5) + y + Math.floor(y / 4)
				+ Math.floor(c / 4) - 2 * c) % 7;

		return (int) w;
	}

	public static void display(int gaussCount, int calAPICount) {
		String out = "The number of Sundays that fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000): \nGauss Formula: "
				+ gaussCount + "\nJava Calendar API: " + calAPICount;
		System.out.println(out);
	}
}
