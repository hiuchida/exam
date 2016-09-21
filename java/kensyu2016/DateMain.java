package kensyu2016;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateMain {

	public static void main(String[] args) {
		System.out.println(new Date());
		System.out.println(new Date(0));
		System.out.println(new Date().getTime());
		System.out.println(System.currentTimeMillis());
		Calendar c = new GregorianCalendar();
		c.add(Calendar.DATE, 90);
		System.out.println(c);
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH) + 1);
		System.out.println(c.get(Calendar.DATE));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		System.out.println(sdf.format(c.getTime()));
		DecimalFormat df = new DecimalFormat("#,##0");
		System.out.println(df.format(100));
		System.out.println(df.format(1000000));
		NumberFormat nf1 = NumberFormat.getNumberInstance();
		System.out.println(nf1.format(1000));
		NumberFormat nf2 = NumberFormat.getCurrencyInstance();
		System.out.println(nf2.format(1000));
		NumberFormat nf3 = NumberFormat.getPercentInstance();
		System.out.println(nf3.format(0.12));
	}

}
