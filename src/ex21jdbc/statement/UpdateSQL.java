package ex21jdbc.statement;

import java.sql.SQLException;

public class UpdateSQL extends ConnectDB {

	public UpdateSQL(String user, String pass) {
		super(user, pass);
	}
/*
 ResultSet 클래스
 	: select문 실행시 쿼리의 실행결과가 ResultSet객체에 저장된다.
 	결과로 반환된 레코드의 처음부터 마지막까지 next()메소드를 통해 
 	확인후 반복하면서 추출하게 된다,
 	
 	-getXXX()계열의 메소드
 	오라클의 자료형이
 		NUMBER타입 : getInt()
 		char/varchar2타입 : getString()
 		date타입 : getDate()
 		메소드로 각 컬럼의 데이터를 추출한다.
 	- 인자는 select절의 컬럼순서대로 인덱스(1부터 시작)를 사용하거나
 	컬럼명을 사용할 수 있다.
 	-자료형에 상관없이 getString()으로 모든 데이터를 추출할 수 있다.
 */
	@Override
	public void execute() {

		try {
			stmt = con.createStatement();

			String sql = "UPDATE member" + "SET" + "		pass = '8888' ,  			"
					+ "     name = 'testUpdate',    " + " WHERE id= 'test1'  ";
			// 디버깅을 위한 쿼리문 출력
			System.out.println("sql=" + sql);

			int affected = stmt.executeUpdate(sql);
			System.out.println(affected + "행이 업데이트 됨");
		}

		catch (SQLException e) {
			System.out.println("쿼리오류");
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println("알수없는 예외발생");
			e.printStackTrace();
		}

		finally {
			close();
		}

	}

	public static void main(String[] args) 
	{
		new UpdateSQL("kosmo", "1234").execute();
	}

}
