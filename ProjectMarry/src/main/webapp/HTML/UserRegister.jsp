<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>註冊帳號</title>
<style>
	.notice{
		color:red;
		font-size:11px;
	}

</style>
</head>
<body>
<h2>註冊帳號</h2>
<form action="<c:url value='/UserRegister'/>" method="POST">
 <table>
  <tr>
   <td>姓名</td>
   <td><input type="text" id="name" name="Name"
    value="${param.Name}" /><span class="notice">${errorMsgMap.NameEmptyError}</span></td>
  </tr>

  <tr>
   <td>帳號</td>
   <td><input type="text" id="account" name="Account"
    value="${param.Account}" /><span class="notice">${errorMsgMap.AccountEmptyError}${errorMsgMap.AccountEmptyError2}</span></td>
  </tr>

  <tr>
   <td>密碼</td>
   <td><input type="password" id="pwd" name="Pwd"
    value="${param.Pwd}" /><span class="notice">${errorMsgMap.PwdEmptyError}${errorMsgMap.PwdNotSameError}</span></td>
  </tr>
  
  <tr>
   <td>確認密碼</td>
   <td><input type="password" id="pwd2" name="Pwd2"
    value="${param.Pwd2}" /></td>
  </tr>

  <tr>
   <td>生日</td>
   <td><input type="text" id="birth" name="Birth"
    value="${param.Birth}" /><span class="notice">${errorMsgMap.BirthEmptyError}</span></td>
  </tr>

  <tr>
   <td>性別</td>
   <td>
   <input type="radio" id="male" name="Gender" ${(param.Gender == 0) ? 'cheched' : ''} value="0" /><label for="male" >男性</label>
   <input type="radio" id="female" name="Gender" ${(param.Gender == 1) ? 'cheched' : ''} value="1" /><label for="female" >女性</label> 
   <input type="radio" id="other" name="Gender" ${(param.Gender == 2) ? 'cheched' : ''} value="2"/><label for="other" >其他</label>
   <span class="notice">${errorMsgMap.GenderEmptyError}</span>
   </td>
  </tr>

  <tr>
   <td>行動電話</td>
   <td><input type="text" id="mobile" name="Mobile"
    value="${param.Mobile}" /><span class="notice">${errorMsgMap.MobileEmptyError}</span></td>
  </tr>

  <tr>
   <td>市話</td>
   <td><input type="text" id="tel" name="Tel"
    value="${param.Tel}" /><span class="notice">${errorMsgMap.TelEmptyError}</span></td>
  </tr>

  <tr>
   <td>身分證字號</td>
   <td><input type="text" id="uid" name="Uid"
    value="${param.Uid}" /><span class="notice">${errorMsgMap.UIDEmptyError}${errorMsgMap.UIDEmptyError2}</span></td>
  </tr>

  <tr>
   <td>電子郵件</td>
   <td><input type="text" id="mail" name="Mail"
    value="${param.Mail}" /><span class="notice">${errorMsgMap.MailEmptyError}</span></td>
  </tr>

  <tr>
   <td>住址</td>
   <td><input type="text" id="address" name="Address"
    value="${param.Address}" /><span class="notice">${errorMsgMap.AddressEmptyError}</span></td>
  </tr>

 </table>
<input type="submit" value="確定送出"/><input type="reset" value="清除重填"/>
</form>
</body>
</html>