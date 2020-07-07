package ex21jdbc.shopping;

import java.util.Scanner;

import ex21jdbc.connect.IConnectImpl;

public class InsertShop extends IConnectImpl {

	public InsertShop() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		try {
			// 1. 쿼리문 준비 : 값의 세팅이 필요한 부분을 ?로 대체한다.
			String query = " INSERT INTO SH_GOODS VALUES (goods_seq.nextval, ?, ?, ?, ?) ";
			
			// 2.prepared객체 생성 : 생성 시 준비한 쿼리문을 인자로 전달한다.
			psmt = con.prepareStatement(query);
			
			// 3.DB에 입력할 값을 사용자로부터 입력받음.
			Scanner scan = new Scanner(System.in);
			System.out.print("상품명:");
			String NAME = scan.nextLine();
			System.out.print("상품가격:");
			String PRICE = scan.nextLine();
			System.out.print("상품코드:");
			int CODE = scan.nextInt();
			
			// 4. 인파라미터 설정하기 : ?의 순서대로 설정하고 DB이므로 인덱스는 1 부터 시작.
			psmt.setString(1, NAME);
			psmt.setString(2, PRICE);
			//psmt.setString(4, REGIDATE);
			psmt.setInt(4, CODE);
			
			//psmt.setString(4, "2018-11-20"); //날짜를 문자열로 입력하는 경우
			/*
			 현재날짜를 JAVA단에서 입력하는 경우 아래와 같은 변환과정을 거쳐야한다.
			 util 패키지로 시간을 가져온 후 sql패키지 형태로 변환한다.
			 이떄는 date형으로 입력되기때문에 setDate()메소드를 사용해서
			 인파라미터를 설정해야한다/.
			 */
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			psmt.setDate(3, sqlDate);
			
			// 5. 쿼리실행을 위해 prepared객체를 실행한다.
			int affected = psmt.executeUpdate();
			System.out.println(affected + "행이 입력되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) {
		new InsertShop().execute();
	}

}
