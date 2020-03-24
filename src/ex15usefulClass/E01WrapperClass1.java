package ex15usefulClass;

/*
 Wrapper클래스
 	: 기본자료형의 데이터를 인스턴스화 할때 사용하는 클래스
 	-오토박싱 : 기본자료형이 자동으로 참조형으로 변경되는것.
 		예] int => Integer
 	-오토언박싱 : 참조형이 기본자료형으로 자동 변경되는것.
 	※ 오토박싱, 언박싱은 JDK1.5이상에서 적용된다.
 */
public class E01WrapperClass1 {

	public static void main(String[] args) {

		//일반적인 정수의 연산
		int num1 = 10;
		int num2 = 20;
		int result = num1 + num2;
		System.out.println("result="+ result);
		
		//JDK1.4이전 버전에서의 코딩형태
		/*
		 기본자료형을 박싱 처리한 객체에 대한 산술연산.
		 언박싱하기 위해 intValue()와 같은 메소드를 통해 값을 꺼내온다.
		 */
		Integer n100bj = new Integer(10);
		Integer n200bj = new Integer(num2);
		int result2 = n100bj.intValue()	+ n200bj.intValue()	;
		System.out.println("result2="+ result2);
		
		Integer result0bj = new Integer(result2);
		System.out.println("결과값을 byte형 값으로 변경:"+result0bj.byteValue());
		System.out.println("결과값을 이진수로 변경:"+Integer.toBinaryString(result2));
		
		//JDK1.5이후 버전에서의 코딩형태
		Integer num0bj1 = 100;//오토박싱 처리
		Integer num0bj2 = 200;
		int num3 = num0bj1;//오토언박싱 처리
		int result3 = num0bj1 - num0bj2;
		System.out.println("오토언박싱 이후 연산결과:"+ result3);
		
		/*
		 Wrapper클래스를 사용하는 이점
		 	: wrapper클래스에 정의된 많은 메소드를 사용할 수 있다.
		 	int형의 최대, 최소값 혹은 진법 변환등의 기능을 가지고 있다.
		 */
		System.out.println("int형의 최대값:"+Integer.MAX_VALUE);
		System.out.println("int형의 최소값:"+Integer.MIN_VALUE);
		System.out.println("10을 2진수로:"+ Integer.toBinaryString(10));
		System.out.println("10을 16진수로:"+ Integer.toHexString(10));
		
		/*
		 자바의 모든 믈래스는 object클래스를 상속받는다.
		 그러므로 아래 메소드를 사용할 수 있다.
		 
		 toString() : 인스턴스변수를 출력시 참조값이 아니라 실제 저장된 값을 문자열 형태로 반환해주는 메소드
		 hashCode() : 객체를 구별하기 위해 참조값을 고유한 정수값으로 반환해주는 메소드
		 */
		Integer num0bj = new Integer(99);
		System.out.println("num0bj="+ num0bj);
		System.out.println("num0bj.toString()="+ num0bj.toString());
		System.out.println("num0bj.hashCode()="+ num0bj.hashCode());
		System.out.println(num0bj +1);//99+1=100
		System.out.println(num0bj.toString()+1);//"99"+1 => 991
	}

}
