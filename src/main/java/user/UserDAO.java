package user;

import util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;

//실질적으로 데이터베이스와 접근하는 클래스
public class UserDAO {
    public int join(String userID, String userPassword) {

        //'USER'테이블에 사용자 ID와 사용자 비밀번호를 삽입하는 쿼리
        String SQL = "INSERT INTO USER VALUES (?, ?)";
        /*
         * '?'는 나중에 바인딩할 매개변수를 나타낸다.
         * 첫번째 물음표는 첫번째 컬럼에 삽입할 값, 두번째 물음표는 두번째 컬럼에 삽입할 값
         * 이러한 바인딩 매개변수는 .setString() 메서드를 사용하여 설정하며, 이후 실행할 때 실제값으로 대체됨.
         * => 이를 통해 SQL 쿼리가 완성된 후에도 보안과 SQL 인젝션 공격을 방지할 수 있다.
         */

        try {
            //데이터베이스 연결객체 conn
            Connection conn = DatabaseUtil.getConnection();

            //준비된 SQL문을 실행하기 위한 'PreparedStatement' 객체 생성
            //'prepareStatement()' : 주어진 SQL 쿼리를 실행준비상태로 만든다. 이렇게 하여 나중에 해당 쿼리를 실행할 수 있다.
            //'pstmt' : 준비된 쿼리를 실행하는데 사용되는 객체를 나타낸다.
            PreparedStatement pstmt = conn.prepareStatement(SQL);

            //첫번째 매개변수에 사용자ID를 바인딩
            pstmt.setString(1, userID);
            //두번째 매개변수에 사용자PW를 바인딩
            pstmt.setString(2, userPassword);

            //쿼리를 실행하고 업데이트된 레코드 수를 반환
            /*
            executeUpdate() 메서드는 INSERT, UPDATE, DELETE 등의 DML 쿼리를 실행하고 영향을 받은 레코드 수를 반환합니다.
            이 메서드를 호출하여 쿼리를 실행하면 데이터베이스에 새로운 레코드가 삽입되거나 기존 레코드가 업데이트/삭제됩니다.
             */
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
