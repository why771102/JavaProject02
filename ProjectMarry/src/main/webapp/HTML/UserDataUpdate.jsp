<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員資料修改</title>
</head>
<body>
<h2>會員資料修改</h2>
<form method="POST" action="<c:url value='/UserUpdate'/>">
<input type="hidden" value="${User.account}" name="Account" />
<table border="1">
 <tr>
  <td>姓名</td>
  <td><input type="text" value="${User.name}" name="Name" /></td>
 </tr>
 
 <tr>
  <td>生日</td>
  <td><input type="text" value="${User.birth}" name="Birth" /></td>
 </tr>
 <tr>
  <td>行動電話</td>
  <td><input type="text" value="${User.mobile}" name="Mobile" /></td>
 </tr>
 <tr>
  <td>市話</td>
  <td><input type="text" value="${User.tel}" name="Tel" /></td>
 </tr>
 <tr>
  <td>電子郵件</td>
  <td><input type="text" value="${User.mail}" name="Mail" /></td>
 </tr>
 <tr>
  <td>住址</td>
  <td><input type="text" value="${User.address}" name="Address" /></td>
 </tr>
</table>
 <input type="submit" value="確定修改資料">
</form>
<a href="/ProjectMarry/HTML/index.html"><input type="button"  value="返回首頁" id="Index"/></a>

</body>
</html>