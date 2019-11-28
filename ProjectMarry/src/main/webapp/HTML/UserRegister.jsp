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
 <table border=1>
  <tr>
   <td>姓名</td>
   <td><input type="text" id="name" name="Name"
    value="${param.Name}" /></td>
  </tr>

  <tr>
   <td>帳號</td>
   <td><input type="text" id="account" name="Account"
    value="${param.Account}" /></td>
  </tr>

  <tr>
   <td>密碼</td>
   <td><input type="text" id="pwd" name="Pwd"
    value="${param.Pwd}" /></td>
  </tr>
  
  <tr>
   <td>確認密碼</td>
   <td><input type="text" id="pwd2" name="Pwd2"
    value="${param.Pwd2}" /></td>
  </tr>

  <tr>
   <td>生日</td>
   <td><input type="text" id="birth" name="Birth"
    value="${param.Birth}" /></td>
  </tr>

  <tr>
   <td>性別</td>
   <td>
   <input type="radio" id="male" name="Gender" value="${param.Gender}" /><label for="male" >男性</label>
   <input type="radio" id="female" name="Gender" value="${param.Gender}" /><label for="female" >女性</label> 
   <input type="radio" id="other" name="Gender" value="${param.Gender}" /><label for="other" >其他</label>
   </td>
  </tr>

  <tr>
   <td>行動電話</td>
   <td><input type="text" id="mobile" name="Mobile"
    value="${param.Mobile}" /></td>
  </tr>

  <tr>
   <td>市話</td>
   <td><input type="text" id="tel" name="Tel"
    value="${param.Tel}" /></td>
  </tr>

  <tr>
   <td>身分證字號</td>
   <td><input type="text" id="uid" name="Uid"
    value="${param.Uid}" /></td>
  </tr>

  <tr>
   <td>電子郵件</td>
   <td><input type="text" id="mail" name="Mail"
    value="${param.Mail}" /></td>
  </tr>

  <tr>
   <td>住址</td>
   <td><input type="text" id="address" name="Address"
    value="${param.Address}" /></td>
  </tr>

 </table>

</body>
</html>