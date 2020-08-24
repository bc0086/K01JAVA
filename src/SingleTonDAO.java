import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 	다음은 싱글턴패턴으로 구현한 DAO(Data Access Object) 클래스이다. 빈칸에 들어갈 코드를 기술하시오.
 */

public class SingleTonDAO {
	
	private static SingleTonDAO singleDAO = new SingleTonDAO();
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;

	private SingleTonDAO() {
		System.out.println("Oracle연결");
		DbConnect();
	}
	
	public static SingleTonDAO getInstance(){
		System.out.println("DAO객체반환");
		return singleDAO;
	}
	
	public void DbConnect() {
		try {	
			Class.forName("oracle.jdbc.OracleDriver");
			String id = "kosmo";
			String pw = "1234";
			con = DriverManager.getConnection("오라클드라이버:1521:orcl", id, pw);
			System.out.println("DB 연결성공^^*");
		}
		catch(Exception e) {
			System.out.println("DB 연결실패ㅜㅜ ;");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SingleTonDAO.getInstance();
	}
}

