<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>send mail</title>
</head>
<body>
	<h1></h1>
	<hr>
	<div>
	${email} 로 비밀번호를 변경할 수 있는 링크를 보냈엉! 확인해라 엉엉!
	<br><mark>${title}</mark>
	</div>
	<a href="http://localhost:8080/main">main으로</a>
	<img
     src="http://newsimg.hankookilbo.com/2019/02/07/201902071649095744_5.jpg"
    >
</body>
</html>