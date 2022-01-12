<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>process failed</title>
</head>
<body>
	<h1>OMG(오물개)... 뭔가 단단히 잘못됐군!</h1>
	<button onclick="history.back()">뒤로가기</button>
	<hr>
	<a href="http://localhost:8080/main">main으로</a>
	<a href="http://localhost:8080/userinfo?user_id=1">회원정보</a><br>
	<div>
	${msg}
	</div>
</body>
</html>