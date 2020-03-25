package ex21jdbc.statement;

import java.sql.SQLException;

public class SelectSQL extends ConnectDB{
	
	//생성자 메소드
	public SelectSQL() {
		super();
	}
	
	@Override
	public void execute() {
		try {
			stmt = con.createStatement();
			
			String query = " SELECT id, pass, name, "
					+ " to_char(regidate, ' yyyy.mm.dd hh24:mi ') format1 "
					+ " regidate "
					+ " FROM member "
					+ " ORDER BY regidate DESC ";
			
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString("pass");
				String name = rs.getString("name");
				/*
				 날짜를 to_char()함수를 이용해서 문자형으로 변환하였으므로 추출 시 
				 getDate()를 사용할 수 없다. 그리고 컬럼명 대신 별칭을 사용한다.
				 */
				String regidate = rs.getString("format1");
				
				/*
				 오라클의 date형을 getString()으로 추출하면 2020-03-25 11:59:09 형태로 시간까지
				 출력할 수 있다.
				 만약 날짜 문자열을 잘라서 출력하고 싶을떄는 substring()을 활용한다.
				 */
				//String regidate2 = rs.getString("regidate");
				String regidate2 = rs.getString("regidate").substring(0,13);
				//날짜와 시간까지만 잘라서 출력(분 이후 출력되지 않음)
				
				System.out.printf("%-10s %-10s %-13s %-20s\n", 
						id, pw, name, regidate, regidate2);
			}
		}
		catch(SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		
		}
		finally {
			close(); //DB자원반납
		}
	}

	public static void main(String[] args) {
		SelectSQL selectSQL = new SelectSQL();
		selectSQL.execute();

		
	}

}
