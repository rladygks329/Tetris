package edu.java.inner08;

public class Button {
	// 내부 인터페이스
	public interface OnClickListener {
		public abstract void onClick();
	}
	
	private OnClickListener listener;
	
	public void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	public void click() {
		listener.onClick();
	}

}
