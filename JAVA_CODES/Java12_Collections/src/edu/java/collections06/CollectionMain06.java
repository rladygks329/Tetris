package edu.java.collections06;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// List<E>, Set<E> : 한 가지 타입의 데이터를 저장할 수 있는 Collection
// Map<K, V> : Key - Value 쌍으로 데이터를 저장하는 구조
// 1. Key는 중복되지 않는 값만 저장 가능
// 2. Value는 중복된 값도 저장 가능
// 3. 검색, 수정, 삭제할 때 Key 값을 사용함

// HashMap<K, V> : 검색을 빠르게 하기 위한 Hash 알고리즘이 적용된 Map
// TreeMap<K, V> : 정렬을 빠르게 하기 위한 Tree 알고리즘이 적용된 Map
public class CollectionMain06 {

  public static void main(String[] args) {
    Map<Integer, String> map = new TreeMap<>();

    // Map<K, V>에 데이터 저장 : put(key, value)
    map.put(16, "황의조");
    map.put(7, "손흥민");
    map.put(18, "이승우");
    System.out.println(map);

    // Map<K, V> 의 데이터 하나 검색 : get(key)
    // - 해당 Key 값의 value를 리턴
    System.out.println(map.get(7));
    System.out.println(map.get(16));
    System.out.println(map.get(18));
    System.out.println();

    // Map<K, V>에서 데이터를 수정 : put(key, value)
    map.put(7, "김민재");
    System.out.println(map.get(7));
    System.out.println();

    // Map<K, V) 에서 데이터를 삭제 : remove(key)
    map.remove(7);
    System.out.println(map);
    System.out.println();

    // Map<K, V>에서 Key들로만 이루어진 Set을 생성: KeySet()
    Set<Integer> keySet = map.keySet();
    System.out.println(keySet);

    for (Integer e : keySet) {
      System.out.println(map.get(e));
    }
  } // end main()

} // end CollectionMain06
