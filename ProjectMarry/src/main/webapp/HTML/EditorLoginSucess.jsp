<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Refresh"
	content="0;URL=../ProjectMarry/HTML/backstagemain.jsp" />
<title>登入成功</title>
</head>
<body>
	<h2 id="status"></h2>

	<input type="button" onclick="listCookie()">


	<script>
		function listCookie() {
			document.writeln("<table>");
			document.writeln("<tr><th>Name<th>Value");
			cookieArray = document.cookie.split(";");
			for (var i = 0; i < cookieArray.length; i++) {
				thisCookie = cookieArray[i].split("=");
				cName = unescape(thisCookie[0]);
				cValue = unescape(thisCookie[1]);
				document.writeln("<tr><td>" + cName + "</td><td>" + cValue
						+ "</td>");
			}
			document.writeln("</table>");
		}

		cookieArray = document.cookie.split(";");
		console.log(cookieArray);
		if (cookieArray == "") {
			document.getElementById("status").innerText = "登出成功";
			
		} else {
			nameArrays = cookieArray[1].split("=");
			document.getElementById("status").innerText = "登入成功";
		
		}
	</script>

</body>
</html>