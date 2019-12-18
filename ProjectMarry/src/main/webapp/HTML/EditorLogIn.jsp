<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>會員登入</title>
</head>
<body>
	<form method="POST" action="<c:url value='/EditorLogin'/>">
		<h2>員工登入</h2>
		<table border=1>

			<tr>
				<td>帳號</td>
				<td><input type="text" id="account" name="Account"
					value="${param.Account}" />${errorMsgMap.noAccount}</td>
			</tr>
			<tr>
				<td>密碼</td>
				<td><input type="password" id="pwd" name="Pwd"
					value="${param.Pwd}" />${errorMsgMap.PwdNoMatch}</td>
			</tr>
		</table>
		<input type="submit" value="登入"> 
	</form>
		<form method="POST" action="<c:url value='HTML/backstagelogin.html'/>">
			<input type="submit" value="取消">
			</form>
</body>
</html>