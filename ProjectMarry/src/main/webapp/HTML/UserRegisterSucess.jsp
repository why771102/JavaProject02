<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>註冊帳號</title>
</head>
<body>
<h2>註冊帳號</h2>
<form action="<c:url value='/UserRegister'/>" method="POST">
 <table border=1>
  <tr>
   <td>姓名</td>
   <td><input type="text" id="name" name="Name"
    value="${sessionScope.user.name}" /></td>
  </tr>

  <tr>
   <td>帳號</td>
   <td><input type="text" id="account" name="Account"
    value="${sessionScope.user.account}" /></td>
  </tr>
 
  <tr>
   <td>生日</td>
   <td><input type="text" id="birth" name="Birth"
    value="${sessionScope.user.birth}" /></td>
  </tr>

  <tr>
   <td>性別</td>
   <td>
   <input type="text" id="male" name="Gender" value="${sessionScope.user.gender}" />
   </td>
  </tr>

  <tr>
   <td>行動電話</td>
   <td><input type="text" id="mobile" name="Mobile"
    value="${sessionScope.user.mobile}" /></td>
  </tr>

  <tr>
   <td>市話</td>
   <td><input type="text" id="tel" name="Tel"
    value="${(sessionScope.user.tel == '') ? sessionScope.user.mobile : sessionScope.user.tel }" /></td>
  </tr>

  <tr>
   <td>身分證字號</td>
   <td><input type="text" id="uid" name="Uid"
    value="${sessionScope.user.uid}" /></td>
  </tr>

  <tr>
   <td>電子郵件</td>
   <td><input type="text" id="mail" name="Mail"
    value="${sessionScope.user.mail}" /></td>
  </tr>

  <tr>
   <td>住址</td>
   <td><input type="text" id="address" name="Address"
    value="${sessionScope.user.address}" /></td>
  </tr>

 </table>
<input type="submit" value="確定送出"/>
</form>
</body>
</html>