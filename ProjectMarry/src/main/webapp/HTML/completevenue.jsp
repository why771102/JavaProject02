<%@ page language="java" contentType="text/html; charset=UTF-8"
    %>
<!DOCTYPE html>
<html>
<head>
<title>員工 資料</title>
</head>
<body style="background-color:#fdf5e6">
<div align="center">
<h2>員工 資料</h2>
<jsp:useBean id="ven" scope="request" class="com.editor.JavaBean"/>
<table border="1">
<tr><td>場地編號<td>${ven.vendorid} 
<tr><td>廠商編號<td>${ven.productid}
<tr><td>地址<td>${ven.location} 
<tr><td>廳<td>${ven.hall} 
<tr><td>桌數	<td>${ven.tablecount} 
<tr><td>室內室外	<td>${ven.inoutdoor} 
<tr><td>午價錢	<td>${ven.lunchprice} 
<tr><td>晚價錢	<td>${ven.dinnerprice} 
<tr><td>場地描述	<td>${ven.venuedesc} 
</table>
<h2>修改完成</h2>
<form method="post" action="getallvenue">

<input type="submit" value="回查詢頁"/>
</form>
<form method="post" action="HTML/backstagemain.jsp">

<input type="submit" value="回首頁"/>
</form>
</div>
</body>
</html>