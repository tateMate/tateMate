<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forgot password</title>
</head>
<body>
	<h1>비밀번호를 있어버렸엉? 그럼 이메일을 입려해라 엉엉!</h1>
	<hr>
	<form action="forgotPw" method="post">
		<label>이메일 : </label>
		<input type="text" name="user_email">
		<input type="submit" value="입력">
	</form>
	<a href="https://tatemate-back.herokuapp.com/main">main으로</a>
	<hr>
	<img
     src="https://post-phinf.pstatic.net/MjAxOTExMDRfOCAg/MDAxNTcyODU1MDQ5NDA4.FCA8G3r-rbxsidLKqxBX6yfk4DuUc1zLXhdCni9BVB0g.fjQTknYM-SXz03aSAQIopvVKV515Qx1LYBn370JkRV0g.JPEG/%EB%8B%A4%EC%9A%B4%EB%A1%9C%EB%93%9C_%281%29.jpg?type=w1200"
    >
</body>
</html>