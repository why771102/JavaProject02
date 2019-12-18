<%@ page language="java" contentType="text/html; charset=UTF-8"
    %>
<!DOCTYPE html>
<html>
<head>
<title>場地 資料</title>
</head>
<body style="background-color:#fdf5e6">
<div align="center">
<h2>場地 資料</h2>
<jsp:useBean id="ven" scope="request" class="com.editor.JavaBean"/>
<form method="post" action="updatevenue">
<table border="1">
<tr><td>廠商編號<td><input name="vendorid" value="${ven.vendorid}">
<tr><td>場地編號<td><input name="productid" value="${ven.productid}">
<tr><td>地址<td><input name="location" value="${ven.location}">
<tr><td>廳<td><input name="hall" value="${ven.hall}">
<tr><td>桌數	<td><input name="tablecount" value="${ven.tablecount}">
<tr><td>室內室外<td><input name="inoutdoor"  value="${ven.inoutdoor}">
<tr><td>午價錢<td><input name="lunchprice"  value="${ven.lunchprice}">
<tr><td>晚價錢<td><input name="dinnerprice"  value="${ven.dinnerprice}">
<tr><td>場地描述<td><input name="venuedesc"  value="${ven.venuedesc}">


</table>
<input type="submit" value="修改"/>
</form>
</div>
</body>
</html>