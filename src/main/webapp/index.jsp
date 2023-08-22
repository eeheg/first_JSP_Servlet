<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>우리의 첫 번째 페이지</title>
</head>
<body>
    Hello World!

    <!-- 'action' : 양식이 제출되면 데이터를 'post' 할 경로를 지정 => 'userJoinAction.jsp' -->
    <form action="./userJoinAction.jsp" method="post">

        <!-- input 필드의 'name' 속성에 설정된 값들은 사용자가 입력한 데이터를 'userJoinAction.jsp'로 전달한다.
         'userJoinAction.jsp'에서는 이 데이터를 읽어와서
         'UserDAO'클래스의 'join'메서드를 호출하여 데이터베이스에 저장할 수 있다.-->

        <!-- 사용자가 input에 입력한 값이 userID, userPassword 라는 이름으로 서버에 전송됨 -->
        <input type="text" name="userID">
        <input type="password" name="userPassword">

        <!-- 사용자가 이 버튼을 클릭하면 양식의 내용이 서버로 전송된다. -->
        <input type="submit" value="회원가입">

    </form>
</body>
</html>