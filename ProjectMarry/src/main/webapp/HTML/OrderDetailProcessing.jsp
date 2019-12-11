<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> -->
<link rel="stylesheet" href="<c:url value='/CSS/combine.css'/>">
<title>Document</title>
</head>

<body>
	<div class="wrap" id="bg">
		<!-- header -->
		<div class="wrap" id="head">
			<div class="wrap">
				<p class="tital">MARY ME | ���a�ﶵ</p>
			</div>
			<div>
				<p class="text">���a|�t��U�˦��U�B§�p���U�s���U��v</p>
			</div>
		</div>
		<!-- article -->
		<div class="wrap" id="cartShopList">
			<!-- top  -->
			<div class="wrap" id="chooseAll">
				<label for="selectAll"> �������</label>
				<input type="checkbox" id="selectAll"> 
			</div>
			<!-- content  -->
			<div class="wrapRow" id="content">

				<!-- left  -->
				<div class="wrapStart" id="detail_left">
					<div class="menu">
						<h2>MARY ME</h2>
						<a href="<c:url value='/HTML/OrderDetailUnpaid.jsp'/>">
							<p class="text">�ʶR�q��</p>
						</a>
						<p class="text">�h�ڥӽ�</p>
						<p class="text">�|���M��</p>
						<p class="text">�b���]�w</p>
						<div class="setting">
							<ul>
								<li>�򥻳]�w</li>
								<li>�����</li>
								<li>�`�Φa�}ï</li>
								<li>�q���]�w</li>
							</ul>
						</div>
					</div>

					<!-- ���j�ӫ~��T�خ� -->
				</div>
				<!-- right  -->
				<div class="wrapStart" id="detail_right">

					<div class="wrapList"></div>
					<div class="wrapList">
						<p class="tital">�ʶR�q��</p>
						<div class="tablist">
							<ul>
								<li><a href="<c:url value='/HTML/OrderDetailUnpaid.jsp'/>">�|���I��</a></li>
								<li><a href="<c:url value='/HTML/OrderDetailProcessing.jsp'/>" class="active"><c:set var="status" value="�B�z��"/>�B�z��</a></li>
								<li><a href="<c:url value='/HTML/OrderDetailCompleted.jsp'/>">�w����</a></li>
								<li><a href="<c:url value='/HTML/OrderDetailCancelled.jsp'/>">�w����</a></li>
							</ul>
						</div>
						<div class="empty-list">
							<div class="image">
								<img src="<c:url value='/img/order_v2.png'/>" alt="">
							</div>
							<div class="text">�A�S��${status}���q��</div>
						</div>
					</div>
				</div>


			</div>


		</div>

	</div>
	<!-- foot -->
	<div class="wrap" id="footBG">
		<div class="wrap">MARY ME |�����|���� ,, �u�O�ܦ��A���w���ˤl</div>
		<div>���a|�t��U�˦��U�B§�p���U�s���U��v</div>
	</div>


	</div>




	<script>
		
	</script>

</body>

</html>