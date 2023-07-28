package edu.java.inner08;

class OkListener implements Button.OnClickListener {

  @Override
  public void onClick() {
    System.out.println("<<< 확인 >>>");
  }

} // end OkListener


class CancelListener implements Button.OnClickListener {

  @Override
  public void onClick() {
    System.out.println("<<< 취소 >>>");
  }

} // end CancelListener


public class InnerMain08 {

  public static void main(String[] args) {
    Button btnOk = new Button();
    Button.OnClickListener okListener = new OkListener();
    btnOk.setOnClickListener(okListener);
    btnOk.click();

    System.out.println();
    Button btnCancel = new Button();
    btnCancel.setOnClickListener(new CancelListener());
    btnCancel.click();

    System.out.println();
    Button btn = new Button();
    Button.OnClickListener l = new Button.OnClickListener() {
      @Override
      public void onClick() {
        System.out.println("테스트 클릭");
      }
    };
    btn.setOnClickListener(l);
    btn.click();

    btn.setOnClickListener(new Button.OnClickListener() {

      @Override
      public void onClick() {
        System.out.println("테스트 클릭2");
      }
    });
    btn.click();

  } // end main()
} // InnerMain08


