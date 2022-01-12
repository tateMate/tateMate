<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>join</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
	#room_des{color:red;}
	div{
		display: inline-block;
	}
</style>
</head>
<body>
	<h1 style="display:inline-block;">회원가입</h1><button onclick="location.href='main'">메인으로</button>
	<hr>
<!-- 	user VO form  zone-->
	<form id="joinform" role="form" action="realjoin" method="post" enctype="multipart/form-data">
		<div><table>
			<tr><td>*email:</td><td><input type="hidden" name="user_email" value="${user.user_pw}">${user.user_pw}<input type="hidden" name="user_id" value="${user.user_id}"></td></tr>
			<tr><td>*password:</td><td><input required type="password" name=user_pw></td></tr>
			<tr><td>*nickname:</td><td><input required type="text" name=user_nickname></td></tr>
			<tr><td>*gender:</td><td><input required type="radio" value="0" name=user_gender>남
				<input type="radio" value="1" name=user_gender>여</td></tr>
			<tr><td>*nationality:</td><td><input required type="text" name=user_nationality></td></tr>
			<tr><td>*age:</td><td><input required type="number"	name=user_age></td></tr>
			<tr><td>*smoking:</td><td><input required type="radio" value="0" name=user_smoking>비흡연
				<input type="radio" value="1" name=user_smoking>흡연</td></tr>
			<tr><td>*vaccine:</td><td><input required type="number" name=user_vaccine></td></tr>
			<tr><td>*room:</td><td><input required type="radio" value="0" name=user_room onclick="nasi()">없음
				<input type="radio" value="1" name=user_room onclick="ari()">있음</td></tr>
		<!-- 		input location -->
			<tr><td>지역:</td><td>
			<select id="sido">
		      <option value="">선택</option>
		    </select>
		    <select id="sigugun">
		      <option value="">선택</option>
		    </select>
		    <select id="dong">
		      <option value="">선택</option>
		    </select>
		    <input type="hidden" id="location" name=user_location value=""></input>
			<tr><td></td><td id="room_des"></td></tr>
			<tr><td>*matching:</td><td><input required type="radio" value="0" name=user_matching>원하지 않음
				<input type="radio" value="1" name=user_matching>원함</td></tr>
			<tr><td>pet:</td><td><input type="radio" value="0" name=user_pet>없음
				<input type="radio" value="1" name=user_pet>있음</td></tr>
			<tr><td>대표사진</td><td colspan="2"><input type="file" name="file"></td></tr>
			<tr><td>소개글:</td><td><textarea rows="5" cols="30" name="user_intro" placeholder="본인을 간단하게 소개해 주세요."></textarea></tr>
			<tr><td>원하는 매칭상:</td><td><textarea rows="5" cols="30" name="user_ideal" placeholder="어떤 룸메이트를 원하시나요?"></textarea></tr>
			<tr><td>sns:</td><td><input type="text" name=user_sns></td></tr>
		</table></div>
<!-- 	user character vo form zone -->
		<div><table>
			<tr><td colspan='5'>청결도</td></tr><tr><td>
				<input type="radio" value="1" name="cleanliness">매우 더러움
			</td><td>
				<input type="radio" value="2" name="cleanliness">더러움
			</td><td>
				<input type="radio" value="3" name="cleanliness">보통
			</td><td>
				<input type="radio" value="4" name="cleanliness">깨끗함
			</td><td>
				<input type="radio" value="5" name="cleanliness">매우 깨끗함
			</td></tr>
			<tr><td colspan='5'>기상시간</td></tr><tr><td>
				<input type="radio" value="1" name="wakeup_time">매우 이름
			</td><td>
				<input type="radio" value="2" name="wakeup_time">이름
			</td><td>
				<input type="radio" value="3" name="wakeup_time">보통
			</td><td>
				<input type="radio" value="4" name="wakeup_time">늦음
			</td><td>
				<input type="radio" value="5" name="wakeup_time">매우 늦음
			</td></tr>
			<tr><td colspan='5'>취침시간</td></tr><tr><td>
			<input type="radio" value="1" name="sleep_time">매우 이름
			</td><td>
			<input type="radio" value="2" name="sleep_time">이름
			</td><td>
			<input type="radio" value="3" name="sleep_time">보통
			</td><td>
			<input type="radio" value="4" name="sleep_time">늦음
			</td><td>
			<input type="radio" value="5" name="sleep_time">매우 늦음
			</td></tr>
			<tr><td colspan='5'>요리빈도</td></tr><tr><td>
				<input type="radio" value="1" name="cooking_frequency">매우 드묾
			</td><td>
				<input type="radio" value="2" name="cooking_frequency">드묾
			</td><td>
				<input type="radio" value="3" name="cooking_frequency">보통
			</td><td>
				<input type="radio" value="4" name="cooking_frequency">빈번함
			</td><td>
				<input type="radio" value="5" name="cooking_frequency">매우 빈번함
			</td></tr>
			<tr><td colspan='5'>수다력</td></tr><tr><td>
				<input type="radio" value="1" name="chatter">매우 과묵함
			</td><td>
				<input type="radio" value="2" name="chatter">과묵함
			</td><td>
				<input type="radio" value="3" name="chatter">보통
			</td><td>
				<input type="radio" value="4" name="chatter">수다스러움
			</td><td>
				<input type="radio" value="5" name="chatter">매우 수다스러움
			</td></tr>
			<tr><td colspan='5'>잠버릇(코골이, 이갈이, 몽유병 등)</td></tr><tr><td>
				<input type="radio" value="1" name="snoring">매우 얌전함
			</td><td>
				<input type="radio" value="2" name="snoring">암전함
			</td><td>
				<input type="radio" value="3" name="snoring">보통
			</td><td>
				<input type="radio" value="4" name="snoring">심함
			</td><td>
				<input type="radio" value="5" name="snoring">매우 심함
			</td></tr>
			<tr><td>mbti</td><td colspan="4">
				<input type="text" name="mbti">
			</td></tr>
		</table></div>
		<br><input type="submit" id="submitbtn" value="가입"><input style="background-color:red;" type="reset" value="다시쓰자">
	</form>
	
	<br>
	<hr>
<script src="main/hangjungdong.js"></script>
<script>
	function ari(){
		room_des.innerHTML="어느 지역에 있는 방인가요?";
	}
	function nasi(){
		room_des.innerHTML="어느 지역을 원하시나요?";
	}


	// 행정동 api
	jQuery(document).ready(function(){
		//sido option 추가
		jQuery.each(hangjungdong.sido, function(idx, code){
			//append를 이용하여 option 하위에 붙여넣음
			jQuery('#sido').append(fn_option(code.sido, code.codeNm));
		});
		 
		//sido 변경시 시군구 option 추가
		jQuery('#sido').change(function(){
			jQuery('#sigugun').show();
			jQuery('#sigugun').empty();
			jQuery('#sigugun').append(fn_option('','선택')); //
			jQuery.each(hangjungdong.sigugun, function(idx, code){
				if(jQuery('#sido > option:selected').val() == code.sido)
				jQuery('#sigugun').append(fn_option(code.sigugun, code.codeNm));
			});
			 
			//세종특별자치시 예외처리
			//옵션값을 읽어 비교
			if(jQuery('#sido option:selected').val() == '36'){
				jQuery('#sigugun').hide();
				//index를 이용해서 selected 속성(attr)추가
				//기본 선택 옵션이 최상위로 index 0을 가짐
				jQuery('#sigugun option:eq(1)').attr('selected', 'selected');
				//trigger를 이용해 change 실행
				jQuery('#sigugun').trigger('change');
			}
		});
		
		//시군구 변경시 행정동 옵션추가
		jQuery('#sigugun').change(function(){
			//option 제거
			jQuery('#dong').empty();
			jQuery.each(hangjungdong.dong, function(idx, code){
				if(jQuery('#sido > option:selected').val() == code.sido && jQuery('#sigugun > option:selected').val() == code.sigugun)
				jQuery('#dong').append(fn_option(code.dong, code.codeNm));
			});
			//option의 맨앞에 추가
			jQuery('#dong').prepend(fn_option('','선택'));
			//option중 선택을 기본으로 선택
			jQuery('#dong option:eq("")').attr('selected', 'selected');
		});
		 
		jQuery('#dong').change(function(){
			//idx 받아오기
			const sidoIdx=hangjungdong.sido.findIndex(i=>i.sido==$("#sido").val());
			const sigugunIdx=hangjungdong.sigugun.findIndex(i=>i.sigugun==$("#sigugun").val()&&i.sido==$("#sido").val());
			const dongIdx=hangjungdong.dong.findIndex(i=>i.dong==$("#dong").val()&&i.sigugun==$("#sigugun").val()&&i.sido==$("#sido").val());
			//idx에 맞춰 이름 넣기
			const sidoName = hangjungdong.sido[sidoIdx].codeNm;//시
			const sigugunName = hangjungdong.sigugun[sigugunIdx].codeNm;//시군구
			const dongName = hangjungdong.dong[dongIdx].codeNm;//동
			document.getElementById("location").value=sidoName+" "+sigugunName+" "+dongName;
		});
	});
	 
	function fn_option(code, name){
	  return '<option value="' + code +'">' + name +'</option>';
	}

</script>
</body>
</html>