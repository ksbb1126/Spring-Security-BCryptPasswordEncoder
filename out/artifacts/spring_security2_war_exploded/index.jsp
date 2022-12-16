<%--
  Created by IntelliJ IDEA.
  User: subeen
  Date: 2022-12-15
  Time: 오후 5:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>로그인</title>
  </head>
  <body>
  <h1>로그인</h1>
    <form action="login" method="post">
      <label for="id">아이디</label>
      <input type="text" name="id" id="id" ><br>
      <label for="password">비밀번호</label>
      <input type="text" name="password" id="password" ><br>
      <input type="submit" value="로그인">
    </form>
    <a href="signUp">회원가입</a>
  </body>
</html>
