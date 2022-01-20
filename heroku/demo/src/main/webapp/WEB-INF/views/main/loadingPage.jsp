<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOADING TEST</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
body {
	display: flex;
	flex-direction: column;
	align-items: center;
}
hr{
width: 100%;
}
</style>
</head>
<body>
	<h1>EMAIL SENDING...</h1>
	<hr>
	<form action="joinmail" method="post">
		<label>${email} 로 메일을 전송중입니다. </label> 
		<input id="user_email" type="hidden" name="user_email" value="${email}">
		<input type="submit" style="display: none;" value="입력" id="submitbtn">
	</form>
	
	
	
	
	
	
<!-- 	*******스크립트******** -->
<script>
	$(document).ready(function() {
		$("#submitbtn").click();
	});
</script>
</body>
</html>