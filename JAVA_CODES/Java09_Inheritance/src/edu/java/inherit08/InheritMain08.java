package edu.java.inherit08;

public class InheritMain08 {

	public static void main(String[] args) {
		// Employee 클래스 타입의 배열 선언
		Employee[] emps = {
			new Employee("홍길동"), 
			new Manager("고길동", "과장")
		};
		
		emps[0].test();
		emps[1].test();
		System.out.println();
		
		for(Employee e : emps) {
			EmployeeUtil.printEmpInfo(e);
			System.out.println("-------------");
		}
	} // end main()

} // end InheritMain08









