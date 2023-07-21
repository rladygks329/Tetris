package edu.java.inherit06;

public class CarUtil {

  public CarUtil() {

  }

  public static void drive(Car[] cars) {
    for (int i = 0; i < cars.length; i++) {
      cars[i].display();
    }
  }

}
