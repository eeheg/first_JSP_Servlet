package util;

import java.sql.Connection;
import java.sql.DriverManager;

/*
'DatabaseUtil'클래스는 'UserDAO'클래스에서 DB연결을 얻어오는데 사용된다.
이를 통해 'UserDAO'클래스에서 제공하는 DB 관련 메서드를 사용할 수 있게 된다.
 */
public class DatabaseUtil {
    /*
    DB에 연결된 'Connection' 객체를 반환하는 메서드 => DB에 로그인한 상태 자체를 반환함
    'static'으로 선언되었으므로 클래스 명을 통해 직접 호출할 수 있다.
     */
    public static Connection getConnection() {
        try {
            // DB연결을 위한 URL을 정의한다.
            // 'mysql'을 사용 / 'localhost:3306' DB서버 주소 및 포트 / 'TUTORIAL' DB이름
            String dbURL = "jdbc:mysql://localhost:3306/TUTORIAL";

            //DB에 로그인할 사용자 이름 정의
            String dbID = "root";

            //DB 로그인 비밀번호 정의
            String dbPassword = "root";

            //MySQL JDBC드라이버를 로드. JDBC드라이버는 DB와의 연결을 가능하게 해줌.
            Class.forName("com.mysql.jdbc.Driver");

            //정의한 정보를 사용하여 DB에 연결하고, 해당 연결을 나타내는 'Connection' 객체를 반환
            return DriverManager.getConnection(dbURL, dbID, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
