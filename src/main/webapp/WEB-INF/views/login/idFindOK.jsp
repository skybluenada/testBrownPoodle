<%@page import="com.brownpoodle.member.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ID FIND OK</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				
				$("#loginBtn").click(function(){
					$("#m_id").attr({
						'action':'login.bp',
						'method':'GET',
						'enctype':'application/x-www-form-urlencoded'
					}).submit();
				});
				
				
			});
		</script>
	</head>
	<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	<%
		Object obj = request.getAttribute("iList");
		if(obj == null) return;
		
		ArrayList<MemberVO> iList = (ArrayList)obj;
		MemberVO mvo = iList.get(0);
		
		String m_id = mvo.getM_id();
		String m_insertdate = mvo.getM_insertdate();
	%>
	<h5 align="center">아이디 찾기</h5>
	<hr>
	<table align="center">
		<tr></tr>
		<tr align="center">
			<td>
				<input type="checkbox" name="m_id" id="m_id" value="<%= m_id%>"><font size="4"><%= m_id%></font><br><br>
			</td>
		</tr>
		<tr align="center">
			<td>
				최초가입일 : <%= m_insertdate %>
			</td>
		</tr>
		<tr align="center">
			<td>
				<input type="button" id="loginBtn" name="loginBtn" value="로그인" style="width: 100px; height: 30px;">
				<input type="button" id="pwFind" name="pwFind" value="비밀번호 찾기" style="width: 100px; height: 30px;">		
			</td>
		</tr>
	</table>
	</body>
</html>