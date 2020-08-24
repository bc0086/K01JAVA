package ex21jdbc.connect;

public interface IConnect {

	/*
	 멤버상수
	 	: INTERFACE에 선언된 변수는 무조건 public static final이 붙어 정적상수로 선언된다.
	 */
	String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	String ORACLE_URL = "jdbc:oracle:thin://@localhost:1521:orcl";
	
	void connect(String user, String pass); //DB연결
	void execute(); //쿼리실행
	void close(); //자원반납
	//사용자 입력을 위한 추상 메소드 선언
	String scanValue(String title);

}
