package edu.java.interface06;

// DAO같은 경우는 하나만 생성할 수 있도록 하자 - SingleTon
public class MemberDAOImple implements MemberDAO {

  // 싱글톤 디자인 패턴 적용 시작
  // private static 자기 자신
  private static MemberDAOImple instance = null;

  // 2. private 생성자
  private MemberDAOImple() {}

  // 3.private staic 메소드 - 인스턴스를 리턴하는 메소드 구현
  public static MemberDAOImple getInstance() {
    if (instance == null) {
      instance = new MemberDAOImple();
    }
    return instance;
  }

  private final int MAX = 100; // 최대 회원수
  private MemberDTO[] list = new MemberDTO[MAX];
  private int size; // 배열에 저장될 데이터 개수

  public int getSize() {
    return size;
  }

  @Override
  public int insert(MemberDTO dto) {
    list[size++] = dto;
    return 1; // 0: fail, 1: success
  }

  @Override
  public MemberDTO[] select() {
    return list;
  }

  @Override
  public MemberDTO select(int index) {
    return list[index];
  }

  @Override
  public int update(int index, MemberDTO dto) {
    list[index].setEmail(dto.getEmail());
    list[index].setPw(dto.getPw());
    return 1; // 0: fail, 1: success
  }

}
