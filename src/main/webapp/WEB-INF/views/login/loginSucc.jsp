<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login Success</title>
	</head>
	<body>
		<% request.setCharacterEncoding("UTF-8");%>
		<%
			HttpSession bpSession = request.getSession(false);
			String m_id = request.getParameter("m_id");

			if(bpSession != null){
				String sM_id = String.valueOf(bpSession.getAttribute("m_id"));
				System.out.println("sM_id >>> : " + sM_id);
				System.out.println("m_id >>> : " + m_id);
				
				if(m_id != null){
					
		%>
					<h5 align="center"><%=m_id %>님 로그인 중입니다</h5>
		<%
				}
			}
		%>
		
		<table>
			<tr align="center">
				<td><a href="logout.bp">로그아웃</a></td>
			</tr>
		</table>
		
		
	</body>
</html>