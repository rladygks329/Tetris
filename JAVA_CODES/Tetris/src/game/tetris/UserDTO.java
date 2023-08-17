package game.tetris;

public class UserDTO {
  private int no;
  private String id;
  private String password;
  private String nickName;

  public UserDTO() {}

  public UserDTO(int no, String id, String password, String nickName) {
    this.no = no;
    this.id = id;
    this.password = password;
    this.nickName = nickName;
  }

  public final int getNo() {
    return no;
  }

  public final void setNo(int no) {
    this.no = no;
  }

  public final String getId() {
    return id;
  }

  public final void setId(String id) {
    this.id = id;
  }

  public final String getPassword() {
    return password;
  }

  public final void setPassword(String password) {
    this.password = password;
  }

  public final String getNickName() {
    return nickName;
  }

  public final void setNickName(String nickName) {
    this.nickName = nickName;
  }

  @Override
  public String toString() {
    return "UserDTO [no=" + no + ", id=" + id + ", password=" + password + ", nickName=" + nickName
        + "]";
  }
}
