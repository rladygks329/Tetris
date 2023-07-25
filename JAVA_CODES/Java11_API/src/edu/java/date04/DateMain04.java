package edu.java.date04;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateMain04 {

  public static void main(String[] args) {
    Calendar birth = new GregorianCalendar(1900, 0, 1);

    // Calendar 객체를 SimpleDateFormat을 이용하여 날짜를 표현
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    System.out.println(sdf.format(birth.getTime()));

  } // end Main()

} // end DateMain04
