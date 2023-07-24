package edu.java.inherit08;

public class EmployeeUtil {
	// Employee 객체를 전송할 예정
	// Employee 객체일 수 있고, Manager 객체일 수도 있다.
	// 이런 상황이 가능한 이유는 Employee와 Manager가 부모 자식 관계이기 때문이다.
	// 따라서, 두 가지 타입의 인스턴스를 처리하기 위해
	// 조건문과 instanceof를 이용하여 인스턴스 타입에 따라 다르게 처리해야 한다.
	
	public static void printEmpInfo(Employee emp) {
		if(emp instanceof Manager) {
			Manager m = (Manager) emp; // 강제 형 변환(casting)
			System.out.println("이름 : " + m.getName());
			System.out.println("직책 : " + m.getType());
		} else if(emp instanceof Employee) {
			System.out.println("이름 : " + emp.getName());
		} else {
			System.out.println("직원이 아닙니다.");
		}
	}
	
}




