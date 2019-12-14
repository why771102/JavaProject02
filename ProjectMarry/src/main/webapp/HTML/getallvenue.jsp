<%@ page language="java" contentType="text/html;charset=UTF-8"
    import="java.util.*,com.editor.JavaBean"%>
  
<!DOCTYPE html>
<html>
<head>
<title>場地 資料</title>
</head>
<body style="background-color:#fdf5e6">
<div align="center">
<h2>場地 資料</h2>
<jsp:useBean id="ven" scope="request" class="com.editor.JavaBean"/>
<table border="1">
<tr style="background-color:#a8fefa">
<th>廠商編號<th>場地編號<th>地址<th>廳<th>桌數<th>室內室外<th>午價錢<th>晚價錢			
<% List<JavaBean> vens=(ArrayList<JavaBean>)request.getAttribute("vens") ;
	for(int i=0;i<vens.size();i++){%>
	<tr><td><%=(vens.get(i)).getVendorid() %>
	<td><%=(vens.get(i)).getProductid() %>
	<td><%=(vens.get(i)).getVenueaddress()%>
	<td><%=(vens.get(i)).getHall()%>
	<td><%=(vens.get(i)).getTables()%>
	<td><%=(vens.get(i)).getInoutdoor()%>
	<td><%=(vens.get(i)).getLunchprice()%>
	<td><%=(vens.get(i)).getDinnerprice()%>
	
	<td>
	<form method="post" action="beforeupdate">
	<input type="hidden" value="<%=(vens.get(i)).getProductid() %>" name="productid">
	<input type="submit" value="修改">
	</form>
	<%}%> 
</table>
<h3>共<%= vens.size() %>筆場地資料 </h3>
</div>
</body>
</html>