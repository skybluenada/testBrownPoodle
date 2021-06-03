<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Id Find</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		
			$(document).ready(function(){
				
				$("#mconfirm").click(function(){
					
					let url = "idAuthEmailCheck.bp";
					let m_nameVal = $("#m_name").val();
					let m_emailVal = $("#m_email").val(); 
					
					$.get(url,{"m_name":m_nameVal,"m_email":m_emailVal},function(data){
						var msg = $(data).find("result").text();
						alert(msg);
					});
				});
				
				$("#idbtn").click(function(){
					$('#findId').attr({
						'action':'idAuthEmailIdFind.bp',
						'method':'POST',
						'enctype':'application/x-www-form-urlencoded'
					}).submit();
				});
			});
		</script>
	</head>
	<body>
	<h3 align="center">아이디 찾기</h3>
	<hr>
	<% request.setCharacterEncoding("UTF-8"); %>
	<%
		Object obj = request.getAttribute("aList");
		// if (obj == null) return;
		String m_name = "";
		String m_email = "";
		String id_auth_num = "";
		if (obj !=null){
			ArrayList<String> aList = (ArrayList)obj;
			System.out.println("aList.size() >>> : " + aList.size());
			m_name = aList.get(0);
			m_email = aList.get(1);
			id_auth_num = aList.get(2);
		}
	%>
	<h4 align="center">본인확인 이메일 주소와  입력한 이메일 주소가 같아야, 인증번호를 받을 수 있습니다.</h4>
	
	<form name="findId" id="findId">
		<div align="center">
		<input type="text" name="m_name" id="m_name" value='<%= m_name%>' placeholder="이름" style="width:200px; height: 25px;">
		<br><br><input type="text" name="m_email" id="m_email" value='<%= m_email%>' placeholder="이메일 주소" style="width:200px; height: 25px;">
		<br><br><input type="button" id="mconfirm" value="인증번호받기" style="width: 200px; height: 25px;">
		<br><br><input type="text" name="id_auth_num" id="id_auth_num" value='<%= id_auth_num%>' placeholder="인증번호 8자리 입력" style="width:200px; height: 25px;" >
		</div>
		<div align="center">
		<br>
		<input type="button" id="idbtn" value="다음" style="width: 200px; height: 25px">
		<br><font size="1">인증번호가 오지 않나요</font>
		<img src="/brownPoodle/webapp/img/login/qicon.png" width="20" height="20" title="발송해드린 메일이 스팸 메일로 분류된 것은 아닌지 확인해 주세요. 스팸 메일함에도 메일이 없다면, 다시 한 번 '인증번호 받기'를 눌러주세요.">
		</div>
	</form>
	</body>
</html>