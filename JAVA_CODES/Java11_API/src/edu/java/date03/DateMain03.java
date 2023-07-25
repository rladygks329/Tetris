package edu.java.date03;

import java.util.Calendar;

public class DateMain03 {

  public static void main(String[] args) {
    // Calendar : 추상 클래스
    // - GregorianCalendar : Calendar의 자식 클래스
    Calendar cal = Calendar.getInstance();
    System.out.println(cal);

    // 날짜와 시간 정보 출력
    int year = cal.get(Calendar.YEAR);
    System.out.println("year: " + year);

    int month = cal.get(Calendar.MONTH) + 1;
    System.out.println("month: " + month); // Month : 0 ~ 11

    int day = cal.get(Calendar.DAY_OF_MONTH); // DAY : 1 ~ 31
    System.out.println("date: " + day);

    int hour = cal.get(Calendar.HOUR_OF_DAY);
    System.out.println("hour: " + hour);
    // Hour : 12시간 단위 //HOUR_OF_DAY: 24시간단위

    int minute = cal.get(Calendar.MINUTE);
    System.out.println("minute: " + minute);

    int second = cal.get(Calendar.SECOND);
    System.out.println("second: " + second);

    String dateString = String.format("%d/%d/%d %d:%d:%d", year, month, day, hour, minute, second);
    System.out.println(dateString);

    String str = String.format("%d-%02d-%02d", year, month, day);
    System.out.println(str);
  }// end Main()

} // end DateMain03
