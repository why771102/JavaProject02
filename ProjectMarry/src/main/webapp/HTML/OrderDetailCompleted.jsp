<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
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
				<p class="tital">MARY ME | 場地選項</p>
			</div>
			<div>
				<p class="text">場地|配件｜樣式｜婚禮小物｜新秘｜攝影</p>
			</div>
		</div>
		<!-- article -->
		<div class="wrap" id="cartShopList">
			<!-- top  -->
			<div class="wrap" id="chooseAll">
				<label for="selectAll"> 全部選取</label>
				<input type="checkbox" id="selectAll"> 
			</div>
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
						<p class="text">會員專區</p>
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
								<li><a href="<c:url value='/HTML/OrderDetailUnpaid.jsp'/>">尚未付款</a></li>
								<li><a href="<c:url value='/HTML/OrderDetailProcessing.jsp'/>">處理中</a></li>
								<li><a href="<c:url value='/HTML/OrderDetailCompleted.jsp'/>" class="active"><c:set var="status" value="已完成"/>已完成</a></li>
								<li><a href="<c:url value='/HTML/OrderDetailCancelled.jsp'/>">已取消</a></li>
							</ul>
						</div>

						<!-- <div class="empty-list">
                            <div class="image">
                                <img src="img/order_v2.png" alt="">
                            </div>
                            <div class="text"></div>
                        </div> -->
						<div class="wrapList order_list">
							<div class="wrapRowStart order_title">
								<div id="date"><c:out value="${OrderDetails.OrderDate}" default="2018-05-28"/></div>
								<div id="shop">
									<a href=""><c:out value="${VenueVendor.Vendor}" default="cat soup"/></a>
								</div>
							</div>
							<div class="order_details">
								<a href="1202購物清單.html">
									<div class="wrapRowStart ">
										<p class="text">狀態</p>
										<div id="spacing"></div>
										<div id="status"><c:out value="${Order.PaymentStatus}" default="已完成"/></div>
									</div>
									<div class="wrapRowStart">
										<p class="text">寄往</p>
										<div id="spacing"></div>
										<div id="location">台灣</div>
									</div>
									<div class="wrapRowStart">
										<p class="text">訂單編號</p>
										<div id="spacing"></div>
										<div id="orderID"><c:out value="${Order.OrderID}" default="2018052500000"/></div>
									</div>
									<div class="wrapRowStart">
										<p class="text">總計</p>
										<div id="spacing"></div>
										<div id="orderTotal"><c:set var="subtotal" value="${OrderDetails.Subtotal}"/>NT$900</div>
									</div>
									<div class="wrapRowStart">
										<p class="text">購買項目</p>
										<div id="spacing"></div>
										<div id="img">
											<img src="" alt="">
										</div>
									</div>
								</a>
							</div>
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