package db;
/* MySQL 연동해보기 */

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

class DBTest{
	public static void main(String[] args){
		
		Connection con=null;
		PreparedStatement pstmt=null;
		String mysqlDriver="com.mysql.cj.jdbc.Driver";
		String oracleDriver="oracle.jdbc.driver.OracleDriver";
		
		String mysqlUrl="jdbc:mysql://localhost:3306/dev";
		String mysqlId="root";
		String mysqlPass="1234";
		
		String oracleUrl="jdbc:oracle:thin:@localhost:1521/xe";
		String oracleId="java";
		String oraclePass="1234";
		
		// 제어하기를 원하는 드라이버 먼저 로드(method 영역)
		// Class.forName("원하는 드라이버 클래스 명시");
		try{
			// 1단계) 드라이버 로드
			Class.forName(oracleDriver);
			System.out.println("드라이버 로드 성공");
			
			// 2단계) 접속
			String url=oracleUrl;
			String id=oracleId;
			String pass=oraclePass;
			// Connection이란? 접속 성공 후, 그 접속 정보를 가진 인터페이스
			// 이 객체가 null이면 접속 실패...
			con = DriverManager.getConnection(url, id, pass);
			if(con==null){
				System.out.println("접속 실패");
			}else if (con!=null){
				System.out.println("접속 성공");
				
				// 접속이 성공된 이후, 원격지의 db서버에 SQL문을 네트워크를 통해 전송
				/* String sql="insert into member3(uid, pwd, email) values ('Scott','3333','sss@daum.net')"; */
				String sql="insert into member3(member3_id, id, pwd, email)";
				sql = sql+" values(seq_member3.nextval, 'James', '2222', 'jjj@gamil.com')";
				// Java DataBase Connectivity = 자바의 데이터베이스 연동 기술 및 패키지 (java.sql 패키지에서 지원..)
				// JDBC에서 쿼리문 수행을 담당하는 '인터페이스'는 PreparedStatement
				// 인터페이스이기 때문에 new할 수 없고, 접속이 성공된 이후에 쿼리문 수행이 가능하므로, pstmt 객체의 인스턴스는 Connection 인터페이스로부터 얻어야 함
				pstmt = con.prepareStatement(sql); 
				// 준비된 문장으로 쿼리 실행
				
				int result = pstmt.executeUpdate(); // DML 수행 시 이 메서드 사용해야 함
				if (result>0) {
					System.out.println("등록 성공");
				}	else {
					System.out.println("등록 실패");
				}
					
			}
		} catch(ClassNotFoundException e){
			System.out.println("드라이버를 찾을 수 없습니다. 확인해주세요.");			
		} catch(SQLException e){
			e.printStackTrace(); // Error 순서를 Stack 순서로 출력해줘 ;; 개발자를 위한 메시지			
		} finally {
			/* db와 스트림과 같은 자원을 차지하는 기술은 사용 후 반드시 닫아야 함, 닫지 않을 시 메모리를 계속 확보하여 문제 발생
				 만일 웹 서버에 닫지 않은 코드가 올라간다면.. 동시 자원이 다수 생성되어 웹 서버 다운이 발생함
			*/
			if(pstmt!=null){
				try{
					pstmt.close();	
				}catch(SQLException e){
					e.printStackTrace(); // 에러의 원인을 스택 구조로 출력하라 (개발자를 위해)
				}
			}
			if(con !=null){
				try{
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}

		}
	}
}