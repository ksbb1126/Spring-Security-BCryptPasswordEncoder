<%--
  Created by IntelliJ IDEA.
  User: subeen
  Date: 2022-12-15
  Time: 오후 7:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<form action="signUp" method="post">
  <label for="id">아이디</label>
  <input type="text" name="id" id="id" ><br>
  <label for="password">비밀번호</label>
  <input type="text" name="password" id="password" ><br>
  <input type="submit" value="회원가입">
</form>
<a href="/">메인으로</a>
</body>
</html>
