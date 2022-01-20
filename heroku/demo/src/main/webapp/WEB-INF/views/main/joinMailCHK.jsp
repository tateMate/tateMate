<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TATEMATE JOIN TEST</title>
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
	<h1>NEW JOIN LOGIC</h1>
	<hr>
	<form action="loadingPage" method="post">
		<label>이메일 : </label> <input id="user_email" type="email" name="user_email" onchange="chkid()" required="required">
		<input type="submit" value="입력" id="submitbtn">
	</form>
	<div id="rst"></div>
	<a href="https://tatemate-back.herokuapp.com/main">main으로</a>
	<a href="https://tatemate-back.herokuapp.com/login">login</a>
	<a href="https://tatemate-back.herokuapp.com/forgotPw">비밀번호 찾기</a>
	
	
	
	
	
	
<!-- 	*******스크립트******** -->
<script>
	function chkid(){
		$.ajax({
			url:"emailChk",
			type:"post",
			data:{user_email:user_email.value},
				dataType:"json",
			success:function(d){
				let userE = user_email.value;
				if(d) {
					rst.innerHTML="사용가능한 email입니다."
					submitbtn.disabled="";
					if(userE==""){
						rst.innerHTML="email을 입력해주세요."
						submitbtn.disabled="disabled";
					}
				}else {
					rst.innerHTML="<em>중복된 email입니다.</em>"
					submitbtn.disabled="disabled";
					document.getElementById('user_email').style.color="red";
				}
			}
		});
	}
</script>
</body>
</html>