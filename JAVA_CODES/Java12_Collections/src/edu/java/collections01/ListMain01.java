package edu.java.collections01;

import java.util.ArrayList;
import java.util.List;

// * List<> 클래스
// - 배열과 같은 역할을 Generic 클래스로 생성한 형태
// - 배열은 저장되는 크기를 지정해야하지만, list는 저장의 한계가 없음
// - 추가하는 만큼 저장 공간을 늘려줌
// - 주요 메소드 :
// add() : 원소 추가
// get() : 원소 읽기
// set() : 원소 변경
// remove() : 원소 삭제
public class ListMain01 {

  public static void main(String[] args) {
    int[] list1 = new int[3];
    list1[0] = 1;
    System.out.println(list1.length);

    // 배열의 길이는 데이터가 저장된 개수와 상관없이 고정
    // 배열에 저장된 데이터의 개수를 확인하기 어려움
    List<Integer> list2 = new ArrayList<>();
    System.out.println("리스트 크기 : " + list2.size());

    // ArrayList에 원소 (element)추가 : add () 메소드 사용
    list2.add(0); // index = 0
    list2.add(1); // index = 1
    list2.add(2); // index = 2
    list2.add(3); // index = 3
    System.out.println("리스트 크기 : " + list2.size());

    // ArrayList에 있는 원소 참조(읽기) : get(index)
    System.out.println(list2.get(0));
    System.out.println(list2.get(2));
    System.out.println();

    // for - each()
    // for(원소타입 변수이름 : 배열 또는 컬렉션) {...}
    for (Integer n : list2) {
      System.out.println(n);
    }
    System.out.println();

    // ArrayList에서 특정 인덱스의 원소를 변경 : set(index, value)
    list2.set(0, 1);
    list2.set(2, 1234);
    for (Integer n : list2) {
      System.out.println(n);
    }
    System.out.println();

    // ArrayList에서 특정 인덱스의 원소를 삭제 : remove(index)
    list2.remove(1);
    System.out.println("리스트의 크기 : " + list2.size());
    for (int i = 0; i < list2.size(); i++) {
      System.out.println("index: " + i + ", value: " + list2.get(i));
    }

  } // end main()

} // end ListMain01
