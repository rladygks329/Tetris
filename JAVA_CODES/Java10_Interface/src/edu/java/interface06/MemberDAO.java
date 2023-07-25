package edu.java.interface06;

// * 인터페이스 DAO 메소드 설계 방식
// - 함수의 리턴타입 : 돌려주는 데이터 형태에 따라 선언
// - 함수의 매개 변수: 전송되는 데이터 형태에 따라 선언
// - 함수의 이름 : 역할에 따라 이름 작성

public interface MemberDAO {
  // 회원 정보 등록
  public abstract int insert(MemberDTO dto);

  // 회원 정보 전체 검색
  public abstract MemberDTO[] select();

  // 회원 정보 인덱스 검색
  public abstract MemberDTO select(int index);

  // 회원 정보 인덱스 수정
  public abstract int update(int index, MemberDTO dto);
}
