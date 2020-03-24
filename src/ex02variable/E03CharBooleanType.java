package ex02variable;

public class E03CharBooleanType {

	public static void main(String[] args) {

		
		/*
		 char형 : 하나의 문자를 저장할 수 있는 자료형으로 값을 저장할때
		 '(single quotation)으로 감싸서 표현한다.
		 만약 "(double quotation)으로 감싸면 문자열로 인식하므로
		 String형으로 선언해야한다.
		 */
		
		char ch1 = '가';
		//char chStr = '가나다라';[에러]문자열이므로 char 형변수에 대입불가
		String chStr = "가나다라";
		 System.out.println("ch1="+ch1);
		 System.out.println("chStr=+ chStr");
		
		 /*
		  아스키코드 : 1byte로 표현할 수 있는 문자(영문, 숫자)를 십진수코드로
		  정의한 것을 말한다.
		  Ex) A => 65로 표현
		      a => 97로 표현
		  유니코드 : 1byte로 표현이 안되는 문자(한글, 한자 등)는 2byte가
		  필요하고, 이를 16진수로 정의한 값을 말한다.
		  */
		 
		 char ch2 = 'A';
		 int num1 = 2;
		 int num2 = ch2 + num1;// 65 + 2 = 67
		 System.out.println("num2="+ num2);//67출력
		 System.out.println("(char)num2="+ (char)num2);//c출력
		 
		 char ch3 = (char)(ch2+num1);
		 System.out.println("ch3(문자출력)=>"+ ch3);
		 System.out.println("ch3(아스키코드출력)=>"+ (int)ch3);
		 
		 char ch4 = '1';//숫자가 아니라 문자 1이므로 49로 저장된다.
		 char ch4_1 = '1' + 1;
		 System.out.println("ch4=" + ch4
				 +", ch4_1="+ ch4_1
				 +", ch4_1="+ (int)ch4_1);
		 
		 /*
		  boolean형 : true 혹은 false 두가지의 갓만 가질 수 있는 데이터형으로
		  산술연산(+,-,*,/)이나 비교연산(<,>=등)은 사용이 불가능하다.
		  단, 논리연산은 가능하다.
		  */
		 
		 boolean bn1 = true;
		 boolean bn2 = false;
		 System.out.println("bn1="+ bn1 +", bn2="+ bn2);
		 
		 /*
		  && : 논리And연산으로 양쪽모두 참일때 참을 반환.
		  나머지는 거짓을 반환.
		  || : 논리Or연산으로 둘중 하나만 참이면 참을 반환.
		  둘다 거짓일 때 거짓을 반환.
		  */
		 
		 boolean bn3 = bn1 && bn2;
		 System.out.println("bn3(And)="+ bn3);
		 bn3 = bn1 || bn2;
		 System.out.println("bn3(Or)="+ bn3);
		 
		 bn3 = '가' > 30000;// 가 => 유니코드 44032이므로 true반환됨
		 System.out.println("bn3="+ bn3);
	}

}
