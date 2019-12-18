<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<%--     <jsp:include page="/fragment/" /> --%>
	<div class="wrap" id="bg">
		<!-- header -->
		<div class="wrap" id="head">
			<div class="wrap">
				<p class="tital">MARY ME | 場地選項</p>
			</div>
			<div>
				<p class="text">場地｜配件｜樣式｜婚禮小物｜新秘｜攝影</p>
			</div>
		</div>
		<!-- article -->
		<div class="wrap" id="cartShopList">
			<!-- top  -->
			<!-- content  -->
			<div class="wrapRow" id="content">

				<!-- left  -->
				<div class="wrapStart" id="detail_left">
					<div class="menu">
						<h2>MARY ME</h2>
						<a href="<c:url value='/HTML/OrderDetailUnpaid.jsp'/>">
							<p class="text">購買訂單</p>
						</a>
						<p class="text">退款申請</p>
						<a href="../UserDataQuery"><p class="text">會員專區</p></a>
						<p class="text">帳號設定</p>
						<div class="setting">
							<ul>
								<li>基本設定</li>
								<li>關於我</li>
								<li>常用地址簿</li>
								<li>通知設定</li>
							</ul>
						</div>
					</div>

					<!-- 分隔商品資訊框框 -->
				</div>
				<!-- right  -->
				<div class="wrapStart" id="detail_right">

					<div class="wrapList"></div>
					<div class="wrapList">
						<p class="tital">購買訂單</p>
						<div class="tablist">
							<ul>
								<li><a href="<c:url value='/HTML/OrderDetailUnpaid.jsp'/>" class="active"><c:set var="status" value="尚未付款"/>尚未付款</a></li>
								<li><a href="<c:url value='/HTML/OrderDetailProcessing.jsp'/>">處理中</a></li>
								<li><a href="<c:url value='/HTML/OrderDetailCompleted.jsp'/>">已完成</a></li>
								<li><a href="<c:url value='/HTML/OrderDetailCancelled.jsp'/>">已取消</a></li>
							</ul>
						</div>
						<div class="empty-list">
							<div class="image">
								<img src="<c:url value='/img/order_v2.png'/>" alt="">
							</div>
							<div class="text">你沒有${status}的訂單</div>
						</div>
					</div>
				</div>


			</div>


		</div>

	</div>
	<!-- foot -->
	<div class="wrap" id="footBG">
		<div class="wrap">MARY ME |錢不會消失 ,, 只是變成你喜歡的樣子</div>
		<div>場地|配件｜樣式｜婚禮小物｜新秘｜攝影</div>
	</div>


	</div>




	<script>
		
	</script>

</body>

</html>