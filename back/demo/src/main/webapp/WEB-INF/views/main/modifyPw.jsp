<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify password</title>
</head>
<body>
	<h1>잘왔엉! 비밀번호를 바꿀 수 있는 기회를 줄게!</h1>
	<hr>
	<form action="modifyPw" method="post">
		<label>새 비밀번호 : </label>
		<input type="password" name="user_pw">
		<input type="hidden" name="user_id" value="${user.user_id}">
		<input type="hidden" name="user_email" value="${user.user_email}">
		<input type="submit">
	</form>
	<hr>
	<a href="http://localhost:8080/main">main으로</a>
	<img
     src="https://img1.daumcdn.net/thumb/C400x400.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/9Sgn/image/QC3Js8uHdDanEWAgTjO6o5zC0zA.jpeg"
    >
</body>
</html>