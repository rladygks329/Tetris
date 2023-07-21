package edu.java.inherit04;

public class InheritMain04 {
  public static void main(String[] args) {
    Animal animal = new Animal("동물");
    animal.speak();

    System.out.println();
    Dog dog = new Dog("토토", "시츄");
    dog.speak();

    System.out.println();
    Cat cat = new Cat();
    cat.speak();

    Animal[] animals = new Animal[2];
    animals[0] = dog;
    animals[1] = cat;

    System.out.println();
    for (Animal i : animals) {
      i.speak();
    }

  } // end main()

}// end InheritMain04
