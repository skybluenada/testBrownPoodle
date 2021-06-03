<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>LOGIN</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#btn").click(function(){
					$('#loginForm').attr({
						'action':'loginTry.bp',
						'method':'POST',
						'enctype':'application/x-www-form-urlencoded'
					}).submit();
				});
			});
		</script>
	</head>
	<body>
		<h5 align="center">Login</h5>
		<hr>
		<form name="loginForm" id="loginForm">
			<table align="center">
				<tr align="center">
					<td></td>
					<td>
						<input type="text" name="m_id" id="m_id" placeholder="아이디" style="width: 200px; height: 25px;">
					</td>
					<td></td>
				</tr>
				<tr></tr>
				<tr align="center">
					<td></td>
					<td>
						<input type="password" name="m_pw" id="m_pw" placeholder="비밀번호" style="width: 200px; height: 25px;">
					</td>
					<td></td>
				</tr>
				<tr></tr>
				<tr align="center">
					<td></td>
					<td>
						<input type="button" id="btn" style="width: 200px; height: 25px;" value="로그인">
					</td>
					<td></td>
				</tr>
				<tr align="center">
					<td colspan="3">
						<a href="idFind.bp"><font size="1">아이디찾기</font></a> |
						<a href=""><font size="1">비밀번호찾기</font></a>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>