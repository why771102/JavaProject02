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
    value="${param.Name}" />${errorMsgMap.NameEmptyError}</td>
  </tr>

  <tr>
   <td>帳號</td>
   <td><input type="text" id="account" name="Account"
    value="${param.Account}" />${errorMsgMap.AccountEmptyError}${errorMsgMap.AccountEmptyError2}</td>
  </tr>

  <tr>
   <td>密碼</td>
   <td><input type="password" id="pwd" name="Pwd"
    value="${param.Pwd}" />${errorMsgMap.PwdEmptyError}</td>
  </tr>
  
  <tr>
   <td>確認密碼</td>
   <td><input type="password" id="pwd2" name="Pwd2"
    value="${param.Pwd2}" /></td>
  </tr>

  <tr>
   <td>生日</td>
   <td><input type="text" id="birth" name="Birth"
    value="${param.Birth}" />${errorMsgMap.BirthEmptyError}</td>
  </tr>

  <tr>
   <td>性別</td>
   <td>
   <input type="radio" id="male" name="Gender" ${(param.Gender == 0) ? 'cheched' : ''} value="0" /><label for="male" >男性</label>
   <input type="radio" id="female" name="Gender" ${(param.Gender == 1) ? 'cheched' : ''} value="1" /><label for="female" >女性</label> 
   <input type="radio" id="other" name="Gender" ${(param.Gender == 2) ? 'cheched' : ''} value="2"/><label for="other" >其他</label>
   ${errorMsgMap.GenderEmptyError}
   </td>
  </tr>

  <tr>
   <td>行動電話</td>
   <td><input type="text" id="mobile" name="Mobile"
    value="${param.Mobile}" />${errorMsgMap.MobileEmptyError}</td>
  </tr>

  <tr>
   <td>市話</td>
   <td><input type="text" id="tel" name="Tel"
    value="${param.Tel}" />${errorMsgMap.TelEmptyError}</td>
  </tr>

  <tr>
   <td>身分證字號</td>
   <td><input type="text" id="uid" name="Uid"
    value="${param.Uid}" />${errorMsgMap.UIDEmptyError}${errorMsgMap.UIDEmptyError2}</td>
  </tr>

  <tr>
   <td>電子郵件</td>
   <td><input type="text" id="mail" name="Mail"
    value="${param.Mail}" />${errorMsgMap.MailEmptyError}</td>
  </tr>

  <tr>
   <td>住址</td>
   <td><input type="text" id="address" name="Address"
    value="${param.Address}" />${errorMsgMap.AddressEmptyError}</td>
  </tr>

 </table>
<input type="submit" value="確定送出"/><input type="reset" value="清除重填"/>
</form>
</body>
</html>