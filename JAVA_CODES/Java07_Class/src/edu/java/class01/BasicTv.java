package edu.java.class01;

// 클래스 (Class)
// - 만들고자 하는 대상의 상태(속성) 정보들을 "멤버 변수 (필드)"로 선언하고,
// 대상이 가져야할 기능들을 "메소드"로 정의하는,
// 새로이 만드는 "데이터 타입"

public class BasicTv {
  // Tv가 가져야할 상태(속성, 성질) => 멤버 변수(필드 프로퍼티)
  boolean powerOn; // TV 전원상태 (true: on, false: off)
  int channel = 1; // TV 의채널 정보. 1로 초기화
  int volume; // TV 소리 정보. 0으로 초기화

  // TV가 가져야할 기능 => 메소드

  // 전원(powerOn) on/off 기능

  public void turnOnOff() {
    // powerOn = !powerOn;
    // String message = powerOn) ? 켜졌습니다. : 꺼졌습니다.
    // Sysout("TV가" + message);

    if (powerOn == false) {
      powerOn = true;
      System.out.println("TV가 켜졌습니다.");
    } else {
      powerOn = false;
      System.out.println("TV가 꺼졌습니다.");
    }
  } // end turnOnOff


  public void channelUp() {
    // 채널 증가 기능 메소드()
    // 1 2 3 4 5.. 1 2 3...이런식으로 최댓값이 5까지임
    channel++;
    if (channel == 6) {
      channel = 1;
    }
    System.out.println("channel이 " + channel + "로 변경되었습니다.");
  } // end channelUp

  // 소리 증가 기능 메소드(소리 최대 4)
  public void volumeUp() {
    if (volume < 4) {
      volume++;
    }
    System.out.println("volume up: " + volume);
  }

  // 소리 감소 기능 메소드(소리 최소 0)
  public void volumeDown() {
    if (volume > 0) {
      volume--;
    }
    System.out.println("volume up: " + volume);

  }

  public void displayInfo() {
    System.out.println("---TV 현재 상태 ---");
    System.out.println("전원: " + powerOn);
    System.out.println("채널: " + channel);
    System.out.println("볼륨: " + volume);
  } // end displayInfo

} // end BasicTV
