package ex21jdbc.shopping;

import java.sql.SQLException;

import ex21jdbc.connect.IConnectImpl;

public class UpdateShop extends IConnectImpl {
	
	//생성자에서 DB연결
	public UpdateShop() {
		super ("kosmo", "1234");
	}
	
	@Override
	public void execute()
	{
		String sql = " UPDATE SH_GOODS "
				+ "SET GOODS_NAME=?, GOODS_PRICE=?, P_CODE=?, G_IDX=? "
				+ "WHERE GOODS_NAME=? ";
		try {
			psmt = con.prepareStatement(sql);
			/*
			 사용자 입력시 exit를 입력할 떄까지는 계속 실행되는 형태로 구성 
			 */			
			while(true) {
				//인파라미터 설정 시 해당 인덱스만 맞으면 순서는 상관없다.
				psmt.setString(1, scanValue("수정할 상품명"));
				psmt.setString(2, scanValue("가격"));
				psmt.setString(3, scanValue("제품코드"));
				psmt.setString(3, scanValue("수정할 상품의 일련번호"));
				
				int affected = psmt.executeUpdate();
				System.out.println(affected + "행이 업데이트 되었습니다,");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}	

	public static void main(String[] args) {
		new UpdateShop().execute();
	}

}
